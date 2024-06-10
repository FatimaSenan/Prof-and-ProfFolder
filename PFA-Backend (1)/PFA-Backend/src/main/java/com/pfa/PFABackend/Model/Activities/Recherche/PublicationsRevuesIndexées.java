package com.pfa.PFABackend.Model.Activities.Recherche;

import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PublicationsRevuesIndexées {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "activity_name")
    private String activityName;
    @Column(name = "activity_points")
    private double activityPoints;

    private String niveau;

    private String titre;

    private String auteurs;

    private String doi;

    private String lien;

    private String journal;

    private String isbn;

    @Column(name = "année_publication")
    private int annéePublication;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] justification;

    @ManyToOne
    @JoinColumn(name="activity_subtype2_id")
    private ActivitySubType2 activitySubType2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}

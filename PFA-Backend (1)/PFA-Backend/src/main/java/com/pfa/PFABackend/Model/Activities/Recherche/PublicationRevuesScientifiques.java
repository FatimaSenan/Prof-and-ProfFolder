package com.pfa.PFABackend.Model.Activities.Recherche;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PublicationRevuesScientifiques {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "activity_name")
    private String activityName;

    @Column(name = "activity_points")
    private double activityPoints;

    private String type;

    private String titre;

    private String auteurs;

    private String lien;

    private String journal;

    @Column(name = "isbn_issn")
    private String isbnIssn;

    @Column(name = "année_publication")
    private int annéePublication;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] justification;

    @ManyToOne
    @JoinColumn(name="activity_subtype2_id")
    @JsonBackReference
    private ActivitySubType2 activitySubType2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;
}

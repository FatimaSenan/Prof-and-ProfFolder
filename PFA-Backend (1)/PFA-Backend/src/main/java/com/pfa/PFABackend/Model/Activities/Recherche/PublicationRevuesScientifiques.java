package com.pfa.PFABackend.Model.Activities.Recherche;

import com.pfa.PFABackend.Model.ActivitySubType2;
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

    @OneToOne
    @JoinColumn(name="activity_subtype2_id")
    private ActivitySubType2 activitySubType2;
}

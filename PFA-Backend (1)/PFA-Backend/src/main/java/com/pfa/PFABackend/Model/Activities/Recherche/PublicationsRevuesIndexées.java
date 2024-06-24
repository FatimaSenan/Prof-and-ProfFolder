package com.pfa.PFABackend.Model.Activities.Recherche;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @Column(name = "points_attribués")
    private double pointsAttribués = 0;

    private String niveau;

    private String titre;

    private String auteurs;

    private String doi;

    private String lien;

    private String journal;

    private String isbn;

    @Column(name = "année_publication")
    private int annéePublication;

    private boolean evaluated = false;

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

    @PrePersist
    @PreUpdate
    public void updateActivityPoints() {
        if("Niveau 1: Impact factor<1)".equals(niveau)) {
            this.setActivityPoints(3);
        } else if("Niveau 2: Impact factor de 1 à <5".equals(niveau)) {
            this.setActivityPoints(5);
        } else if("Niveau 3: Impact factor 6 et +".equals(niveau)){
            activityPoints = 8;

        }else{
            activityPoints = 0;
        }
    }
}

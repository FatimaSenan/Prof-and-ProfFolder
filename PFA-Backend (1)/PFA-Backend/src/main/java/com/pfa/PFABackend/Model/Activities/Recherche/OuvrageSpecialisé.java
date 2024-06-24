package com.pfa.PFABackend.Model.Activities.Recherche;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class OuvrageSpecialisé {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "activity_name")
    private String activityName;

    @Column(name = "activity_points")
    private double activityPoints;

    @Column(name = "points_attribués")
    private double pointsAttribués = 0;


    private String titre;

    private String auteurs;

    private String isbn;

    @Column(name = "depot_legal")
    private String depotLegal;

    private String date;

    private String publicateur;

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
        if("Maison d'édition)".equals(publicateur)) {
            this.setActivityPoints(4);
        } else if("L'auteur lui meme".equals(publicateur)) {
            this.setActivityPoints(2);
        } else{
            activityPoints = 0;
        }
    }

}

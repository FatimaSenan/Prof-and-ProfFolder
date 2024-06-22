
package com.pfa.PFABackend.Model.Activities.Recherche;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProjetsContratsRecherche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "activity_name")
    private String activityName;
    @Column(name = "activity_points")
    private double activityPoints =2;

    @Column(name = "points_attribués")
    private double pointsAttribués = 0;

    @Column(name = "titre_projet")
    private String titreProjet;

    private String responsabilite;

    @Column(name = "cadre_projet")
    private String cadreProjet;

    private String type;


    private String période;




    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] justification;

    @ManyToOne
    @JoinColumn(name="activity_subtype2_id")
    @JsonBackReference
    private ActivitySubType2 activitySubType2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    //JsonBackReference
    private User user;

    @PrePersist
    @PreUpdate
    public void updateActivityPoints() {
        if("Responsable".equals(responsabilite)) {
            this.setActivityPoints(2);
        } else if("Membre".equals(responsabilite)) {
            this.setActivityPoints(1);
        } else{
            activityPoints = 0;
        }
    }
}

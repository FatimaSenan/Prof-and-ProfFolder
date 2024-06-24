package com.pfa.PFABackend.Model.Activities.Recherche;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ResponsableMembreStructureRecherchePole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "activity_name")
    private String activityName;
    @Column(name = "activity_points")
    private double activityPoints =2;

    @Column(name = "points_attribués")
    private double pointsAttribués = 0;

    @Column(name = "domaine_expertise")
    private String domainedExpertise;

    private String résponsabilité;


    private String années;


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
        if("Responsable".equals(résponsabilité)) {
            this.setActivityPoints(1.5);
        } else if("Membre".equals(résponsabilité)) {
            this.setActivityPoints(1);
        } else{
            activityPoints = 0;
        }
    }
}

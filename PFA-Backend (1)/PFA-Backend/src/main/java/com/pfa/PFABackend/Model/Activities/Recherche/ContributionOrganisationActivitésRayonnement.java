package com.pfa.PFABackend.Model.Activities.Recherche;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ContributionOrganisationActivitésRayonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "activity_name")
    private String activityName;
    @Column(name = "activity_points")
    private double activityPoints =2;

    @Column(name = "points_attribués")
    private double pointsAttribués = 0;

    @Column(name = "nom_conference")
    private String nomConférence;

    private String lien;

    private String type;

    private String role;

    @Column(name = "date_conference")
    private String dateConférence;

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
        if(("Responsable".equals(role) && "International".equals(type) )|| ("Prix de distinction".equals(role))) {
            this.setActivityPoints(1.5);
        } else if("Membre".equals(role) || "Membre organisateur".equals(role)) {
            this.setActivityPoints(0.5);
        }else if("Responsable".equals(role) && "Nationam".equals(type)) {
            this.setActivityPoints(1);
        } else{
            activityPoints = 0;
        }
    }
}

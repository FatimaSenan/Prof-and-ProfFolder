package com.pfa.PFABackend.Model.Activities.Recherche;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ParticipationthèseDoctorat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "activity_name")
    private String activityName;

    @Column(name = "activity_points")
    private double activityPoints;

    @Column(name = "points_attribués")
    private double pointsAttribués = 0;

    @Column(name = "type_participation")
    private String typeParticipation;



    private String sujet;

    private String doctorant;

    private String date;

    private String université;

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
        if("Président".equals(typeParticipation)) {
            this.setActivityPoints(0.5);
        } else if("Rapporteur".equals(typeParticipation)) {
            this.setActivityPoints(1);
        } else if("Membre".equals(typeParticipation)){
            activityPoints = 0.5;
        } else{
            activityPoints = 0;
        }
    }
}

package com.pfa.PFABackend.Model.Activities.Enseignement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CoordonateurFilière {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "activity_name")
    private String activityName;
    @Column(name = "activity_points")
    private double activityPoints;

    @Column(name = "points_attribués")
    private double pointsAttribués = 0;

    @Column(name = "nom_filière")
    private String nomFilière;

    private String etablissement;
    @Column(name = "années_responsabilités")
    private String annéesResposabilités;

    @Column(name = "type_filière")
    private String typeFilière;

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
        if("licence fondamentale (non cumulable avec le chef de département)".equals(typeFilière)) {
            this.setActivityPoints(2);
        } else if("Master ou cycle d'ingénieur ou autre cycle bac +5".equals(typeFilière) || "licence professionnelle ou DUT".equals(typeFilière)) {
            this.setActivityPoints(1.5);
        } else {
            activityPoints = 0;
        }
    }

}

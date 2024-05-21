package com.pfa.PFABackend.Model.Activities.Enseignement;

import com.pfa.PFABackend.Model.ActivitySubType2;
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
    @Column(name = "nom_filière")
    private String nomFilière;

    private String etablissement;
    @Column(name = "années_responsabilités")
    private String annéesResposabilités;

    @Column(name = "type_filière")
    private String typeFilière;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] justification;

    @OneToOne
    @JoinColumn(name="activity_subtype2_id")
    private ActivitySubType2 activitySubType2;

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

package com.pfa.PFABackend.Model.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.EnumTypes.TypeEncadrement;
import com.pfa.PFABackend.Model.ActivitySubType2;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class EncadrementPFE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "activity_name")
    private String activityName;
    @Column(name = "activity_points")
    private double activityPoints = 1;
    @Column(name = "titre_pfe")
    private String titrePFE;

    private String étudiants;

    private int année;

    private String filière;

    private String typeEncadrement;


    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] justification;

    @OneToOne
    @JoinColumn(name="activity_subtype2_id")
    private ActivitySubType2 activitySubType2;
}

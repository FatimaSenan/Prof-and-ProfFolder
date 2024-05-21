package com.pfa.PFABackend.Model.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.EnumTypes.TypeCommission;
import com.pfa.PFABackend.Model.ActivitySubType2;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class MembreCommissionEtablissement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "activity_name")
    private String activityName;
    @Column(name = "activity_points")
    private double activityPoints = 1;
    @Column(name = "titre_commission")
    private String titreCommission;


    private String typeCommission;

    private String période;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] justification;

    @OneToOne
    @JoinColumn(name="activity_subtype2_id")
    private ActivitySubType2 activitySubType2;
}

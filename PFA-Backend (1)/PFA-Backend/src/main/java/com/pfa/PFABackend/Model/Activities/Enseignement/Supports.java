package com.pfa.PFABackend.Model.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.EnumTypes.TypeSupport;
import com.pfa.PFABackend.Model.ActivitySubType2;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Supports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "activity_name")
    private String activityName;

    @Column(name = "activity_points")
    private double activityPoints = 1;

    private String titre;

    private String type;

    private String module;


    private int année;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "type_support")
    private TypeSupport typeSupport;

    private byte[] justification;

    @OneToOne
    @JoinColumn(name="activity_subtype2_id")
    private ActivitySubType2 activitySubType2;
}

package com.pfa.PFABackend.Model.Activities.Enseignement;

import com.pfa.PFABackend.Model.ActivitySubType2;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CoordonateurModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "activity_name")
    private String activityName;
    @Column(name = "activity_points")
    private double activityPoints = 1;

    private String filière;

    private String niveau;

    private String departement;

    private String etablissement;
    @Column(name = "années_responsabilités")
    private String annéesResposabilités;

    private byte[] justification;

    @OneToOne
    @JoinColumn(name="activity_subtype2_id")
    private ActivitySubType2 activitySubType2;
}

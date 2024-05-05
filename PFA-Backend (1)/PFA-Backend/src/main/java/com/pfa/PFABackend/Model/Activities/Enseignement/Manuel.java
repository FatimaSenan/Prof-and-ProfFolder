package com.pfa.PFABackend.Model.Activities.Enseignement;

import com.pfa.PFABackend.Model.ActivitySubType2;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Manuel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_manuel")
    private int idManuel;
    @Column(name="activity_name")
    private String activityName;
    @Column(name = "activity_points")
    private double activityPoints = 2;

    private String module;
    @Column(name="filière_niveau")
    private String filièreNiveau;
    @Column(name="année_universiatire")
    private int annéeUniversitaire;

    private byte[] justification;

    @OneToOne
    @JoinColumn(name="activity_subtype2_id")
    private ActivitySubType2 activitySubType2;




}

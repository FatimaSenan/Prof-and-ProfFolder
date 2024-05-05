package com.pfa.PFABackend.Model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;

@Entity
@Data
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_activity;

    @ManyToOne
    @JoinColumn(name = "activity_type_id", nullable = false)
    private ActivityType activityType;

    @ManyToOne
    @JoinColumn(name = "activity_subtype1_id", nullable = false)
    private ActivitySubType1 activitySubType1;

    @ManyToOne
    @JoinColumn(name = "activity_subtype2_id", nullable = false)
    private ActivitySubType2 activitySubType2;

   /* @ManyToMany
    @JoinColumn(name= "id_prof", nullable = false)
    private Set<Professor> profs = new HashSet<>();*/


    @Column(name="activity_name")
    private String activityName;

    @Column(name="activity_points")
    private int activityPoints;

}
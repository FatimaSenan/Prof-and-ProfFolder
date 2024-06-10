package com.pfa.PFABackend.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class ActivityType {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_type;

   /* @OneToMany(mappedBy = "activityType")
    private Set<Activity> activities = new HashSet<>();*/

    @OneToMany(mappedBy = "activityType")
    private Set<ActivitySubType1> activitySubtype1 = new HashSet<>();

    @OneToMany(mappedBy = "activityType")
    private Set<ActivitySubType2> activitySubtype2 = new HashSet<>();

    private String typeName;


    private int typePoints;


}
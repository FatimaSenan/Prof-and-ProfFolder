package com.pfa.PFABackend.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
@Data
@Entity
public class ActivitySubType1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_subtype1;

    @Column(name="subtype_name")
    private String subTypeName;

    @Column(name="subtype_points")
    private int subTypePoints;

  /* @OneToMany(mappedBy = "activitySubType1")
    private Set<Activity> activities = new HashSet<>();*/

    @ManyToOne
    @JoinColumn(name = "activity_type_id")
    private ActivityType activityType;

    @OneToMany(mappedBy = "activitySubType1")
    private Set<ActivitySubType2> activitySubTypes2 = new HashSet<>();


}
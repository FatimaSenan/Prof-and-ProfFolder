package com.pfa.PFABackend.Model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;

@Entity
@Data
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "activity_name")
    private String activityName;




   /* @ManyToMany
    @JoinColumn(name= "id_prof", nullable = false)
    private Set<Professor> profs = new HashSet<>();*/



   /* @ManyToOne
    @JoinColumn(name="activity_subtype2_id")
    private ActivitySubType2 activitySubType2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;*/

}
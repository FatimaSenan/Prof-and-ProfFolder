package com.pfa.PFABackend.Model.Activities.Enseignement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.File;
import com.pfa.PFABackend.Model.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class ChefDépartement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "activity_name")
    private String activityName;
    @Column(name = "activity_points")
    private double activityPoints =2;

    @Column(name = "points_attribués")
    private double pointsAttribués = 0;

    private String département;

    private String établissement;
    @Column(name = "années_responsabilités")
    private String annéesResposabilité;

    private boolean evaluated = false;


    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] justification;
   /* @OneToOne
    @JoinColumn(name="file_id")
    private File file;*/


    @ManyToOne
    @JoinColumn(name="activity_subtype2_id")
    @JsonBackReference
    private ActivitySubType2 activitySubType2;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;





}

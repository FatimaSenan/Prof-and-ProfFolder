package com.pfa.PFABackend.Model.Activities.Enseignement;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.File;
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

    private String département;

    private String établissement;
    @Column(name = "années_responsabilités")
    private String annéesResposabilité;


    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] justification;
   /* @OneToOne
    @JoinColumn(name="file_id")
    private File file;*/


    @OneToOne
    @JoinColumn(name="activity_subtype2_id")
    private ActivitySubType2 activitySubType2;





}

package com.pfa.PFABackend.Model.Activities.Enseignement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Ouvrage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "activity_name")
    private String activityName;

    @Column(name = "activity_points")
    private double activityPoints = 3;

    @Column(name = "points_attribués")
    private double pointsAttribués = 0;

    @Column(name = "titre_ouvrage")
    public String titreOuvrage;

    private String auteurs;

    private String isbn;

    @Column(name = "depot_legal")
    private String depotLegal;

    @Column(name = "maison_edition")
    private String maisonEdition;

    @Column(name = "année_publication")
    private int annéePublication;

    private boolean evaluated = false;


    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] justification;

    @ManyToOne
    @JoinColumn(name="activity_subtype2_id")
    @JsonBackReference
    private ActivitySubType2 activitySubType2 ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;



}

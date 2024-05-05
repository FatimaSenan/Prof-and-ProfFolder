package com.pfa.PFABackend.Model;

import com.pfa.PFABackend.Model.Activities.Enseignement.*;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
@Data
@Entity
public class ActivitySubType2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_subtype2;

    @Column(name="subtype_name")
    private String subTypeName;

    @Column(name="subtype_points")
    private int SubTypePoints;

    @OneToMany(mappedBy = "activitySubType2")
    private Set<Activity> activities = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "activity_type_id")
    private ActivityType activityType;

    @ManyToOne
    @JoinColumn(name = "activity_sub_type1_id")
    private ActivitySubType1 activitySubType1;

    @OneToOne(mappedBy = "activitySubType2")
    private Ouvrage ouvrage;

    @OneToOne(mappedBy = "activitySubType2")
    private Manuel manuel ;

    @OneToOne(mappedBy = "activitySubType2")
    private PolycopiésPédagogiques polycopiésPédagogiques;
    @OneToOne(mappedBy = "activitySubType2")
    private PetitsLivres petitsLivres;

    @OneToOne(mappedBy = "activitySubType2")
    private MontagesExpérimentaux montagesExpérimentaux;

    @OneToOne(mappedBy = "activitySubType2")
    private PréparationSortiesTerrain préparationSortiesTerrains;

    @OneToOne(mappedBy = "activitySubType2")
    private Supports supports;

    @OneToOne(mappedBy = "activitySubType2")
    private Didacticiels didacticiels;

    @OneToOne(mappedBy = "activitySubType2")
    private PageWeb pageWeb;

    @OneToOne(mappedBy = "activitySubType2")
    private MOOC moocs;

    @OneToOne(mappedBy = "activitySubType2")
    private EncadrementPFE encadrementsPFE;

    @OneToOne(mappedBy = "activitySubType2")
    private RapportStageVisiteTerrain rapportStageVisiteTerrain;

    @OneToOne(mappedBy = "activitySubType2")
    private EncadrementRH encadrementRH;

    @OneToOne(mappedBy = "activitySubType2")
    private CoordonateurFilière coordonateurFilière;

    @OneToOne(mappedBy = "activitySubType2")
    private CoordonateurModule coordonateurModule;

    @OneToOne(mappedBy = "activitySubType2")
    private ChefDépartement chefDépartement;

    @OneToOne(mappedBy = "activitySubType2")
    private ViceDoyen viceDoyens;

    @OneToOne(mappedBy = "activitySubType2")
    private MembreEluConseil membreEluConseil;

    @OneToOne(mappedBy = "activitySubType2")
    private MembreCommissionEtablissement membreCommissionEtablissement;

    @OneToOne(mappedBy = "activitySubType2")
    private MembreConseilCoordination membreConseilCoordination;

    @OneToOne(mappedBy = "activitySubType2")
    private MembreCommissionConseil membreCommissionConseil;

    @OneToOne(mappedBy = "activitySubType2")
    private MembreCommissionAdHoc membreCommissionAdHoc;
}

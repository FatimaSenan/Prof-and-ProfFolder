package com.pfa.PFABackend.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pfa.PFABackend.Model.Activities.Enseignement.*;
import com.pfa.PFABackend.Model.Activities.Recherche.*;
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

   /* @OneToMany(mappedBy = "activitySubType2")
    private Set<Activity> activities = new HashSet<>();*/

    @ManyToOne
    @JoinColumn(name = "activity_type_id")
    private ActivityType activityType;

    @ManyToOne
    @JoinColumn(name = "activity_sub_type1_id")
    private ActivitySubType1 activitySubType1;

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<Ouvrage> ouvrages = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<Manuel> manuels = new HashSet<>() ;

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<PolycopiésPédagogiques> polycopiésPédagogiques = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<PetitsLivres> petitsLivres = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<MontagesExpérimentaux> montagesExpérimentaux = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<PréparationSortiesTerrain> préparationSortiesTerrains = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<Supports> supports = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<Didacticiels> didacticiels = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<PageWeb> pageWebs = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<MOOC> moocs = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<EncadrementPFE> encadrementsPFE = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<RapportStageVisiteTerrain> rapportStageVisiteTerrain = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<EncadrementRH> encadrementRH = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<CoordonateurFilière> coordonateurFilière = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<CoordonateurModule> coordonateurModule = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<ChefDépartement> chefDépartement = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<ViceDoyen> viceDoyens = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<MembreEluConseil> membreEluConseil = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<MembreCommissionEtablissement> membreCommissionEtablissement = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<MembreConseilCoordination> membreConseilCoordination = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<MembreCommissionConseil> membreCommissionConseil = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<MembreCommissionAdHoc> membreCommissionAdHoc = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<ChapitreOuvrage> chapitreOuvrage = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<CongrèsConférencesPubliées> congrèsConférencesPubliées = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<CongrèsConférencesNonPubliées> congrèsConférencesNonPubliées = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<DoctoratsEncadrés> doctoratsEncadrés = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<EncadrementMémoiresMaster> encadrementMémoiresMaster = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<OuvrageSpecialisé> ouvrageSpecialisé = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<ParticipationthèseDoctorat> participationthèseDoctorat = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<PublicationRevuesScientifiques> publicationRevuesScientifiques = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    @JsonManagedReference
    private Set<PublicationsRevuesIndexées> publicationsRevuesIndexées = new HashSet<>();
}

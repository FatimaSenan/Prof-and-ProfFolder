package com.pfa.PFABackend.Model;

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

    @OneToMany(mappedBy = "activitySubType2")
    private Set<Activity> activities = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "activity_type_id")
    private ActivityType activityType;

    @ManyToOne
    @JoinColumn(name = "activity_sub_type1_id")
    private ActivitySubType1 activitySubType1;

    @OneToMany(mappedBy = "activitySubType2")
    private Set<Ouvrage> ouvrages = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    private Set<Manuel> manuels = new HashSet<>() ;

    @OneToMany(mappedBy = "activitySubType2")
    private Set<PolycopiésPédagogiques> polycopiésPédagogiques = new HashSet<>();
    @OneToMany(mappedBy = "activitySubType2")
    private Set<PetitsLivres> petitsLivres = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    private Set<MontagesExpérimentaux> montagesExpérimentaux = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    private Set<PréparationSortiesTerrain> préparationSortiesTerrains = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    private Set<Supports> supports = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    private Set<Didacticiels> didacticiels = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    private Set<PageWeb> pageWebs = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    private Set<MOOC> moocs = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    private Set<EncadrementPFE> encadrementsPFE = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    private Set<RapportStageVisiteTerrain> rapportStageVisiteTerrain = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    private Set<EncadrementRH> encadrementRH = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    private Set<CoordonateurFilière> coordonateurFilière = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    private Set<CoordonateurModule> coordonateurModule = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    private Set<ChefDépartement> chefDépartement = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    private Set<ViceDoyen> viceDoyens = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    private Set<MembreEluConseil> membreEluConseil = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    private Set<MembreCommissionEtablissement> membreCommissionEtablissement = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    private Set<MembreConseilCoordination> membreConseilCoordination = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    private Set<MembreCommissionConseil> membreCommissionConseil = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    private Set<MembreCommissionAdHoc> membreCommissionAdHoc = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    private Set<ChapitreOuvrage> chapitreOuvrage = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    private Set<CongrèsConférencesPubliées> congrèsConférencesPubliées = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    private Set<CongrèsConférencesNonPubliées> congrèsConférencesNonPubliées = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    private Set<DoctoratsEncadrés> doctoratsEncadrés = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    private Set<EncadrementMémoiresMaster> encadrementMémoiresMaster = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    private Set<OuvrageSpecialisé> ouvrageSpecialisé = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    private Set<ParticipationthèseDoctorat> participationthèseDoctorat = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    private Set<PublicationRevuesScientifiques> publicationRevuesScientifiques = new HashSet<>();

    @OneToMany(mappedBy = "activitySubType2")
    private Set<PublicationsRevuesIndexées> publicationsRevuesIndexées = new HashSet<>();
}

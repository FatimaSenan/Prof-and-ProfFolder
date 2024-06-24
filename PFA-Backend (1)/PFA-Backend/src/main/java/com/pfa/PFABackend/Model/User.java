package com.pfa.PFABackend.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pfa.PFABackend.Model.Activities.Enseignement.*;
import com.pfa.PFABackend.Model.Activities.Recherche.*;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name ="users")
@Data
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstname;

    private String lastname;

    private String email;

    private String password;

    private String role;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private ProfessorFolder professorFolder;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Annexe3> annexe3List = new ArrayList<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Annexe2 annexe2;

   @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
   @JsonIgnore
   @JsonManagedReference(value = "chefDepartementeReference")
    private List<ChefDépartement> chefDepartementList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "coordonateurFilièreReference")
    private List<CoordonateurFilière> coordonateurFilièreList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "coordonateurModuleReference")
    private List<CoordonateurModule> coordonateurModuleList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "didacticielsReference")
    private List<Didacticiels> didacticielsList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "encadrementPFEReference")
    private List<EncadrementPFE> encadrementPFEList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "encadrementRHReference")
    private List<EncadrementRH> encadrementRHList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "manuelReference")
    private List<Manuel> manuelList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference("membreCommissionAdHocReference")
    private List<MembreCommissionAdHoc> membreCommissionAdHocList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "membreCommissionConseilRefrence")
    private List<MembreCommissionConseil> membreCommissionConseilList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "membreCommissionEtablissementReference")
    private List<MembreCommissionEtablissement> membreCommissionEtablissementList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "membreConseilCoordinationReference")
    private List<MembreConseilCoordination> membreConseilCoordinationList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "membreEluConseilReference")
    private List<MembreEluConseil> membreEluConseilList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "montagesExpérimentauxReference")
    private List<MontagesExpérimentaux> montagesExpérimentauxList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "moocReference")
    private List<MOOC> moocList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "ouvrageReference")
    private List<Ouvrage> ouvrageList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "pageWebReference")
    private List<PageWeb> pageWebList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "petitsLivresReference")
    private List<PetitsLivres> petitsLivresList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "polycopiésPédagogiquesReference")
    private List<PolycopiésPédagogiques> polycopiésPédagogiquesList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "préparationSortiesTerrainReference")
    private List<PréparationSortiesTerrain> préparationSortiesTerrainList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "rapportStageVisiteTerrainReference")
    private List<RapportStageVisiteTerrain> rapportStageVisiteTerrainList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "supportsReference")
    private List<Supports> supportsList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "viceDoyenReference")
    private List<ViceDoyen> viceDoyenList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "associationConnaissanceReference")
    private List<AssociationConnaissance> associationConnaissanceList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "brevetReference")
    private List<Brevet> brevetList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "chapitreOvrageReference")
    private List<ChapitreOuvrage> chapitreOuvrageList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "congrèsConférencesNonPubliéesReference")
    private List<CongrèsConférencesNonPubliées> congrèsConférencesNonPubliéesList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "congrèsConférencesPubliéesReference")
    private List<CongrèsConférencesPubliées> congrèsConférencesPubliéesList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "contributionOrganisationActivitésRayonnementReference")
    private List<ContributionOrganisationActivitésRayonnement> contributionOrganisationActivitésRayonnementList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "créationStartUpReference")
    private List<CréationStartUp> créationStartUpList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "doctoratsEncadrésReference")
    private List<DoctoratsEncadrés> doctoratsEncadrésList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "editeurMembreRéféréJournalRevuesReference")
    private List<EditeurMembreRéféréJournalRevue> editeurMembreRéféréJournalRevuesList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "encadrementMémoiresMasterReference")
    private List<EncadrementMémoiresMaster> encadrementMémoiresMasterList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "expertiseNonRémunéréReference")
    private List<ExpertiseNonRémunéré> expertiseNonRémunéréList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "incubationProjetRechercheReference")
    private List<IncubationProjetRecherche> incubationProjetRechercheList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "ovragesSpecialiséReference")
    private List<OuvrageSpecialisé> ouvrageSpecialiséList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "participationthèseDoctoratReference")
    private List<ParticipationthèseDoctorat> participationthèseDoctoratList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "projetDeRechercheDeveloppementReference")
    private List<ProjetDeRechercheDeveloppement> projetDeRechercheDeveloppementList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "projetsContratsRechercheReference")
    private List<ProjetsContratsRecherche> projetsContratsRechercheList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "publicationRevuesScientifiquesReference")
    private List<PublicationRevuesScientifiques> publicationRevuesScientifiquesList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "publicationsRevuesIndexéesReference")
    private List<PublicationsRevuesIndexées> publicationsRevuesIndexéesList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @JsonManagedReference(value = "responsableMembreStructureRecherchePoleReference")
    private List<ResponsableMembreStructureRecherchePole> responsableMembreStructureRecherchePoleList = new ArrayList<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

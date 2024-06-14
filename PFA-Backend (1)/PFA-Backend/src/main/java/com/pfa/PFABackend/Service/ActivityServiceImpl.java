package com.pfa.PFABackend.Service;

import com.pfa.PFABackend.Model.Activities.Enseignement.ChefDépartement;
import com.pfa.PFABackend.Model.Activities.Enseignement.EncadrementPFE;
import com.pfa.PFABackend.Model.Activities.Recherche.AssociationConnaissance;
import com.pfa.PFABackend.Model.Activities.Recherche.Brevet;
import com.pfa.PFABackend.Model.Activities.Recherche.ChapitreOuvrage;
import com.pfa.PFABackend.Model.Activity;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Enseignement.*;
import com.pfa.PFABackend.Repository.Activities.Recherche.*;
import com.pfa.PFABackend.Repository.ActivityRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
public class ActivityServiceImpl implements ActivityService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChefDépartementRepository chefDépartementRepository;

    @Autowired
    private CoordonateurFilièreRepository coordonateurFilièreRepository;

    @Autowired
    private CoordonateurModuleRepository coordonateurModuleRepository;

    @Autowired
    private DidacticielsRepository didacticielsRepository;

    @Autowired
    private EncadrementPFERepository encadrementPFERepository;

    @Autowired
    private EncadrementRHRepository encadrementRHRepository;

    @Autowired
    private ManuelRepository manuelRepository;


    @Autowired
    private MembreCommissionAdHocRepository membreCommissionAdHocRepository;

    @Autowired
    private  MembreCommissionConseilRepository membreCommissionConseilRepository;

    @Autowired
    private MembreCommisionEtablissementRepository membreCommisionEtablissementRepository;

    @Autowired
    private  MembreConseilCoordinationRepository membreConseilCoordinationRepository;

    @Autowired
    private MembreEluConseilRepository membreEluConseilRepository;

    @Autowired
    private MontagesExpérimentauxRepository montagesExpérimentauxRepository;

    @Autowired
    private MOOCRepository moocRepository;

    @Autowired
    private OuvrageRepository ouvrageRepository;

    @Autowired
    private PageWebRepository pageWebRepository;

    @Autowired
    private PetitsLivresRepository petitsLivresRepository;

    @Autowired
    private PolycopiésPédagogiquesRepository polycopiésPédagogiquesRepository;

    @Autowired
    private PréparationSortiesTerrainRepository préparationSortiesTerrainRepository;

    @Autowired
    private RapportStageVisiteTerrainRepository rapportStageVisiteTerrainRepository;

    @Autowired
    private SupportsRepository supportsRepository;

    @Autowired
    private ViceDoyenRepository viceDoyenRepository;

    @Autowired
    private AssociationConnaissanceRepository associationConnaissanceRepository;

    @Autowired
    private BrevetRepository brevetRepository;

    @Autowired
    private ChapitreOuvrageRepository chapitreOuvrageRepository;

    @Autowired
    private CongrèsConférencesNonPubliéesRepository congrèsConférencesNonPubliéesRepository;

    @Autowired
    private CongrèsConférencesPubliéesRepository congrèsConférencesPubliéesRepository;

    @Autowired
    private ContributionOrganisationActivitésRayonnementRepository contributionOrganisationActivitésRayonnementRepository;

    @Autowired
    private CréationStartUpRepository créationStartUpRepository;

    @Autowired
    private DoctoratsEncadrésRepository doctoratsEncadrésRepository;

    @Autowired
    private EditeurMembreRéféréJournalRevueRepository editeurMembreRéféréJournalRevueRepository;

    @Autowired
    private EncadrementMémoiresMasterRepository encadrementMémoiresMasterRepository;

    @Autowired
    private ExpertiseNonRémunéréRepository expertiseNonRémunéréRepository;

    @Autowired
    private IncubationProjetRechercheRepository incubationProjetRechercheRepository;

    @Autowired
    private OuvrageSpecialiséRepository ouvrageSpecialiséRepository;

    @Autowired
    private ParticipationthèseDoctoratRepository participationthèseDoctoratRepository;

    @Autowired
    private ProjetDeRechercheDeveloppementRepository projetDeRechercheDeveloppementRepository;

    @Autowired
    private ProjetsContratsRechercheRepository projetsContratsRechercheRepository;

    @Autowired
    private PublicationRevuesScientifiquesRepository publicationRevuesScientifiquesRepository;

    @Autowired
    private PublicationsRevuesIndexéesRepository publicationsRevuesIndexéesRepository;

    @Autowired
    private ResponsableMembreStructureRechercheAccréditéePoleCompetenceRepository responsableMembreStructureRechercheAccréditéePoleCompetenceRepository;




    @Override
    public List<List<?>> getAllActivitiesForCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));

       List<List<?>> activities = new ArrayList<>();
        activities.add((List<?>) chefDépartementRepository.findByUser(user));
        activities.add((List<?>) coordonateurFilièreRepository.findByUser(user));
        activities.add((List<?>) coordonateurModuleRepository.findByUser(user));
        activities.add((List<?>) didacticielsRepository.findByUser(user));
        activities.add((List<?>) encadrementPFERepository.findByUser(user));
        activities.add((List<?>) encadrementRHRepository.findByUser(user));
        activities.add((List<?>) manuelRepository.findByUser(user));
        activities.add((List<?>) membreCommissionAdHocRepository.findByUser(user));
        activities.add((List<?>) membreCommissionConseilRepository.findByUser(user));
        activities.add((List<?>) membreCommisionEtablissementRepository.findByUser(user));
        activities.add((List<?>) membreConseilCoordinationRepository.findByUser(user));
        activities.add((List<?>) membreEluConseilRepository.findByUser(user));
        activities.add((List<?>) montagesExpérimentauxRepository.findByUser(user));
        activities.add((List<?>) moocRepository.findByUser(user));
        activities.add((List<?>) ouvrageRepository.findByUser(user));
        activities.add((List<?>) pageWebRepository.findByUser(user));
        activities.add((List<?>) petitsLivresRepository.findByUser(user));
        activities.add((List<?>) polycopiésPédagogiquesRepository.findByUser(user));
        activities.add((List<?>) préparationSortiesTerrainRepository.findByUser(user));
        activities.add((List<?>) rapportStageVisiteTerrainRepository.findByUser(user));
        activities.add((List<?>) supportsRepository.findByUser(user));
        activities.add((List<?>) viceDoyenRepository.findByUser(user));
        activities.add((List<?>) associationConnaissanceRepository.findByUser(user));
        activities.add((List<?>) brevetRepository.findByUser(user));
        activities.add((List<?>) chapitreOuvrageRepository.findByUser(user));
        activities.add((List<?>) congrèsConférencesNonPubliéesRepository.findByUser(user));
        activities.add((List<?>) congrèsConférencesPubliéesRepository.findByUser(user));
        activities.add((List<?>) contributionOrganisationActivitésRayonnementRepository.findByUser(user));
        activities.add((List<?>) créationStartUpRepository.findByUser(user));
        activities.add((List<?>) doctoratsEncadrésRepository.findByUser(user));
        activities.add((List<?>) editeurMembreRéféréJournalRevueRepository.findByUser(user));
        activities.add((List<?>) encadrementMémoiresMasterRepository.findByUser(user));
        activities.add((List<?>) expertiseNonRémunéréRepository.findByUser(user));
        activities.add((List<?>) incubationProjetRechercheRepository.findByUser(user));
        activities.add((List<?>) ouvrageSpecialiséRepository.findByUser(user));
        activities.add((List<?>) participationthèseDoctoratRepository.findByUser(user));
        activities.add((List<?>) projetsContratsRechercheRepository.findByUser(user));
        activities.add((List<?>) publicationRevuesScientifiquesRepository.findByUser(user));
        activities.add((List<?>) publicationsRevuesIndexéesRepository.findByUser(user));
        activities.add((List<?>) responsableMembreStructureRechercheAccréditéePoleCompetenceRepository.findByUser(user));

        return activities.stream()
                .filter(a -> a != null && !a.isEmpty())
                .collect(Collectors.toList());
    }
  /*  @Autowired
    private ActivityRepository activityRepository;
    @Override
    public void saveActivity(Activity activity) {
        activityRepository.save(activity);
    }

    @Override
    public Iterable<Activity> getActivities() {
        return activityRepository.findAll();
    }*/
}

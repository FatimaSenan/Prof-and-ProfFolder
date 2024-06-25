package com.pfa.PFABackend.Service;

import com.pfa.PFABackend.Model.*;
import com.pfa.PFABackend.Model.Activities.Enseignement.*;
import com.pfa.PFABackend.Model.Activities.Recherche.*;
import com.pfa.PFABackend.Repository.Activities.Enseignement.*;
import com.pfa.PFABackend.Repository.Activities.Recherche.*;
import com.pfa.PFABackend.Repository.ActivityRepository;
import com.pfa.PFABackend.Repository.ActivitySubType1Repository;
import com.pfa.PFABackend.Repository.ActivitySubType2Repository;
import com.pfa.PFABackend.Repository.UserRepository;
import com.pfa.PFABackend.Service.Activities.Recherche.PublicationsRevuesIndexéesService;
import org.hibernate.engine.profile.Association;
import org.hibernate.query.Page;
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
    private ActivitySubType2Repository activitySubType2Repository;

    @Autowired
    private ActivitySubType1Repository activitySubType1Repository;

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

    @Override
    public List<List<?>> getAllActivitiesForSelectedUser(String userEmail) {
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));;
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

    public String deleteSelectedActivityForCurrentUser(String activityName, int activityId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));

        switch (activityName) {
            case "Ouvrage pédagogique et/ou didactique (ISBN ou  Maison d'édition)":
                Ouvrage ouvrage = ouvrageRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!ouvrage.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                ouvrageRepository.deleteById(activityId);
                break;
            case "Manuel ( exercices corrigés, annales examens corrigés, etc.) (ISBN, ou validé par le chef d'établissement)":
                Manuel manuel = manuelRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!manuel.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }

                manuelRepository.deleteById(activityId);
                break;
            case "Polycopiés pédagogiques":
                PolycopiésPédagogiques polycopiésPédagogiques = polycopiésPédagogiquesRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!polycopiésPédagogiques.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                polycopiésPédagogiquesRepository.deleteById(activityId);
                break;
            case "Petits livres de méthodologie ou de didactique pour la lecture ou l'analyse":
                PetitsLivres petitsLivres= petitsLivresRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!petitsLivres.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                petitsLivresRepository.deleteById(activityId);
                break;
            case "Montages expérimentaux":
                MontagesExpérimentaux montagesExpérimentaux = montagesExpérimentauxRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!montagesExpérimentaux.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                montagesExpérimentauxRepository.deleteById(activityId);
                break;
            case "Préparation de sorties de terrain":
                PréparationSortiesTerrain préparationSortiesTerrain = préparationSortiesTerrainRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!préparationSortiesTerrain.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                préparationSortiesTerrainRepository.deleteById(activityId);
                break;
            case "Supports":
                Supports supports= supportsRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!supports.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                supportsRepository.deleteById(activityId);
                break;
            case "Didacticiels":
               Didacticiels didacticiels = didacticielsRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!didacticiels.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                didacticielsRepository.deleteById(activityId);
                break;
            case "Page web à caractère pédagogique":
                PageWeb pageWeb = pageWebRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!pageWeb.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                pageWebRepository.deleteById(activityId);
                break;
            case "MOOC : Production de contenus en ligne":
                MOOC mooc = moocRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!mooc.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                moocRepository.deleteById(activityId);
                break;
            case "Coordonnateur d'une filière":
                CoordonateurFilière coordonateurFilière = coordonateurFilièreRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!coordonateurFilière.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                coordonateurFilièreRepository.deleteById(activityId);
                break;
            case "Coordonnateur d'un module (ou deux au maximum )":
                CoordonateurModule coordonateurModule = coordonateurModuleRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!coordonateurModule.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                coordonateurModuleRepository.deleteById(activityId);
                break;
            case "Chef de département":
               ChefDépartement chefDépartement = chefDépartementRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!chefDépartement.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                chefDépartementRepository.deleteById(activityId);
                break;
            case "Vice-doyen ( non cumulable avec commission permanente)":
                ViceDoyen viceDoyen = viceDoyenRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!viceDoyen.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                viceDoyenRepository.deleteById(activityId);
                break;
            case "Membre élu du conseil d'établissement":
                MembreEluConseil membreEluConseil= membreEluConseilRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!membreEluConseil.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                membreEluConseilRepository.deleteById(activityId);
                break;
            case "Membre d'une commission permanente de l'établissement":
                MembreCommissionEtablissement membreCommissionEtablissement = membreCommisionEtablissementRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!membreCommissionEtablissement.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                membreCommisionEtablissementRepository.deleteById(activityId);
                break;
            case "Membre du conseil de coordination":
                MembreConseilCoordination membreConseilCoordination = membreConseilCoordinationRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!membreConseilCoordination.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                membreConseilCoordinationRepository.deleteById(activityId);
                break;
            case "Membre d'une commission permanente du conseil de coordination":
               MembreCommissionConseil membreCommissionConseil= membreCommissionConseilRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!membreCommissionConseil.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                membreCommissionConseilRepository.deleteById(activityId);
                break;
            case "Membre d'une commission ad hoc":
                MembreCommissionAdHoc membreCommissionAdHoc = membreCommissionAdHocRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!membreCommissionAdHoc.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                membreCommissionAdHocRepository.deleteById(activityId);
                break;
            case "Mémoire de PFE":
                EncadrementPFE encadrementPFE = encadrementPFERepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!encadrementPFE.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                encadrementPFERepository.deleteById(activityId);
                break;
            case "Rapport de stage de visite ou de terrain":
                RapportStageVisiteTerrain rapportStageVisiteTerrain = rapportStageVisiteTerrainRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!rapportStageVisiteTerrain.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                rapportStageVisiteTerrainRepository.deleteById(activityId);
                break;
            case "Formation de formateurs ou du Personnel administratif ou technique":
                EncadrementRH encadrementRH = encadrementRHRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!encadrementRH.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                encadrementRHRepository.deleteById(activityId);
                break;
            case "Publications dans des revues indexées dans les bases internationales  comme: SCOPUS, THOMPSON":
                PublicationsRevuesIndexées publicationsRevuesIndexées = publicationsRevuesIndexéesRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!publicationsRevuesIndexées.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                publicationsRevuesIndexéesRepository.deleteById(activityId);
                break;
            case "Publications dans des revues scientifiques nationales ou internationales à comité de lecture ISSN (tel qu'il est défini  dans la liste officielle du CNRST)":
                PublicationRevuesScientifiques publicationRevuesScientifiques = publicationRevuesScientifiquesRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!publicationRevuesScientifiques.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                publicationRevuesScientifiquesRepository.deleteById(activityId);
                break;
            case "Ouvrage spécialisé ISBN et publié par une maison d'édition":
                OuvrageSpecialisé ouvrageSpecialisé = ouvrageSpecialiséRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!ouvrageSpecialisé.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                ouvrageSpecialiséRepository.deleteById(activityId);
                break;
            case "Chapitre d'un ouvrage collectif publié par une maison d'édition ISBN":
                ChapitreOuvrage chapitreOuvrage = chapitreOuvrageRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!chapitreOuvrage.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                chapitreOuvrageRepository.deleteById(activityId);
                break;
            case "Congrès ou conférence (rédigées et publiées dans le Proceeding)(Les communications ne peuvent être comptabilisées qu'une seule fois)":
               CongrèsConférencesPubliées congrèsConférencesPubliées = congrèsConférencesPubliéesRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!congrèsConférencesPubliées.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                congrèsConférencesPubliéesRepository.deleteById(activityId);
                break;
            case "Communications dans des congrès ou des conférences (non publiés)":
               CongrèsConférencesNonPubliées congrèsConférencesNonPubliées = congrèsConférencesNonPubliéesRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!congrèsConférencesNonPubliées.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                congrèsConférencesNonPubliéesRepository.deleteById(activityId);
                break;
            case "Doctorats encadrés":
                DoctoratsEncadrés doctoratsEncadrés = doctoratsEncadrésRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!doctoratsEncadrés.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                doctoratsEncadrésRepository.deleteById(activityId);
                break;
            case "Encadrement des mémoires de Master":
                EncadrementMémoiresMaster encadrementMémoiresMaster= encadrementMémoiresMasterRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!encadrementMémoiresMaster.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                encadrementMémoiresMasterRepository.deleteById(activityId);
                break;
            case "Participaction à thèse doctorat ou d'habilitation":
                ParticipationthèseDoctorat participationthèseDoctorat = participationthèseDoctoratRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!participationthèseDoctorat.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                participationthèseDoctoratRepository.deleteById(activityId);
                break;
            case "Responsable ou membre d'une structure de recherche accréditée ou d'un pole de compétence(cumulable)":
                ResponsableMembreStructureRecherchePole responsableMembreStructureRecherchePole = responsableMembreStructureRechercheAccréditéePoleCompetenceRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!responsableMembreStructureRecherchePole.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                responsableMembreStructureRechercheAccréditéePoleCompetenceRepository.deleteById(activityId);
                break;
            case "Association pour la connaissance":
                AssociationConnaissance associationConnaissance = associationConnaissanceRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!associationConnaissance.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                associationConnaissanceRepository.deleteById(activityId);
                break;
            case "Projets ou contrats de recherche au niveau national ou international ou les deux":
                ProjetsContratsRecherche projetsContratsRecherche = projetsContratsRechercheRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!projetsContratsRecherche.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                projetsContratsRechercheRepository.deleteById(activityId);
                break;
            case "Editeur, membre ou référé d'un journal ou revue scientifique":
                EditeurMembreRéféréJournalRevue editeurMembreRéféréJournalRevue = editeurMembreRéféréJournalRevueRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!editeurMembreRéféréJournalRevue.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                editeurMembreRéféréJournalRevueRepository.deleteById(activityId);
                break;
            case "Expertise non rémunérée de projet de recherche scientifique":
                ExpertiseNonRémunéré expertiseNonRémunéré = expertiseNonRémunéréRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!expertiseNonRémunéré.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                expertiseNonRémunéréRepository.deleteById(activityId);
                break;
            case "Contribution à l'organisation d'activités de rayonnement de l'établissement (séminaires, congrès, colloque, ateliers, formation continue, ou autre)":
                ContributionOrganisationActivitésRayonnement contributionOrganisationActivitésRayonnement = contributionOrganisationActivitésRayonnementRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!contributionOrganisationActivitésRayonnement.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                contributionOrganisationActivitésRayonnementRepository.deleteById(activityId);
                break;
            case "Projet de recherche et de développement avec le secteur privé":
                ProjetDeRechercheDeveloppement projetDeRechercheDeveloppement = projetDeRechercheDeveloppementRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!projetDeRechercheDeveloppement.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                projetDeRechercheDeveloppementRepository.deleteById(activityId);
                break;
            case "Brevet":
                Brevet brevet = brevetRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!brevet.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                brevetRepository.deleteById(activityId);
                break;
            case "Incubation de projet de recherche et de développement":
                IncubationProjetRecherche incubationProjetRecherche = incubationProjetRechercheRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!incubationProjetRecherche.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                incubationProjetRechercheRepository.deleteById(activityId);
                break;
            case "Création de start up":
                CréationStartUp créationStartUp = créationStartUpRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!créationStartUp.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                créationStartUpRepository.deleteById(activityId);
                break;
            default:
                throw new IllegalArgumentException("Unknown activity type: "+ activityName);
        }
        return "Activity "+activityName+" was successfully deleted!";
    }

    @Override
    public byte[] getJustificationPdf(String activityName, int activityId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));

        switch (activityName) {
            case "Ouvrage pédagogique et/ou didactique (ISBN ou  Maison d'édition)":
                Ouvrage ouvrage = ouvrageRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!ouvrage.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get jstification");
                }
                 return ouvrage.getJustification();

            case "Manuel ( exercices corrigés, annales examens corrigés, etc.) (ISBN, ou validé par le chef d'établissement)":
                Manuel manuel = manuelRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!manuel.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }

                return manuel.getJustification();

            case "Polycopiés pédagogiques":
                PolycopiésPédagogiques polycopiésPédagogiques = polycopiésPédagogiquesRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!polycopiésPédagogiques.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return polycopiésPédagogiques.getJustification();

            case "Petits livres de méthodologie ou de didactique pour la lecture ou l'analyse":
                PetitsLivres petitsLivres= petitsLivresRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!petitsLivres.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return petitsLivres.getJustification();

            case "Montages expérimentaux":
                MontagesExpérimentaux montagesExpérimentaux = montagesExpérimentauxRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!montagesExpérimentaux.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return montagesExpérimentaux.getJustification();

            case "Préparation de sorties de terrain":
                PréparationSortiesTerrain préparationSortiesTerrain = préparationSortiesTerrainRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!préparationSortiesTerrain.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return préparationSortiesTerrain.getJustification();

            case "Supports":
                Supports supports= supportsRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!supports.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return supports.getJustification();

            case "Didacticiels":
                Didacticiels didacticiels = didacticielsRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!didacticiels.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return didacticiels.getJustification();

            /*case "Page web à caractère pédagogique":
                PageWeb pageWeb = pageWebRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!pageWeb.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return ;
                break;*/
           /* case "MOOC : Production de contenus en ligne":
                MOOC mooc = moocRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!mooc.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                mooc.get;
                break;*/
            case "Coordonnateur d'une filière":
                CoordonateurFilière coordonateurFilière = coordonateurFilièreRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!coordonateurFilière.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return coordonateurFilière.getJustification();

            case "Coordonnateur d'un module (ou deux au maximum )":
                CoordonateurModule coordonateurModule = coordonateurModuleRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!coordonateurModule.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return coordonateurModule.getJustification();

            case "Chef de département":
                ChefDépartement chefDépartement = chefDépartementRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!chefDépartement.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return chefDépartement.getJustification();

            case "Vice-doyen ( non cumulable avec commission permanente)":
                ViceDoyen viceDoyen = viceDoyenRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!viceDoyen.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return viceDoyen.getJustification();

            case "Membre élu du conseil d'établissement":
                MembreEluConseil membreEluConseil= membreEluConseilRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!membreEluConseil.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return membreEluConseil.getJustification();

            case "Membre d'une commission permanente de l'établissement":
                MembreCommissionEtablissement membreCommissionEtablissement = membreCommisionEtablissementRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!membreCommissionEtablissement.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return membreCommissionEtablissement.getJustification();

            case "Membre du conseil de coordination":
                MembreConseilCoordination membreConseilCoordination = membreConseilCoordinationRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!membreConseilCoordination.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return membreConseilCoordination.getJustification();

            case "Membre d'une commission permanente du conseil de coordination":
                MembreCommissionConseil membreCommissionConseil= membreCommissionConseilRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!membreCommissionConseil.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return membreCommissionConseil.getJustification();

            case "Membre d'une commission ad hoc":
                MembreCommissionAdHoc membreCommissionAdHoc = membreCommissionAdHocRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!membreCommissionAdHoc.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return membreCommissionAdHoc.getJustification();

            case "Mémoire de PFE":
                EncadrementPFE encadrementPFE = encadrementPFERepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!encadrementPFE.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return encadrementPFE.getJustification();

            case "Rapport de stage de visite ou de terrain":
                RapportStageVisiteTerrain rapportStageVisiteTerrain = rapportStageVisiteTerrainRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!rapportStageVisiteTerrain.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return rapportStageVisiteTerrain.getJustification();

            case "Formation de formateurs ou du Personnel administratif ou technique":
                EncadrementRH encadrementRH = encadrementRHRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!encadrementRH.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return encadrementRH.getJustification();

            case "Publications dans des revues indexées dans les bases internationales  comme: SCOPUS, THOMPSON":
                PublicationsRevuesIndexées publicationsRevuesIndexées = publicationsRevuesIndexéesRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!publicationsRevuesIndexées.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return publicationsRevuesIndexées.getJustification();

            case "Publications dans des revues scientifiques nationales ou internationales à comité de lecture ISSN (tel qu'il est défini  dans la liste officielle du CNRST)":
                PublicationRevuesScientifiques publicationRevuesScientifiques = publicationRevuesScientifiquesRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!publicationRevuesScientifiques.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return publicationRevuesScientifiques.getJustification();

            case "Ouvrage spécialisé ISBN et publié par une maison d'édition":
                OuvrageSpecialisé ouvrageSpecialisé = ouvrageSpecialiséRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!ouvrageSpecialisé.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return ouvrageSpecialisé.getJustification();

            case "Chapitre d'un ouvrage collectif publié par une maison d'édition ISBN":
                ChapitreOuvrage chapitreOuvrage = chapitreOuvrageRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!chapitreOuvrage.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return chapitreOuvrage.getJustification();

            case "Congrès ou conférence (rédigées et publiées dans le Proceeding)(Les communications ne peuvent être comptabilisées qu'une seule fois)":
                CongrèsConférencesPubliées congrèsConférencesPubliées = congrèsConférencesPubliéesRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!congrèsConférencesPubliées.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
               return  congrèsConférencesPubliées.getJustification();

            case "Communications dans des congrès ou des conférences (non publiés)":
                CongrèsConférencesNonPubliées congrèsConférencesNonPubliées = congrèsConférencesNonPubliéesRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!congrèsConférencesNonPubliées.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return congrèsConférencesNonPubliées.getJustification();

            case "Doctorats encadrés":
                DoctoratsEncadrés doctoratsEncadrés = doctoratsEncadrésRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!doctoratsEncadrés.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return doctoratsEncadrés.getJustification();

            case "Encadrement des mémoires de Master":
                EncadrementMémoiresMaster encadrementMémoiresMaster= encadrementMémoiresMasterRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!encadrementMémoiresMaster.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return encadrementMémoiresMaster.getJustification();

            case "Participaction à thèse doctorat ou d'habilitation":
                ParticipationthèseDoctorat participationthèseDoctorat = participationthèseDoctoratRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!participationthèseDoctorat.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return participationthèseDoctorat.getJustification();

            case "Responsable ou membre d'une structure de recherche accréditée ou d'un pole de compétence(cumulable)":
                ResponsableMembreStructureRecherchePole responsableMembreStructureRecherchePole = responsableMembreStructureRechercheAccréditéePoleCompetenceRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!responsableMembreStructureRecherchePole.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return responsableMembreStructureRecherchePole.getJustification();

            case "Association pour la connaissance":
                AssociationConnaissance associationConnaissance = associationConnaissanceRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!associationConnaissance.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return associationConnaissance.getJustification();

            case "Projets ou contrats de recherche au niveau national ou international ou les deux":
                ProjetsContratsRecherche projetsContratsRecherche = projetsContratsRechercheRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!projetsContratsRecherche.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return projetsContratsRecherche.getJustification();

            case "Editeur, membre ou référé d'un journal ou revue scientifique":
                EditeurMembreRéféréJournalRevue editeurMembreRéféréJournalRevue = editeurMembreRéféréJournalRevueRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!editeurMembreRéféréJournalRevue.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return editeurMembreRéféréJournalRevue.getJustification();

            case "Expertise non rémunérée de projet de recherche scientifique":
                ExpertiseNonRémunéré expertiseNonRémunéré = expertiseNonRémunéréRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!expertiseNonRémunéré.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
               return  expertiseNonRémunéré.getJustification();
            case "Contribution à l'organisation d'activités de rayonnement de l'établissement (séminaires, congrès, colloque, ateliers, formation continue, ou autre)":
                ContributionOrganisationActivitésRayonnement contributionOrganisationActivitésRayonnement = contributionOrganisationActivitésRayonnementRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!contributionOrganisationActivitésRayonnement.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return contributionOrganisationActivitésRayonnement.getJustification();

            case "Projet de recherche et de développement avec le secteur privé":
                ProjetDeRechercheDeveloppement projetDeRechercheDeveloppement = projetDeRechercheDeveloppementRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!projetDeRechercheDeveloppement.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return projetDeRechercheDeveloppement.getJustification();

            case "Brevet":
                Brevet brevet = brevetRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!brevet.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return brevet.getJustification();

            case "Incubation de projet de recherche et de développement":
                IncubationProjetRecherche incubationProjetRecherche = incubationProjetRechercheRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!incubationProjetRecherche.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return incubationProjetRecherche.getJustification();

            case "Création de start up":
                CréationStartUp créationStartUp = créationStartUpRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!créationStartUp.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return créationStartUp.getJustification();

            default:
                throw new IllegalArgumentException("Unknown activity type: "+ activityName);
        }

    }

    @Override
    public byte[] getJustificationPdfForSelectedUser(String activityName, int activityId, String userEmail) {

        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));

        switch (activityName) {
            case "Ouvrage pédagogique et/ou didactique (ISBN ou  Maison d'édition)":
                Ouvrage ouvrage = ouvrageRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!ouvrage.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return ouvrage.getJustification();

            case "Manuel ( exercices corrigés, annales examens corrigés, etc.) (ISBN, ou validé par le chef d'établissement)":
                Manuel manuel = manuelRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!manuel.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }

                return manuel.getJustification();

            case "Polycopiés pédagogiques":
                PolycopiésPédagogiques polycopiésPédagogiques = polycopiésPédagogiquesRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!polycopiésPédagogiques.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return polycopiésPédagogiques.getJustification();

            case "Petits livres de méthodologie ou de didactique pour la lecture ou l'analyse":
                PetitsLivres petitsLivres= petitsLivresRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!petitsLivres.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return petitsLivres.getJustification();

            case "Montages expérimentaux":
                MontagesExpérimentaux montagesExpérimentaux = montagesExpérimentauxRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!montagesExpérimentaux.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return montagesExpérimentaux.getJustification();

            case "Préparation de sorties de terrain":
                PréparationSortiesTerrain préparationSortiesTerrain = préparationSortiesTerrainRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!préparationSortiesTerrain.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return préparationSortiesTerrain.getJustification();

            case "Supports":
                Supports supports= supportsRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!supports.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return supports.getJustification();

            case "Didacticiels":
                Didacticiels didacticiels = didacticielsRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!didacticiels.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return didacticiels.getJustification();


            case "Coordonnateur d'une filière":
                CoordonateurFilière coordonateurFilière = coordonateurFilièreRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!coordonateurFilière.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return coordonateurFilière.getJustification();

            case "Coordonnateur d'un module (ou deux au maximum )":
                CoordonateurModule coordonateurModule = coordonateurModuleRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!coordonateurModule.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return coordonateurModule.getJustification();

            case "Chef de département":
                ChefDépartement chefDépartement = chefDépartementRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!chefDépartement.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return chefDépartement.getJustification();

            case "Vice-doyen ( non cumulable avec commission permanente)":
                ViceDoyen viceDoyen = viceDoyenRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!viceDoyen.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to delete this activity");
                }
                return viceDoyen.getJustification();

            case "Membre élu du conseil d'établissement":
                MembreEluConseil membreEluConseil= membreEluConseilRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!membreEluConseil.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return membreEluConseil.getJustification();

            case "Membre d'une commission permanente de l'établissement":
                MembreCommissionEtablissement membreCommissionEtablissement = membreCommisionEtablissementRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!membreCommissionEtablissement.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return membreCommissionEtablissement.getJustification();

            case "Membre du conseil de coordination":
                MembreConseilCoordination membreConseilCoordination = membreConseilCoordinationRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!membreConseilCoordination.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return membreConseilCoordination.getJustification();

            case "Membre d'une commission permanente du conseil de coordination":
                MembreCommissionConseil membreCommissionConseil= membreCommissionConseilRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!membreCommissionConseil.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return membreCommissionConseil.getJustification();

            case "Membre d'une commission ad hoc":
                MembreCommissionAdHoc membreCommissionAdHoc = membreCommissionAdHocRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!membreCommissionAdHoc.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return membreCommissionAdHoc.getJustification();

            case "Mémoire de PFE":
                EncadrementPFE encadrementPFE = encadrementPFERepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!encadrementPFE.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return encadrementPFE.getJustification();

            case "Rapport de stage de visite ou de terrain":
                RapportStageVisiteTerrain rapportStageVisiteTerrain = rapportStageVisiteTerrainRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!rapportStageVisiteTerrain.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return rapportStageVisiteTerrain.getJustification();

            case "Formation de formateurs ou du Personnel administratif ou technique":
                EncadrementRH encadrementRH = encadrementRHRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!encadrementRH.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return encadrementRH.getJustification();

            case "Publications dans des revues indexées dans les bases internationales  comme: SCOPUS, THOMPSON":
                PublicationsRevuesIndexées publicationsRevuesIndexées = publicationsRevuesIndexéesRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!publicationsRevuesIndexées.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return publicationsRevuesIndexées.getJustification();

            case "Publications dans des revues scientifiques nationales ou internationales à comité de lecture ISSN (tel qu'il est défini  dans la liste officielle du CNRST)":
                PublicationRevuesScientifiques publicationRevuesScientifiques = publicationRevuesScientifiquesRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!publicationRevuesScientifiques.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return publicationRevuesScientifiques.getJustification();

            case "Ouvrage spécialisé ISBN et publié par une maison d'édition":
                OuvrageSpecialisé ouvrageSpecialisé = ouvrageSpecialiséRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!ouvrageSpecialisé.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return ouvrageSpecialisé.getJustification();

            case "Chapitre d'un ouvrage collectif publié par une maison d'édition ISBN":
                ChapitreOuvrage chapitreOuvrage = chapitreOuvrageRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!chapitreOuvrage.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return chapitreOuvrage.getJustification();

            case "Congrès ou conférence (rédigées et publiées dans le Proceeding)(Les communications ne peuvent être comptabilisées qu'une seule fois)":
                CongrèsConférencesPubliées congrèsConférencesPubliées = congrèsConférencesPubliéesRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!congrèsConférencesPubliées.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return  congrèsConférencesPubliées.getJustification();

            case "Communications dans des congrès ou des conférences (non publiés)":
                CongrèsConférencesNonPubliées congrèsConférencesNonPubliées = congrèsConférencesNonPubliéesRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!congrèsConférencesNonPubliées.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return congrèsConférencesNonPubliées.getJustification();

            case "Doctorats encadrés":
                DoctoratsEncadrés doctoratsEncadrés = doctoratsEncadrésRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!doctoratsEncadrés.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return doctoratsEncadrés.getJustification();

            case "Encadrement des mémoires de Master":
                EncadrementMémoiresMaster encadrementMémoiresMaster= encadrementMémoiresMasterRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!encadrementMémoiresMaster.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return encadrementMémoiresMaster.getJustification();

            case "Participaction à thèse doctorat ou d'habilitation":
                ParticipationthèseDoctorat participationthèseDoctorat = participationthèseDoctoratRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!participationthèseDoctorat.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return participationthèseDoctorat.getJustification();

            case "Responsable ou membre d'une structure de recherche accréditée ou d'un pole de compétence(cumulable)":
                ResponsableMembreStructureRecherchePole responsableMembreStructureRecherchePole = responsableMembreStructureRechercheAccréditéePoleCompetenceRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!responsableMembreStructureRecherchePole.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return responsableMembreStructureRecherchePole.getJustification();

            case "Association pour la connaissance":
                AssociationConnaissance associationConnaissance = associationConnaissanceRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!associationConnaissance.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return associationConnaissance.getJustification();

            case "Projets ou contrats de recherche au niveau national ou international ou les deux":
                ProjetsContratsRecherche projetsContratsRecherche = projetsContratsRechercheRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!projetsContratsRecherche.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return projetsContratsRecherche.getJustification();

            case "Editeur, membre ou référé d'un journal ou revue scientifique":
                EditeurMembreRéféréJournalRevue editeurMembreRéféréJournalRevue = editeurMembreRéféréJournalRevueRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!editeurMembreRéféréJournalRevue.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return editeurMembreRéféréJournalRevue.getJustification();

            case "Expertise non rémunérée de projet de recherche scientifique":
                ExpertiseNonRémunéré expertiseNonRémunéré = expertiseNonRémunéréRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!expertiseNonRémunéré.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return  expertiseNonRémunéré.getJustification();
            case "Contribution à l'organisation d'activités de rayonnement de l'établissement (séminaires, congrès, colloque, ateliers, formation continue, ou autre)":
                ContributionOrganisationActivitésRayonnement contributionOrganisationActivitésRayonnement = contributionOrganisationActivitésRayonnementRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!contributionOrganisationActivitésRayonnement.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return contributionOrganisationActivitésRayonnement.getJustification();

            case "Projet de recherche et de développement avec le secteur privé":
                ProjetDeRechercheDeveloppement projetDeRechercheDeveloppement = projetDeRechercheDeveloppementRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!projetDeRechercheDeveloppement.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return projetDeRechercheDeveloppement.getJustification();

            case "Brevet":
                Brevet brevet = brevetRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!brevet.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return brevet.getJustification();

            case "Incubation de projet de recherche et de développement":
                IncubationProjetRecherche incubationProjetRecherche = incubationProjetRechercheRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!incubationProjetRecherche.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return incubationProjetRecherche.getJustification();

            case "Création de start up":
                CréationStartUp créationStartUp = créationStartUpRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activity not found"));
                if(!créationStartUp.getUser().equals(user)){
                    throw new IllegalArgumentException("You do not have permission to get justification");
                }
                return créationStartUp.getJustification();

            default:
                throw new IllegalArgumentException("Unknown activity type: "+ activityName);
        }

    }

    @Override
    public void cancelActivity(String activityName, int activityId) {
        switch (activityName) {
            case "Ouvrage pédagogique et/ou didactique (ISBN ou  Maison d'édition)":
                Ouvrage ouvrage = ouvrageRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                ouvrage.setEvaluated(true);
                ouvrageRepository.save(ouvrage);
                break;

            case "Manuel (exercices corrigés, annales examens corrigés, etc.) (ISBN, ou validé par le chef d'établissement)":
                Manuel manuel = manuelRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                manuel.setEvaluated(true);
                manuelRepository.save(manuel);
                break;

            case "Polycopiés pédagogiques":
                PolycopiésPédagogiques polycopiésPédagogiques = polycopiésPédagogiquesRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                polycopiésPédagogiques.setEvaluated(true);
                polycopiésPédagogiquesRepository.save(polycopiésPédagogiques);
                break;

            case "Petits livres de méthodologie ou de didactique pour la lecture ou l'analyse":
                PetitsLivres petitsLivres = petitsLivresRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                petitsLivres.setEvaluated(true);
                petitsLivresRepository.save(petitsLivres);
                break;

            case "Montages expérimentaux":
                MontagesExpérimentaux montagesExpérimentaux = montagesExpérimentauxRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                montagesExpérimentaux.setEvaluated(true);
                montagesExpérimentauxRepository.save(montagesExpérimentaux);
                break;

            case "Préparation de sorties de terrain":
                PréparationSortiesTerrain préparationSortiesTerrain = préparationSortiesTerrainRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                préparationSortiesTerrain.setEvaluated(true);
                préparationSortiesTerrainRepository.save(préparationSortiesTerrain);
                break;

            case "Supports":
                Supports supports = supportsRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                supports.setEvaluated(true);
                supportsRepository.save(supports);
                break;

            case "Didacticiels":
                Didacticiels didacticiels = didacticielsRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                didacticiels.setEvaluated(true);
                didacticielsRepository.save(didacticiels);
                break;

            case "Page web à caractère pédagogique":
                PageWeb pageWeb = pageWebRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                pageWeb.setEvaluated(true);
                pageWebRepository.save(pageWeb);
                break;

            case "MOOC : Production de contenus en ligne":
                MOOC mooc = moocRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                mooc.setEvaluated(true);
                moocRepository.save(mooc);
                break;

            case "Coordonnateur d'une filière":
                CoordonateurFilière coordonateurFilière = coordonateurFilièreRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                coordonateurFilière.setEvaluated(true);
                coordonateurFilièreRepository.save(coordonateurFilière);
                break;

            case "Coordonnateur d'un module (ou deux au maximum )":
                CoordonateurModule coordonateurModule = coordonateurModuleRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                coordonateurModule.setEvaluated(true);
                coordonateurModuleRepository.save(coordonateurModule);
                break;

            case "Chef de département":
                ChefDépartement chefDépartement = chefDépartementRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                chefDépartement.setEvaluated(true);
                chefDépartementRepository.save(chefDépartement);
                break;

            case "Vice-doyen ( non cumulable avec commission permanente)":
                ViceDoyen viceDoyen = viceDoyenRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                viceDoyen.setEvaluated(true);
                viceDoyenRepository.save(viceDoyen);
                break;

            case "Membre élu du conseil d'établissement":
                MembreEluConseil membreEluConseil = membreEluConseilRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                membreEluConseil.setEvaluated(true);
                membreEluConseilRepository.save(membreEluConseil);
                break;

            case "Membre d'une commission permanente de l'établissement":
                MembreCommissionEtablissement membreCommissionEtablissement = membreCommisionEtablissementRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                membreCommissionEtablissement.setEvaluated(true);
                membreCommisionEtablissementRepository.save(membreCommissionEtablissement);
                break;

            case "Membre du conseil de coordination":
                MembreConseilCoordination membreConseilCoordination = membreConseilCoordinationRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                membreConseilCoordination.setEvaluated(true);
                membreConseilCoordinationRepository.save(membreConseilCoordination);
                break;

            case "Membre d'une commission permanente du conseil de coordination":
                MembreCommissionConseil membreCommissionConseil = membreCommissionConseilRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                membreCommissionConseil.setEvaluated(true);
                membreCommissionConseilRepository.save(membreCommissionConseil);
                break;

            case "Membre d'une commission ad hoc":
                MembreCommissionAdHoc membreCommissionAdHoc = membreCommissionAdHocRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                membreCommissionAdHoc.setEvaluated(true);
                membreCommissionAdHocRepository.save(membreCommissionAdHoc);
                break;

            case "Mémoire de PFE":
                EncadrementPFE encadrementPFE = encadrementPFERepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                encadrementPFE.setEvaluated(true);
                encadrementPFERepository.save(encadrementPFE);
                break;

            case "Rapport de stage de visite ou de terrain":
                RapportStageVisiteTerrain rapportStageVisiteTerrain = rapportStageVisiteTerrainRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                rapportStageVisiteTerrain.setEvaluated(true);
                rapportStageVisiteTerrainRepository.save(rapportStageVisiteTerrain);
                break;

            case "Formation de formateurs ou du Personnel administratif ou technique":
                EncadrementRH encadrementRH = encadrementRHRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                encadrementRH.setEvaluated(true);
                encadrementRHRepository.save(encadrementRH);
                break;

            case "Publications dans des revues indexées dans les bases internationales  comme: SCOPUS, THOMPSON":
                PublicationsRevuesIndexées publicationsRevuesIndexées = publicationsRevuesIndexéesRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                publicationsRevuesIndexées.setEvaluated(true);
                publicationsRevuesIndexéesRepository.save(publicationsRevuesIndexées);
                break;

            case "Publications dans des revues scientifiques nationales ou internationales à comité de lecture ISSN (tel qu'il est défini  dans la liste officielle du CNRST)":
                PublicationRevuesScientifiques publicationRevuesScientifiques = publicationRevuesScientifiquesRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                publicationRevuesScientifiques.setEvaluated(true);
                publicationRevuesScientifiquesRepository.save(publicationRevuesScientifiques);
                break;

            case "Ouvrage spécialisé ISBN et publié par une maison d'édition":
                OuvrageSpecialisé ouvrageSpecialisé = ouvrageSpecialiséRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                ouvrageSpecialisé.setEvaluated(true);
                ouvrageSpecialiséRepository.save(ouvrageSpecialisé);
                break;

            case "Chapitre d'un ouvrage collectif publié par une maison d'édition ISBN":
                ChapitreOuvrage chapitreOuvrage = chapitreOuvrageRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                chapitreOuvrage.setEvaluated(true);
                chapitreOuvrageRepository.save(chapitreOuvrage);
                break;

            case "Congrès ou conférence (rédigées et publiées dans le Proceeding)(Les communications ne peuvent être comptabilisées qu'une seule fois)":
                CongrèsConférencesPubliées congrèsConférencesPubliées = congrèsConférencesPubliéesRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                congrèsConférencesPubliées.setEvaluated(true);
                congrèsConférencesPubliéesRepository.save(congrèsConférencesPubliées);
                break;

            case "Communications dans des congrès ou des conférences (non publiés)":
                CongrèsConférencesNonPubliées congrèsConférencesNonPubliées = congrèsConférencesNonPubliéesRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                congrèsConférencesNonPubliées.setEvaluated(true);
                congrèsConférencesNonPubliéesRepository.save(congrèsConférencesNonPubliées);
                break;

            case "Doctorats encadrés":
                DoctoratsEncadrés doctoratsEncadrés = doctoratsEncadrésRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                doctoratsEncadrés.setEvaluated(true);
                doctoratsEncadrésRepository.save(doctoratsEncadrés);
                break;

            case "Encadrement des mémoires de Master":
                EncadrementMémoiresMaster encadrementMémoiresMaster = encadrementMémoiresMasterRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                encadrementMémoiresMaster.setEvaluated(true);
                encadrementMémoiresMasterRepository.save(encadrementMémoiresMaster);
                break;

            case "Participaction à thèse doctorat ou d'habilitation":
                ParticipationthèseDoctorat participationthèseDoctorat = participationthèseDoctoratRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                participationthèseDoctorat.setEvaluated(true);
                participationthèseDoctoratRepository.save(participationthèseDoctorat);
                break;

            case "Responsable ou membre d'une structure de recherche accréditée ou d'un pole de compétence(cumulable)":
                ResponsableMembreStructureRecherchePole responsableMembreStructureRecherchePole = responsableMembreStructureRechercheAccréditéePoleCompetenceRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                responsableMembreStructureRecherchePole.setEvaluated(true);
                responsableMembreStructureRechercheAccréditéePoleCompetenceRepository.save(responsableMembreStructureRecherchePole);
                break;

            case "Association pour la connaissance":
                AssociationConnaissance associationConnaissance = associationConnaissanceRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                associationConnaissance.setEvaluated(true);
                associationConnaissanceRepository.save(associationConnaissance);
                break;

            case "Projets ou contrats de recherche au niveau national ou international ou les deux":
                ProjetsContratsRecherche projetsContratsRecherche = projetsContratsRechercheRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                projetsContratsRecherche.setEvaluated(true);
                projetsContratsRechercheRepository.save(projetsContratsRecherche);
                break;

            case "Editeur, membre ou référé d'un journal ou revue scientifique":
                EditeurMembreRéféréJournalRevue editeurMembreRéféréJournalRevue = editeurMembreRéféréJournalRevueRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                editeurMembreRéféréJournalRevue.setEvaluated(true);
                editeurMembreRéféréJournalRevueRepository.save(editeurMembreRéféréJournalRevue);
                break;

            case "Expertise non rémunérée de projet de recherche scientifique":
                ExpertiseNonRémunéré expertiseNonRémunéré = expertiseNonRémunéréRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                expertiseNonRémunéré.setEvaluated(true);
                expertiseNonRémunéréRepository.save(expertiseNonRémunéré);
                break;

            case "Contribution à l'organisation d'activités de rayonnement de l'établissement (séminaires, congrès, colloque, ateliers, formation continue, ou autre)":
                ContributionOrganisationActivitésRayonnement contributionOrganisationActivitésRayonnement = contributionOrganisationActivitésRayonnementRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                contributionOrganisationActivitésRayonnement.setEvaluated(true);
                contributionOrganisationActivitésRayonnementRepository.save(contributionOrganisationActivitésRayonnement);
                break;

            case "Projet de recherche et de développement avec le secteur privé":
                ProjetDeRechercheDeveloppement projetDeRechercheDeveloppement = projetDeRechercheDeveloppementRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                projetDeRechercheDeveloppement.setEvaluated(true);
                projetDeRechercheDeveloppementRepository.save(projetDeRechercheDeveloppement);
                break;

            case "Brevet":
                Brevet brevet = brevetRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                brevet.setEvaluated(true);
                brevetRepository.save(brevet);
                break;

            case "Incubation de projet de recherche et de développement":
                IncubationProjetRecherche incubationProjetRecherche = incubationProjetRechercheRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                incubationProjetRecherche.setEvaluated(true);
                incubationProjetRechercheRepository.save(incubationProjetRecherche);
                break;

            case "Création de start up":
                CréationStartUp créationStartUp = créationStartUpRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));

                créationStartUp.setEvaluated(true);
                créationStartUpRepository.save(créationStartUp);
                break;


            default:
                throw new IllegalArgumentException("Nom d'activité invalide");
        }

    }


    @Override
    public void validateActivity(String activityName, int activityId) {
        switch (activityName) {
            case "Ouvrage pédagogique et/ou didactique (ISBN ou  Maison d'édition)":
                Ouvrage ouvrage = ouvrageRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                ouvrage.setPointsAttribués(ouvrage.getActivityPoints());
                ouvrage.setEvaluated(true);
                ouvrageRepository.save(ouvrage);
                break;

            case "Manuel ( exercices corrigés, annales examens corrigés, etc.) (ISBN, ou validé par le chef d'établissement)":
                Manuel manuel = manuelRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                manuel.setPointsAttribués(manuel.getActivityPoints());
                manuel.setEvaluated(true);
                manuelRepository.save(manuel);
                break;

            case "Polycopiés pédagogiques":
                PolycopiésPédagogiques polycopiésPédagogiques = polycopiésPédagogiquesRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                polycopiésPédagogiques.setPointsAttribués(polycopiésPédagogiques.getActivityPoints());
                polycopiésPédagogiques.setEvaluated(true);
                polycopiésPédagogiquesRepository.save(polycopiésPédagogiques);
                break;

            case "Petits livres de méthodologie ou de didactique pour la lecture ou l'analyse":
                PetitsLivres petitsLivres = petitsLivresRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                petitsLivres.setPointsAttribués(petitsLivres.getActivityPoints());
                petitsLivres.setEvaluated(true);
                petitsLivresRepository.save(petitsLivres);
                break;

            case "Montages expérimentaux":
                MontagesExpérimentaux montagesExpérimentaux = montagesExpérimentauxRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                montagesExpérimentaux.setPointsAttribués(montagesExpérimentaux.getActivityPoints());
                montagesExpérimentaux.setEvaluated(true);
                montagesExpérimentauxRepository.save(montagesExpérimentaux);
                break;

            case "Préparation de sorties de terrain":
                PréparationSortiesTerrain préparationSortiesTerrain = préparationSortiesTerrainRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                préparationSortiesTerrain.setPointsAttribués(préparationSortiesTerrain.getActivityPoints());
                préparationSortiesTerrain.setEvaluated(true);
                préparationSortiesTerrainRepository.save(préparationSortiesTerrain);
                break;

            case "Supports":
                Supports supports = supportsRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                supports.setPointsAttribués(supports.getActivityPoints());
                supports.setEvaluated(true);
                supportsRepository.save(supports);
                break;

            case "Didacticiels":
                Didacticiels didacticiels = didacticielsRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                didacticiels.setPointsAttribués(didacticiels.getActivityPoints());
                didacticiels.setEvaluated(true);
                didacticielsRepository.save(didacticiels);
                break;

            case "Page web à caractère pédagogique":
                PageWeb pageWeb = pageWebRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                pageWeb.setPointsAttribués(pageWeb.getActivityPoints());
                pageWeb.setEvaluated(true);
                pageWebRepository.save(pageWeb);
                break;

            case "MOOC : Production de contenus en ligne":
                MOOC mooc = moocRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                mooc.setPointsAttribués(mooc.getActivityPoints());
                mooc.setEvaluated(true);
                moocRepository.save(mooc);
                break;

            case "Coordonnateur d'une filière":
                CoordonateurFilière coordonateurFilière = coordonateurFilièreRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                coordonateurFilière.setPointsAttribués(coordonateurFilière.getActivityPoints());
                coordonateurFilière.setEvaluated(true);
                coordonateurFilièreRepository.save(coordonateurFilière);
                break;

            case "Coordonnateur d'un module (ou deux au maximum )":
                CoordonateurModule coordonateurModule = coordonateurModuleRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                coordonateurModule.setPointsAttribués(coordonateurModule.getActivityPoints());
                coordonateurModule.setEvaluated(true);
                coordonateurModuleRepository.save(coordonateurModule);
                break;

            case "Chef de département":
                ChefDépartement chefDépartement = chefDépartementRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                chefDépartement.setPointsAttribués(chefDépartement.getActivityPoints());
                chefDépartement.setEvaluated(true);
                chefDépartementRepository.save(chefDépartement);
                break;

            case "Vice-doyen ( non cumulable avec commission permanente)":
                ViceDoyen viceDoyen = viceDoyenRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                viceDoyen.setPointsAttribués(viceDoyen.getActivityPoints());
                viceDoyen.setEvaluated(true);
                viceDoyenRepository.save(viceDoyen);
                break;

            case "Membre élu du conseil d'établissement":
                MembreEluConseil membreEluConseil = membreEluConseilRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                membreEluConseil.setPointsAttribués(membreEluConseil.getActivityPoints());
                membreEluConseil.setEvaluated(true);
                membreEluConseilRepository.save(membreEluConseil);
                break;

            case "Membre d'une commission permanente de l'établissement":
                MembreCommissionEtablissement membreCommissionEtablissement = membreCommisionEtablissementRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                membreCommissionEtablissement.setPointsAttribués(membreCommissionEtablissement.getActivityPoints());
                membreCommissionEtablissement.setEvaluated(true);
                membreCommisionEtablissementRepository.save(membreCommissionEtablissement);
                break;

            case "Membre du conseil de coordination":
                MembreConseilCoordination membreConseilCoordination = membreConseilCoordinationRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                membreConseilCoordination.setPointsAttribués(membreConseilCoordination.getActivityPoints());
                membreConseilCoordination.setEvaluated(true);
                membreConseilCoordinationRepository.save(membreConseilCoordination);
                break;

            case "Membre d'une commission permanente du conseil de coordination":
                MembreCommissionConseil membreCommissionConseil = membreCommissionConseilRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                membreCommissionConseil.setPointsAttribués(membreCommissionConseil.getActivityPoints());
                membreCommissionConseil.setEvaluated(true);
                membreCommissionConseilRepository.save(membreCommissionConseil);
                break;

            case "Membre d'une commission ad hoc":
                MembreCommissionAdHoc membreCommissionAdHoc = membreCommissionAdHocRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                membreCommissionAdHoc.setPointsAttribués(membreCommissionAdHoc.getActivityPoints());
                membreCommissionAdHoc.setEvaluated(true);
                membreCommissionAdHocRepository.save(membreCommissionAdHoc);
                break;

            case "Mémoire de PFE":
                EncadrementPFE encadrementPFE = encadrementPFERepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                encadrementPFE.setPointsAttribués(encadrementPFE.getActivityPoints());
                encadrementPFE.setEvaluated(true);
                encadrementPFERepository.save(encadrementPFE);
                break;

            case "Rapport de stage de visite ou de terrain":
                RapportStageVisiteTerrain rapportStageVisiteTerrain = rapportStageVisiteTerrainRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                rapportStageVisiteTerrain.setPointsAttribués(rapportStageVisiteTerrain.getActivityPoints());
                rapportStageVisiteTerrain.setEvaluated(true);
                rapportStageVisiteTerrainRepository.save(rapportStageVisiteTerrain);
                break;

            case "Formation de formateurs ou du Personnel administratif ou technique":
                EncadrementRH encadrementRH = encadrementRHRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                encadrementRH.setPointsAttribués(encadrementRH.getActivityPoints());
                encadrementRH.setEvaluated(true);
                encadrementRHRepository.save(encadrementRH);
                break;

            case "Publications dans des revues indexées dans les bases internationales  comme: SCOPUS, THOMPSON":
                PublicationsRevuesIndexées publicationsRevuesIndexées = publicationsRevuesIndexéesRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                publicationsRevuesIndexées.setPointsAttribués(publicationsRevuesIndexées.getActivityPoints());
                publicationsRevuesIndexées.setEvaluated(true);
                publicationsRevuesIndexéesRepository.save(publicationsRevuesIndexées);
                break;

            case "Publications dans des revues scientifiques nationales ou internationales à comité de lecture ISSN (tel qu'il est défini  dans la liste officielle du CNRST)":
                PublicationRevuesScientifiques publicationRevuesScientifiques = publicationRevuesScientifiquesRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                publicationRevuesScientifiques.setPointsAttribués(publicationRevuesScientifiques.getActivityPoints());
                publicationRevuesScientifiques.setEvaluated(true);
                publicationRevuesScientifiquesRepository.save(publicationRevuesScientifiques);
                break;

            case "Ouvrage spécialisé ISBN et publié par une maison d'édition":
                OuvrageSpecialisé ouvrageSpecialisé = ouvrageSpecialiséRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                ouvrageSpecialisé.setPointsAttribués(ouvrageSpecialisé.getActivityPoints());
                ouvrageSpecialisé.setEvaluated(true);
                ouvrageSpecialiséRepository.save(ouvrageSpecialisé);
                break;

            case "Chapitre d'un ouvrage collectif publié par une maison d'édition ISBN":
                ChapitreOuvrage chapitreOuvrage = chapitreOuvrageRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                chapitreOuvrage.setPointsAttribués(chapitreOuvrage.getActivityPoints());
                chapitreOuvrage.setEvaluated(true);
                chapitreOuvrageRepository.save(chapitreOuvrage);
                break;

            case "Congrès ou conférence (rédigées et publiées dans le Proceeding)(Les communications ne peuvent être comptabilisées qu'une seule fois)":
                CongrèsConférencesPubliées congrèsConférencesPubliées = congrèsConférencesPubliéesRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                congrèsConférencesPubliées.setPointsAttribués(congrèsConférencesPubliées.getActivityPoints());
                congrèsConférencesPubliées.setEvaluated(true);
                congrèsConférencesPubliéesRepository.save(congrèsConférencesPubliées);
                break;

            case "Communications dans des congrès ou des conférences (non publiés)":
                CongrèsConférencesNonPubliées congrèsConférencesNonPubliées = congrèsConférencesNonPubliéesRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                congrèsConférencesNonPubliées.setPointsAttribués(congrèsConférencesNonPubliées.getActivityPoints());
                congrèsConférencesNonPubliées.setEvaluated(true);
                congrèsConférencesNonPubliéesRepository.save(congrèsConférencesNonPubliées);
                break;

            case "Doctorats encadrés":
                DoctoratsEncadrés doctoratsEncadrés = doctoratsEncadrésRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                doctoratsEncadrés.setPointsAttribués(doctoratsEncadrés.getActivityPoints());
                doctoratsEncadrés.setEvaluated(true);
                doctoratsEncadrésRepository.save(doctoratsEncadrés);
                break;

            case "Encadrement des mémoires de Master":
                EncadrementMémoiresMaster encadrementMémoiresMaster = encadrementMémoiresMasterRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                encadrementMémoiresMaster.setPointsAttribués(encadrementMémoiresMaster.getActivityPoints());
                encadrementMémoiresMaster.setEvaluated(true);
                encadrementMémoiresMasterRepository.save(encadrementMémoiresMaster);
                break;

            case "Participaction à thèse doctorat ou d'habilitation":
                ParticipationthèseDoctorat participationthèseDoctorat = participationthèseDoctoratRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                participationthèseDoctorat.setPointsAttribués(participationthèseDoctorat.getActivityPoints());
                participationthèseDoctorat.setEvaluated(true);
                participationthèseDoctoratRepository.save(participationthèseDoctorat);
                break;

            case "Responsable ou membre d'une structure de recherche accréditée ou d'un pole de compétence(cumulable)":
                ResponsableMembreStructureRecherchePole responsableMembreStructureRecherchePole = responsableMembreStructureRechercheAccréditéePoleCompetenceRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                responsableMembreStructureRecherchePole.setPointsAttribués(responsableMembreStructureRecherchePole.getActivityPoints());
                responsableMembreStructureRecherchePole.setEvaluated(true);
                responsableMembreStructureRechercheAccréditéePoleCompetenceRepository.save(responsableMembreStructureRecherchePole);
                break;

            case "Association pour la connaissance":
                AssociationConnaissance associationConnaissance = associationConnaissanceRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                associationConnaissance.setPointsAttribués(associationConnaissance.getActivityPoints());
                associationConnaissance.setEvaluated(true);
                associationConnaissanceRepository.save(associationConnaissance);
                break;

            case "Projets ou contrats de recherche au niveau national ou international ou les deux":
                ProjetsContratsRecherche projetsContratsRecherche = projetsContratsRechercheRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                projetsContratsRecherche.setPointsAttribués(projetsContratsRecherche.getActivityPoints());
                projetsContratsRecherche.setEvaluated(true);
                projetsContratsRechercheRepository.save(projetsContratsRecherche);
                break;

            case "Editeur, membre ou référé d'un journal ou revue scientifique":
                EditeurMembreRéféréJournalRevue editeurMembreRéféréJournalRevue = editeurMembreRéféréJournalRevueRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                editeurMembreRéféréJournalRevue.setPointsAttribués(editeurMembreRéféréJournalRevue.getActivityPoints());
                editeurMembreRéféréJournalRevue.setEvaluated(true);
                editeurMembreRéféréJournalRevueRepository.save(editeurMembreRéféréJournalRevue);
                break;

            case "Expertise non rémunérée de projet de recherche scientifique":
                ExpertiseNonRémunéré expertiseNonRémunéré = expertiseNonRémunéréRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                expertiseNonRémunéré.setPointsAttribués(expertiseNonRémunéré.getActivityPoints());
                expertiseNonRémunéré.setEvaluated(true);
                expertiseNonRémunéréRepository.save(expertiseNonRémunéré);
                break;

            case "Contribution à l'organisation d'activités de rayonnement de l'établissement (séminaires, congrès, colloque, ateliers, formation continue, ou autre)":
                ContributionOrganisationActivitésRayonnement contributionOrganisationActivitésRayonnement = contributionOrganisationActivitésRayonnementRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                contributionOrganisationActivitésRayonnement.setPointsAttribués(contributionOrganisationActivitésRayonnement.getActivityPoints());
                contributionOrganisationActivitésRayonnement.setEvaluated(true);
                contributionOrganisationActivitésRayonnementRepository.save(contributionOrganisationActivitésRayonnement);
                break;

            case "Projet de recherche et de développement avec le secteur privé":
                ProjetDeRechercheDeveloppement projetDeRechercheDeveloppement = projetDeRechercheDeveloppementRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                projetDeRechercheDeveloppement.setPointsAttribués(projetDeRechercheDeveloppement.getActivityPoints());
                projetDeRechercheDeveloppement.setEvaluated(true);
                projetDeRechercheDeveloppementRepository.save(projetDeRechercheDeveloppement);
                break;

            case "Brevet":
                Brevet brevet = brevetRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                brevet.setPointsAttribués(brevet.getActivityPoints());
                brevet.setEvaluated(true);
                brevetRepository.save(brevet);
                break;

            case "Incubation de projet de recherche et de développement":
                IncubationProjetRecherche incubationProjetRecherche = incubationProjetRechercheRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                incubationProjetRecherche.setPointsAttribués(incubationProjetRecherche.getActivityPoints());
                incubationProjetRecherche.setEvaluated(true);
                incubationProjetRechercheRepository.save(incubationProjetRecherche);
                break;

            case "Création de start up":
                CréationStartUp créationStartUp = créationStartUpRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                créationStartUp.setPointsAttribués(créationStartUp.getActivityPoints());
                créationStartUp.setEvaluated(true);
                créationStartUpRepository.save(créationStartUp);
                break;


            default:
                throw new IllegalArgumentException("Nom d'activité invalide");
        }

    }

    public String getEvaluationStatus(String userEmail){
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));
        boolean allEvaluated = true;

        List<ChefDépartement> chefDépartementActivities = chefDépartementRepository.findByUser(user);
        for(ChefDépartement activity: chefDépartementActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }
        List<CoordonateurFilière> coordonateurFilièreActivities = coordonateurFilièreRepository.findByUser(user);
        for(CoordonateurFilière activity: coordonateurFilièreActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }
        List<CoordonateurModule> coordonateurModuleActivities = coordonateurModuleRepository.findByUser(user);
        for(CoordonateurModule activity: coordonateurModuleActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }
        List<Didacticiels> didacticielsActivities = didacticielsRepository.findByUser(user);
        for(Didacticiels activity: didacticielsActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }
        List<EncadrementPFE> encadrementPFEActivities = encadrementPFERepository.findByUser(user);
        for(EncadrementPFE activity: encadrementPFEActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }
        List<EncadrementRH> encadrementRHActivities = encadrementRHRepository.findByUser(user);
        for(EncadrementRH activity: encadrementRHActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }
        List<Manuel> manuelActivities = manuelRepository.findByUser(user);
        for(Manuel activity: manuelActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }
        List<MembreCommissionAdHoc> membreCommissionAdHocActivities = membreCommissionAdHocRepository.findByUser(user);
        for(MembreCommissionAdHoc activity: membreCommissionAdHocActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }
        List<MembreCommissionConseil> membreCommissionConseilActivities = membreCommissionConseilRepository.findByUser(user);
        for(MembreCommissionConseil activity: membreCommissionConseilActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }
        List<MembreCommissionEtablissement> membreCommissionEtablissementActivities = membreCommisionEtablissementRepository.findByUser(user);
        for(MembreCommissionEtablissement activity: membreCommissionEtablissementActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }
        List<MembreConseilCoordination> membreConseilCoordinationActivities = membreConseilCoordinationRepository.findByUser(user);
        for(MembreConseilCoordination activity: membreConseilCoordinationActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }

        List<MembreEluConseil> membreEluConseilActivities = membreEluConseilRepository.findByUser(user);
        for(MembreEluConseil activity: membreEluConseilActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }

        List<MontagesExpérimentaux> montagesExpérimentauxActivities = montagesExpérimentauxRepository.findByUser(user);
        for(MontagesExpérimentaux activity: montagesExpérimentauxActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }

        List<MOOC> moocActivities = moocRepository.findByUser(user);
        for(MOOC activity: moocActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }

        List<Ouvrage> ouvrageActivities = ouvrageRepository.findByUser(user);
        for(Ouvrage activity: ouvrageActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }
        List<PageWeb> pageWebActivities = pageWebRepository.findByUser(user);
        for(PageWeb activity: pageWebActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }

        List<PetitsLivres> petitsLivresActivities = petitsLivresRepository.findByUser(user);
        for(PetitsLivres activity: petitsLivresActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }

        List<PolycopiésPédagogiques> polycopiésPédagogiquesActivities = polycopiésPédagogiquesRepository.findByUser(user);
        for(PolycopiésPédagogiques activity: polycopiésPédagogiquesActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }
        List<PréparationSortiesTerrain> préparationSortiesTerrainsActivities = préparationSortiesTerrainRepository.findByUser(user);
        for(PréparationSortiesTerrain activity: préparationSortiesTerrainsActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }

        List<RapportStageVisiteTerrain> rapportStageVisiteTerrainsActivities = rapportStageVisiteTerrainRepository.findByUser(user);
        for(RapportStageVisiteTerrain activity: rapportStageVisiteTerrainsActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }

        List<Supports> supportsActivities = supportsRepository.findByUser(user);
        for(Supports activity: supportsActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }

        List<ViceDoyen> viceDoyenActivities = viceDoyenRepository.findByUser(user);
        for(ViceDoyen activity: viceDoyenActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }


        List<AssociationConnaissance> associationConnaissanceActivities = associationConnaissanceRepository.findByUser(user);
        for(AssociationConnaissance activity: associationConnaissanceActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }

        List<Brevet> brevetActivities = brevetRepository.findByUser(user);
        for(Brevet activity: brevetActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }

        List<ChapitreOuvrage> chapitreOuvrageActivities = chapitreOuvrageRepository.findByUser(user);
        for(ChapitreOuvrage activity: chapitreOuvrageActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }

        List<CongrèsConférencesNonPubliées> congrèsConférencesNonPubliéesActivities = congrèsConférencesNonPubliéesRepository.findByUser(user);
        for(CongrèsConférencesNonPubliées activity: congrèsConférencesNonPubliéesActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }

        List<CongrèsConférencesPubliées> congrèsConférencesPubliéesActivities = congrèsConférencesPubliéesRepository.findByUser(user);
        for(CongrèsConférencesPubliées activity: congrèsConférencesPubliéesActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }

        List<ContributionOrganisationActivitésRayonnement> contributionOrganisationActivitésRayonnementsActivities = contributionOrganisationActivitésRayonnementRepository.findByUser(user);
        for(ContributionOrganisationActivitésRayonnement activity: contributionOrganisationActivitésRayonnementsActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }

        List<CréationStartUp> créationStartUpActivities = créationStartUpRepository.findByUser(user);
        for(CréationStartUp activity: créationStartUpActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }

        List<DoctoratsEncadrés> doctoratsEncadrésActivities = doctoratsEncadrésRepository.findByUser(user);
        for(DoctoratsEncadrés activity: doctoratsEncadrésActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }

        List<EditeurMembreRéféréJournalRevue> editeurMembreRéféréJournalRevuesActivities = editeurMembreRéféréJournalRevueRepository.findByUser(user);
        for(EditeurMembreRéféréJournalRevue activity: editeurMembreRéféréJournalRevuesActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }

        List<EncadrementMémoiresMaster> encadrementMémoiresMasterActivities = encadrementMémoiresMasterRepository.findByUser(user);
        for(EncadrementMémoiresMaster activity: encadrementMémoiresMasterActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }

        List<ExpertiseNonRémunéré> expertiseNonRémunéréActivities = expertiseNonRémunéréRepository.findByUser(user);
        for(ExpertiseNonRémunéré activity: expertiseNonRémunéréActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }

        List<IncubationProjetRecherche> incubationProjetRechercheActivities = incubationProjetRechercheRepository.findByUser(user);
        for(IncubationProjetRecherche activity: incubationProjetRechercheActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }

        List<OuvrageSpecialisé> ouvrageSpecialiséActivities = ouvrageSpecialiséRepository.findByUser(user);
        for(OuvrageSpecialisé activity: ouvrageSpecialiséActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }

        List<ParticipationthèseDoctorat> participationthèseDoctoratActivities = participationthèseDoctoratRepository.findByUser(user);
        for(ParticipationthèseDoctorat activity: participationthèseDoctoratActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }

        List<ProjetDeRechercheDeveloppement> projetDeRechercheDeveloppementActivities = projetDeRechercheDeveloppementRepository.findByUser(user);
        for(ProjetDeRechercheDeveloppement activity: projetDeRechercheDeveloppementActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }

        List<ProjetsContratsRecherche> projetsContratsRechercheActivities = projetsContratsRechercheRepository.findByUser(user);
        for(ProjetsContratsRecherche activity: projetsContratsRechercheActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }

        List<PublicationRevuesScientifiques> publicationRevuesScientifiquesActivities = publicationRevuesScientifiquesRepository.findByUser(user);
        for(PublicationRevuesScientifiques activity: publicationRevuesScientifiquesActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }

        List<PublicationsRevuesIndexées> publicationsRevuesIndexéesActivities = publicationsRevuesIndexéesRepository.findByUser(user);
        for(PublicationsRevuesIndexées activity: publicationsRevuesIndexéesActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }

        List<ResponsableMembreStructureRecherchePole> responsableMembreStructureRecherchePoleActivities = responsableMembreStructureRechercheAccréditéePoleCompetenceRepository.findByUser(user);
        for(ResponsableMembreStructureRecherchePole activity: responsableMembreStructureRecherchePoleActivities){
            if(!activity.isEvaluated()){
                allEvaluated = false;
                break;
            }
        }

        if (allEvaluated) {
            return "Evalué";
        } else {
            return "Non évalué";
        }

    }

    @Override
    public double calculateTotalPointsForUser(String userEmail) {
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
        // Carte pour stocker les points par sous-type
        Map<Integer, Double> pointsBySubType1 = new HashMap<>();
        Map<Integer, Double> pointsBySubType2 = new HashMap<>();

        // Ajouter toutes les activités pour l'utilisateur
        addPointsFromActivities(user, pointsBySubType1, pointsBySubType2);


        // Carte pour stocker les points ajustés par sous-type 1
        Map<Integer, Double> adjustedPointsBySubType1 = new HashMap<>();
        for (Map.Entry<Integer, Double> entry : pointsBySubType1.entrySet()) {
            Integer subType1Id = entry.getKey();
            double totalPoints = entry.getValue();
            double maxPoints = activitySubType1Repository.findById(subType1Id)
                    .map(ActivitySubType1::getSubTypePoints)
                    .orElse(0);
            adjustedPointsBySubType1.put(subType1Id, Math.min(totalPoints, maxPoints));
        }

        // Carte pour stocker les points ajustés par sous-type 2
        Map<Integer, Double> adjustedPointsBySubType2 = new HashMap<>();
        for (Map.Entry<Integer, Double> entry : pointsBySubType2.entrySet()) {
            Integer subType2Id = entry.getKey();
            double totalPoints = entry.getValue();
            double maxPoints = activitySubType2Repository.findById(subType2Id)
                    .map(ActivitySubType2::getSubTypePoints)
                    .orElse(0);
            adjustedPointsBySubType2.put(subType2Id, Math.min(totalPoints, maxPoints));
        }

        // Calculer le total des points ajustés
        double totalPoints = adjustedPointsBySubType1.values().stream().mapToDouble(Double::doubleValue).sum();
        totalPoints += adjustedPointsBySubType2.values().stream().mapToDouble(Double::doubleValue).sum();

        return totalPoints;


    }

    // Méthode pour ajouter les points des activités à la carte des points par sous-type 2
    private void addPointsFromActivities(User user, Map<Integer, Double> pointsBySubType1, Map<Integer, Double> pointsBySubType2) {
        addPointsFromOuvrage(user, pointsBySubType2);
        addPointsFromManuel(user,  pointsBySubType2);
        addPointsFromPolycopiésPédagogiques(user,pointsBySubType2);
        addPointsFromPetitsLivres(user,pointsBySubType2);
        addPointsFromMontagesExpérimentaux(user, pointsBySubType2);
        addPointsFromPréparationSortiesTerrain(user,pointsBySubType2);
        addPointsFromSupports(user,pointsBySubType2);
        addPointsFromDidacticiels(user,pointsBySubType2);
        addPointsFromPageWeb(user, pointsBySubType2);
        addPointsFromRapportStageVisiteTerrain(user,pointsBySubType2);
        addPointsFromViceDoyen(user,pointsBySubType2);
        addPointsFromAssociationConnaissance(user,pointsBySubType2);
        addPointsFromBrevet(user,pointsBySubType2);
        addPointsFromChapitreOuvrage(user,pointsBySubType2);
        addPointsFromCongrèsConférencesNonPubliées(user,pointsBySubType2);
        addPointsFromCongrèsConférencesPubliées(user,pointsBySubType2);
        addPointsFromContributionOrganisationActivitésRayonnement(user, pointsBySubType2);
        addPointsFromCréationStartUp(user,pointsBySubType2);
        addPointsFromDoctoratsEncadrés(user,pointsBySubType2);
        addPointsFromEditeurMembreRéféréJournalRevue(user,pointsBySubType2);
        addPointsFromEncadrementMémoiresMaster(user,pointsBySubType2);
        addPointsFromExpertiseNonRémunéré(user, pointsBySubType2);
        addPointsFromIncubationProjetRecherche(user,pointsBySubType2);
        addPointsFromOuvrageSpecialisé(user,pointsBySubType2);
        addPointsFromParticipationthèseDoctorat(user,pointsBySubType2);
        addPointsFromProjetsContratsRecherche(user,pointsBySubType2);
        addPointsFromPublicationRevuesScientifiques(user,pointsBySubType2);
        addPointsFromPublicationsRevuesIndexées(user, pointsBySubType2);
    }
    // Méthode pour ajouter les points des ouvrages
    private void addPointsFromOuvrage(User user, Map<Integer, Double> pointsBySubType2) {
        List<Ouvrage> ouvrages = ouvrageRepository.findByUser(user);
        for (Ouvrage ouvrage : ouvrages) {
            ActivitySubType2 subType2 = ouvrage.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = ouvrage.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
            }
        }

        for (Map.Entry<Integer, Double> entry : pointsBySubType2.entrySet()) {
            Integer subType2Id = entry.getKey();
            double totalPoints = entry.getValue();

            ActivitySubType2 subType2 = activitySubType2Repository.findById(subType2Id).orElse(null);
            if (subType2 != null) {
                double maxPoints = subType2.getSubTypePoints();
                if (totalPoints > maxPoints) {
                    pointsBySubType2.put(subType2Id, maxPoints);
                }
            }
        }

    }


    private void addPointsFromManuel(User user, Map<Integer, Double> pointsBySubType2) {
        List<Manuel> manuels = manuelRepository.findByUser(user);
        for (Manuel manuel: manuels) {
            ActivitySubType2 subType2 = manuel.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = manuel.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
            }
        }

        for (Map.Entry<Integer, Double> entry : pointsBySubType2.entrySet()) {
            Integer subType2Id = entry.getKey();
            double totalPoints = entry.getValue();

            ActivitySubType2 subType2 = activitySubType2Repository.findById(subType2Id).orElse(null);
            if (subType2 != null) {
                double maxPoints = subType2.getSubTypePoints();
                if (totalPoints > maxPoints) {
                    pointsBySubType2.put(subType2Id, maxPoints);
                }
            }
        }

    }

    private void addPointsFromCréationStartUp(User user,Map<Integer, Double> pointsBySubType2) {
        List<CréationStartUp> créationStartUps = créationStartUpRepository.findByUser(user);
        for (CréationStartUp créationStartUp: créationStartUps) {
            ActivitySubType2 subType2 = créationStartUp.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = créationStartUp.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
            }
        }

        for (Map.Entry<Integer, Double> entry : pointsBySubType2.entrySet()) {
            Integer subType2Id = entry.getKey();
            double totalPoints = entry.getValue();

            ActivitySubType2 subType2 = activitySubType2Repository.findById(subType2Id).orElse(null);
            if (subType2 != null) {
                double maxPoints = subType2.getSubTypePoints();
                if (totalPoints > maxPoints) {
                    pointsBySubType2.put(subType2Id, maxPoints);
                }
            }
        }

    }

    // Méthode pour ajouter les points des polycopiés pédagogiques
    private void addPointsFromPolycopiésPédagogiques(User user, Map<Integer, Double> pointsBySubType2) {
        List<PolycopiésPédagogiques> polycopiésPédagogiques = polycopiésPédagogiquesRepository.findByUser(user);
        for (PolycopiésPédagogiques polycopiésPédagogiques1 : polycopiésPédagogiques) {
            ActivitySubType2 subType2 = polycopiésPédagogiques1.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = polycopiésPédagogiques1.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
            }
        }

        for (Map.Entry<Integer, Double> entry : pointsBySubType2.entrySet()) {
            Integer subType2Id = entry.getKey();
            double totalPoints = entry.getValue();

            ActivitySubType2 subType2 = activitySubType2Repository.findById(subType2Id).orElse(null);
            if (subType2 != null) {
                double maxPoints = subType2.getSubTypePoints();
                if (totalPoints > maxPoints) {
                    pointsBySubType2.put(subType2Id, maxPoints);
                }
            }
        }

    }


    // Méthode pour ajouter les points des petits livres
    // Méthode pour ajouter les points des petits livres
    private void addPointsFromPetitsLivres(User user,  Map<Integer, Double> pointsBySubType2) {
        List<PetitsLivres> petitsLivres = petitsLivresRepository.findByUser(user);
        for (PetitsLivres petitsLivres1: petitsLivres) {
            ActivitySubType2 subType2 = petitsLivres1.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = petitsLivres1.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
            }
        }

        for (Map.Entry<Integer, Double> entry : pointsBySubType2.entrySet()) {
            Integer subType2Id = entry.getKey();
            double totalPoints = entry.getValue();

            ActivitySubType2 subType2 = activitySubType2Repository.findById(subType2Id).orElse(null);
            if (subType2 != null) {
                double maxPoints = subType2.getSubTypePoints();
                if (totalPoints > maxPoints) {
                    pointsBySubType2.put(subType2Id, maxPoints);
                }
            }
        }

    }

    // Méthode pour ajouter les points des montages expérimentaux
    private void addPointsFromMontagesExpérimentaux(User user, Map<Integer, Double> pointsBySubType2) {
        List<MontagesExpérimentaux> montagesExpérimentaux = montagesExpérimentauxRepository.findByUser(user);
        for (MontagesExpérimentaux montagesExpérimentaux1: montagesExpérimentaux) {
            ActivitySubType2 subType2 = montagesExpérimentaux1.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = montagesExpérimentaux1.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
            }
        }

        for (Map.Entry<Integer, Double> entry : pointsBySubType2.entrySet()) {
            Integer subType2Id = entry.getKey();
            double totalPoints = entry.getValue();

            ActivitySubType2 subType2 = activitySubType2Repository.findById(subType2Id).orElse(null);
            if (subType2 != null) {
                double maxPoints = subType2.getSubTypePoints();
                if (totalPoints > maxPoints) {
                    pointsBySubType2.put(subType2Id, maxPoints);
                }
            }
        }

    }

    // Méthode pour ajouter les points des préparations de sorties terrain
    // Méthode pour ajouter les points des préparation de sorties terrain
    private void addPointsFromPréparationSortiesTerrain(User user,  Map<Integer, Double> pointsBySubType2) {
        List<PréparationSortiesTerrain> préparationSortiesTerrains = préparationSortiesTerrainRepository.findByUser(user);
        for (PréparationSortiesTerrain préparationSortiesTerrain: préparationSortiesTerrains) {
            ActivitySubType2 subType2 = préparationSortiesTerrain.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = préparationSortiesTerrain.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
            }
        }

        for (Map.Entry<Integer, Double> entry : pointsBySubType2.entrySet()) {
            Integer subType2Id = entry.getKey();
            double totalPoints = entry.getValue();

            ActivitySubType2 subType2 = activitySubType2Repository.findById(subType2Id).orElse(null);
            if (subType2 != null) {
                double maxPoints = subType2.getSubTypePoints();
                if (totalPoints > maxPoints) {
                    pointsBySubType2.put(subType2Id, maxPoints);
                }
            }
        }

    }

    // Méthode pour ajouter les points des supports
    private void addPointsFromSupports(User user,  Map<Integer, Double> pointsBySubType2) {
        List<Supports> supports = supportsRepository.findByUser(user);
        for (Supports supports1: supports) {
            ActivitySubType2 subType2 = supports1.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = supports1.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
            }
        }

        for (Map.Entry<Integer, Double> entry : pointsBySubType2.entrySet()) {
            Integer subType2Id = entry.getKey();
            double totalPoints = entry.getValue();

            ActivitySubType2 subType2 = activitySubType2Repository.findById(subType2Id).orElse(null);
            if (subType2 != null) {
                double maxPoints = subType2.getSubTypePoints();
                if (totalPoints > maxPoints) {
                    pointsBySubType2.put(subType2Id, maxPoints);
                }
            }
        }

    }

    // Méthode pour ajouter les points des didacticiels
    private void addPointsFromDidacticiels(User user,  Map<Integer, Double> pointsBySubType2) {
        List<Didacticiels> didacticiels = didacticielsRepository.findByUser(user);
        for (Didacticiels didacticiels1: didacticiels) {
            ActivitySubType2 subType2 = didacticiels1.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = didacticiels1.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
            }
        }

        for (Map.Entry<Integer, Double> entry : pointsBySubType2.entrySet()) {
            Integer subType2Id = entry.getKey();
            double totalPoints = entry.getValue();

            ActivitySubType2 subType2 = activitySubType2Repository.findById(subType2Id).orElse(null);
            if (subType2 != null) {
                double maxPoints = subType2.getSubTypePoints();
                if (totalPoints > maxPoints) {
                    pointsBySubType2.put(subType2Id, maxPoints);
                }
            }
        }

    }

    // Méthode pour ajouter les points des pages web
    private void addPointsFromPageWeb(User user,Map<Integer, Double> pointsBySubType2) {
        List<PageWeb> pageWebs = pageWebRepository.findByUser(user);
        for (PageWeb pageWeb: pageWebs) {
            ActivitySubType2 subType2 = pageWeb.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = pageWeb.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
            }
        }

        for (Map.Entry<Integer, Double> entry : pointsBySubType2.entrySet()) {
            Integer subType2Id = entry.getKey();
            double totalPoints = entry.getValue();

            ActivitySubType2 subType2 = activitySubType2Repository.findById(subType2Id).orElse(null);
            if (subType2 != null) {
                double maxPoints = subType2.getSubTypePoints();
                if (totalPoints > maxPoints) {
                    pointsBySubType2.put(subType2Id, maxPoints);
                }
            }
        }

    }



    // Méthode pour ajouter les points des rapports de stage et visites de terrain
    private void addPointsFromRapportStageVisiteTerrain(User user,  Map<Integer, Double> pointsBySubType2) {
        List<RapportStageVisiteTerrain> rapportStageVisiteTerrains = rapportStageVisiteTerrainRepository.findByUser(user);
        for (RapportStageVisiteTerrain rapportStageVisiteTerrain: rapportStageVisiteTerrains) {
            ActivitySubType2 subType2 = rapportStageVisiteTerrain.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = rapportStageVisiteTerrain.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
            }
        }

        for (Map.Entry<Integer, Double> entry : pointsBySubType2.entrySet()) {
            Integer subType2Id = entry.getKey();
            double totalPoints = entry.getValue();

            ActivitySubType2 subType2 = activitySubType2Repository.findById(subType2Id).orElse(null);
            if (subType2 != null) {
                double maxPoints = subType2.getSubTypePoints();
                if (totalPoints > maxPoints) {
                    pointsBySubType2.put(subType2Id, maxPoints);
                }
            }
        }


    }


    private void addPointsFromViceDoyen(User user, Map<Integer, Double> pointsBySubType2) {
        List<ViceDoyen> viceDoyens = viceDoyenRepository.findByUser(user);
        for (ViceDoyen viceDoyen: viceDoyens) {
            ActivitySubType2 subType2 = viceDoyen.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = viceDoyen.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
            }
        }

        for (Map.Entry<Integer, Double> entry : pointsBySubType2.entrySet()) {
            Integer subType2Id = entry.getKey();
            double totalPoints = entry.getValue();

            ActivitySubType2 subType2 = activitySubType2Repository.findById(subType2Id).orElse(null);
            if (subType2 != null) {
                double maxPoints = subType2.getSubTypePoints();
                if (totalPoints > maxPoints) {
                    pointsBySubType2.put(subType2Id, maxPoints);
                }
            }
        }

    }

    private void addPointsFromAssociationConnaissance(User user,  Map<Integer, Double> pointsBySubType2) {
        List<AssociationConnaissance> associationConnaissances = associationConnaissanceRepository.findByUser(user);
        for (AssociationConnaissance associationConnaissance: associationConnaissances) {
            ActivitySubType2 subType2 = associationConnaissance.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = associationConnaissance.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
            }
        }

        for (Map.Entry<Integer, Double> entry : pointsBySubType2.entrySet()) {
            Integer subType2Id = entry.getKey();
            double totalPoints = entry.getValue();

            ActivitySubType2 subType2 = activitySubType2Repository.findById(subType2Id).orElse(null);
            if (subType2 != null) {
                double maxPoints = subType2.getSubTypePoints();
                if (totalPoints > maxPoints) {
                    pointsBySubType2.put(subType2Id, maxPoints);
                }
            }
        }

    }


    private void addPointsFromBrevet(User user, Map<Integer, Double> pointsBySubType2) {
        List<Brevet> brevets = brevetRepository.findByUser(user);
        for (Brevet brevet: brevets) {
            ActivitySubType2 subType2 = brevet.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = brevet.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
            }
        }

        for (Map.Entry<Integer, Double> entry : pointsBySubType2.entrySet()) {
            Integer subType2Id = entry.getKey();
            double totalPoints = entry.getValue();

            ActivitySubType2 subType2 = activitySubType2Repository.findById(subType2Id).orElse(null);
            if (subType2 != null) {
                double maxPoints = subType2.getSubTypePoints();
                if (totalPoints > maxPoints) {
                    pointsBySubType2.put(subType2Id, maxPoints);
                }
            }
        }

    }


    private void addPointsFromChapitreOuvrage(User user, Map<Integer, Double> pointsBySubType2) {
        List<ChapitreOuvrage> chapitreOuvrages = chapitreOuvrageRepository.findByUser(user);
        for (ChapitreOuvrage chapitreOuvrage: chapitreOuvrages) {
            ActivitySubType2 subType2 = chapitreOuvrage.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = chapitreOuvrage.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
            }
        }

        for (Map.Entry<Integer, Double> entry : pointsBySubType2.entrySet()) {
            Integer subType2Id = entry.getKey();
            double totalPoints = entry.getValue();

            ActivitySubType2 subType2 = activitySubType2Repository.findById(subType2Id).orElse(null);
            if (subType2 != null) {
                double maxPoints = subType2.getSubTypePoints();
                if (totalPoints > maxPoints) {
                    pointsBySubType2.put(subType2Id, maxPoints);
                }
            }
        }


    }


    private void addPointsFromCongrèsConférencesNonPubliées(User user, Map<Integer, Double> pointsBySubType2) {
        List<CongrèsConférencesNonPubliées> congrèsConférencesNonPubliées = congrèsConférencesNonPubliéesRepository.findByUser(user);
        for (CongrèsConférencesNonPubliées congrèsConférencesNonPubliées1: congrèsConférencesNonPubliées) {
            ActivitySubType2 subType2 = congrèsConférencesNonPubliées1.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = congrèsConférencesNonPubliées1.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
            }
        }

        for (Map.Entry<Integer, Double> entry : pointsBySubType2.entrySet()) {
            Integer subType2Id = entry.getKey();
            double totalPoints = entry.getValue();

            ActivitySubType2 subType2 = activitySubType2Repository.findById(subType2Id).orElse(null);
            if (subType2 != null) {
                double maxPoints = subType2.getSubTypePoints();
                if (totalPoints > maxPoints) {
                    pointsBySubType2.put(subType2Id, maxPoints);
                }
            }
        }

    }


    private void addPointsFromCongrèsConférencesPubliées(User user,Map<Integer, Double> pointsBySubType2) {
        List<CongrèsConférencesPubliées> congrèsConférencesPubliées = congrèsConférencesPubliéesRepository.findByUser(user);
        for (CongrèsConférencesPubliées congrèsConférencesPubliées1: congrèsConférencesPubliées) {
            ActivitySubType2 subType2 = congrèsConférencesPubliées1.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = congrèsConférencesPubliées1.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
            }
        }

        for (Map.Entry<Integer, Double> entry : pointsBySubType2.entrySet()) {
            Integer subType2Id = entry.getKey();
            double totalPoints = entry.getValue();

            ActivitySubType2 subType2 = activitySubType2Repository.findById(subType2Id).orElse(null);
            if (subType2 != null) {
                double maxPoints = subType2.getSubTypePoints();
                if (totalPoints > maxPoints) {
                    pointsBySubType2.put(subType2Id, maxPoints);
                }
            }
        }


    }



    private void addPointsFromContributionOrganisationActivitésRayonnement(User user,Map<Integer, Double> pointsBySubType2) {
        List<ContributionOrganisationActivitésRayonnement> contributionOrganisationActivitésRayonnements = contributionOrganisationActivitésRayonnementRepository.findByUser(user);
        for (ContributionOrganisationActivitésRayonnement contributionOrganisationActivitésRayonnement: contributionOrganisationActivitésRayonnements) {
            ActivitySubType2 subType2 = contributionOrganisationActivitésRayonnement.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = contributionOrganisationActivitésRayonnement.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
            }
        }

        for (Map.Entry<Integer, Double> entry : pointsBySubType2.entrySet()) {
            Integer subType2Id = entry.getKey();
            double totalPoints = entry.getValue();

            ActivitySubType2 subType2 = activitySubType2Repository.findById(subType2Id).orElse(null);
            if (subType2 != null) {
                double maxPoints = subType2.getSubTypePoints();
                if (totalPoints > maxPoints) {
                    pointsBySubType2.put(subType2Id, maxPoints);
                }
            }
        }


    }

    private void addPointsFromDoctoratsEncadrés(User user, Map<Integer, Double> pointsBySubType2) {
        List<DoctoratsEncadrés> doctoratsEncadrés = doctoratsEncadrésRepository.findByUser(user);
        for (DoctoratsEncadrés doctoratsEncadrés1: doctoratsEncadrés) {
            ActivitySubType2 subType2 = doctoratsEncadrés1.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = doctoratsEncadrés1.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
            }
        }

        for (Map.Entry<Integer, Double> entry : pointsBySubType2.entrySet()) {
            Integer subType2Id = entry.getKey();
            double totalPoints = entry.getValue();

            ActivitySubType2 subType2 = activitySubType2Repository.findById(subType2Id).orElse(null);
            if (subType2 != null) {
                double maxPoints = subType2.getSubTypePoints();
                if (totalPoints > maxPoints) {
                    pointsBySubType2.put(subType2Id, maxPoints);
                }
            }
        }

    }


    private void addPointsFromEditeurMembreRéféréJournalRevue(User user,Map<Integer, Double> pointsBySubType2) {
        List<EditeurMembreRéféréJournalRevue> editeurMembreRéféréJournalRevues = editeurMembreRéféréJournalRevueRepository.findByUser(user);
        for (EditeurMembreRéféréJournalRevue editeurMembreRéféréJournalRevue: editeurMembreRéféréJournalRevues) {
            ActivitySubType2 subType2 = editeurMembreRéféréJournalRevue.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = editeurMembreRéféréJournalRevue.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
            }
        }

        for (Map.Entry<Integer, Double> entry : pointsBySubType2.entrySet()) {
            Integer subType2Id = entry.getKey();
            double totalPoints = entry.getValue();

            ActivitySubType2 subType2 = activitySubType2Repository.findById(subType2Id).orElse(null);
            if (subType2 != null) {
                double maxPoints = subType2.getSubTypePoints();
                if (totalPoints > maxPoints) {
                    pointsBySubType2.put(subType2Id, maxPoints);
                }
            }
        }

    }

    private void addPointsFromEncadrementMémoiresMaster(User user,Map<Integer, Double> pointsBySubType2) {
        List<EncadrementMémoiresMaster> encadrementMémoiresMasters = encadrementMémoiresMasterRepository.findByUser(user);
        for (EncadrementMémoiresMaster encadrementMémoiresMaster: encadrementMémoiresMasters) {
            ActivitySubType2 subType2 = encadrementMémoiresMaster.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = encadrementMémoiresMaster.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
            }
        }

        for (Map.Entry<Integer, Double> entry : pointsBySubType2.entrySet()) {
            Integer subType2Id = entry.getKey();
            double totalPoints = entry.getValue();

            ActivitySubType2 subType2 = activitySubType2Repository.findById(subType2Id).orElse(null);
            if (subType2 != null) {
                double maxPoints = subType2.getSubTypePoints();
                if (totalPoints > maxPoints) {
                    pointsBySubType2.put(subType2Id, maxPoints);
                }
            }
        }
    }


    private void addPointsFromExpertiseNonRémunéré(User user,Map<Integer, Double> pointsBySubType2) {
        List<ExpertiseNonRémunéré> expertiseNonRémunérés = expertiseNonRémunéréRepository.findByUser(user);
        for (ExpertiseNonRémunéré expertiseNonRémunéré: expertiseNonRémunérés) {
            ActivitySubType2 subType2 = expertiseNonRémunéré.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = expertiseNonRémunéré.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
            }
        }

        for (Map.Entry<Integer, Double> entry : pointsBySubType2.entrySet()) {
            Integer subType2Id = entry.getKey();
            double totalPoints = entry.getValue();

            ActivitySubType2 subType2 = activitySubType2Repository.findById(subType2Id).orElse(null);
            if (subType2 != null) {
                double maxPoints = subType2.getSubTypePoints();
                if (totalPoints > maxPoints) {
                    pointsBySubType2.put(subType2Id, maxPoints);
                }
            }
        }
    }

    private void addPointsFromIncubationProjetRecherche(User user,  Map<Integer, Double> pointsBySubType2) {
        List<IncubationProjetRecherche> incubationProjetRecherches = incubationProjetRechercheRepository.findByUser(user);
        for (IncubationProjetRecherche incubationProjetRecherche: incubationProjetRecherches) {
            ActivitySubType2 subType2 = incubationProjetRecherche.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = incubationProjetRecherche.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
            }
        }

        for (Map.Entry<Integer, Double> entry : pointsBySubType2.entrySet()) {
            Integer subType2Id = entry.getKey();
            double totalPoints = entry.getValue();

            ActivitySubType2 subType2 = activitySubType2Repository.findById(subType2Id).orElse(null);
            if (subType2 != null) {
                double maxPoints = subType2.getSubTypePoints();
                if (totalPoints > maxPoints) {
                    pointsBySubType2.put(subType2Id, maxPoints);
                }
            }
        }

    }


    private void addPointsFromOuvrageSpecialisé(User user,  Map<Integer, Double> pointsBySubType2) {
        List<OuvrageSpecialisé> ouvrageSpecialisés = ouvrageSpecialiséRepository.findByUser(user);
        for (OuvrageSpecialisé ouvrageSpecialisé: ouvrageSpecialisés) {
            ActivitySubType2 subType2 = ouvrageSpecialisé.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = ouvrageSpecialisé.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
            }
        }

        for (Map.Entry<Integer, Double> entry : pointsBySubType2.entrySet()) {
            Integer subType2Id = entry.getKey();
            double totalPoints = entry.getValue();

            ActivitySubType2 subType2 = activitySubType2Repository.findById(subType2Id).orElse(null);
            if (subType2 != null) {
                double maxPoints = subType2.getSubTypePoints();
                if (totalPoints > maxPoints) {
                    pointsBySubType2.put(subType2Id, maxPoints);
                }
            }
        }

    }


    private void addPointsFromParticipationthèseDoctorat(User user, Map<Integer, Double> pointsBySubType2) {
        List<ParticipationthèseDoctorat> participationthèseDoctorats = participationthèseDoctoratRepository.findByUser(user);
        for (ParticipationthèseDoctorat participationthèseDoctorat: participationthèseDoctorats) {
            ActivitySubType2 subType2 = participationthèseDoctorat.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = participationthèseDoctorat.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
            }
        }

        for (Map.Entry<Integer, Double> entry : pointsBySubType2.entrySet()) {
            Integer subType2Id = entry.getKey();
            double totalPoints = entry.getValue();

            ActivitySubType2 subType2 = activitySubType2Repository.findById(subType2Id).orElse(null);
            if (subType2 != null) {
                double maxPoints = subType2.getSubTypePoints();
                if (totalPoints > maxPoints) {
                    pointsBySubType2.put(subType2Id, maxPoints);
                }
            }
        }

    }


    private void addPointsFromProjetsContratsRecherche(User user, Map<Integer, Double> pointsBySubType2) {
        List<ProjetsContratsRecherche> projetsContratsRecherches = projetsContratsRechercheRepository.findByUser(user);
        for (ProjetsContratsRecherche projetsContratsRecherche: projetsContratsRecherches) {
            ActivitySubType2 subType2 = projetsContratsRecherche.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = projetsContratsRecherche.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
            }
        }

        for (Map.Entry<Integer, Double> entry : pointsBySubType2.entrySet()) {
            Integer subType2Id = entry.getKey();
            double totalPoints = entry.getValue();

            ActivitySubType2 subType2 = activitySubType2Repository.findById(subType2Id).orElse(null);
            if (subType2 != null) {
                double maxPoints = subType2.getSubTypePoints();
                if (totalPoints > maxPoints) {
                    pointsBySubType2.put(subType2Id, maxPoints);
                }
            }
        }

    }


    private void addPointsFromPublicationRevuesScientifiques(User user, Map<Integer, Double> pointsBySubType2) {
        List<PublicationRevuesScientifiques> publicationsRevuesIndexées = publicationRevuesScientifiquesRepository.findByUser(user);
        for (PublicationRevuesScientifiques publicationRevuesScientifiques: publicationsRevuesIndexées) {
            ActivitySubType2 subType2 = publicationRevuesScientifiques.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = publicationRevuesScientifiques.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
            }
        }

        for (Map.Entry<Integer, Double> entry : pointsBySubType2.entrySet()) {
            Integer subType2Id = entry.getKey();
            double totalPoints = entry.getValue();

            ActivitySubType2 subType2 = activitySubType2Repository.findById(subType2Id).orElse(null);
            if (subType2 != null) {
                double maxPoints = subType2.getSubTypePoints();
                if (totalPoints > maxPoints) {
                    pointsBySubType2.put(subType2Id, maxPoints);
                }
            }
        }

    }

    private void addPointsFromPublicationsRevuesIndexées(User user,  Map<Integer, Double> pointsBySubType2) {
        List<PublicationsRevuesIndexées> publicationsRevuesIndexées = publicationsRevuesIndexéesRepository.findByUser(user);
        for (PublicationsRevuesIndexées publicationsRevuesIndexées1: publicationsRevuesIndexées) {
            ActivitySubType2 subType2 = publicationsRevuesIndexées1.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = publicationsRevuesIndexées1.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
            }
        }

        for (Map.Entry<Integer, Double> entry : pointsBySubType2.entrySet()) {
            Integer subType2Id = entry.getKey();
            double totalPoints = entry.getValue();

            ActivitySubType2 subType2 = activitySubType2Repository.findById(subType2Id).orElse(null);
            if (subType2 != null) {
                double maxPoints = subType2.getSubTypePoints();
                if (totalPoints > maxPoints) {
                    pointsBySubType2.put(subType2Id, maxPoints);
                }
            }
        }

    }

}

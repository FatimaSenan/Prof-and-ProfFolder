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
import org.hibernate.engine.profile.Association;
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
    public void validateActivity(String activityName, int activityId) {
        switch (activityName) {
            case "Ouvrage pédagogique et/ou didactique (ISBN ou  Maison d'édition)":
                Ouvrage ouvrage = ouvrageRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                ouvrage.setPointsAttribués(ouvrage.getActivityPoints());
                ouvrageRepository.save(ouvrage);
                break;

            case "Manuel (exercices corrigés, annales examens corrigés, etc.) (ISBN, ou validé par le chef d'établissement)":
                Manuel manuel = manuelRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                manuel.setPointsAttribués(manuel.getActivityPoints());
                manuelRepository.save(manuel);
                break;

            case "Polycopiés pédagogiques":
                PolycopiésPédagogiques polycopiésPédagogiques = polycopiésPédagogiquesRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                polycopiésPédagogiques.setPointsAttribués(polycopiésPédagogiques.getActivityPoints());
                polycopiésPédagogiquesRepository.save(polycopiésPédagogiques);
                break;

            case "Petits livres de méthodologie ou de didactique pour la lecture ou l'analyse":
                PetitsLivres petitsLivres = petitsLivresRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                petitsLivres.setPointsAttribués(petitsLivres.getActivityPoints());
                petitsLivresRepository.save(petitsLivres);
                break;

            case "Montages expérimentaux":
                MontagesExpérimentaux montagesExpérimentaux = montagesExpérimentauxRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                montagesExpérimentaux.setPointsAttribués(montagesExpérimentaux.getActivityPoints());
                montagesExpérimentauxRepository.save(montagesExpérimentaux);
                break;

            case "Préparation de sorties de terrain":
                PréparationSortiesTerrain préparationSortiesTerrain = préparationSortiesTerrainRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                préparationSortiesTerrain.setPointsAttribués(préparationSortiesTerrain.getActivityPoints());
                préparationSortiesTerrainRepository.save(préparationSortiesTerrain);
                break;

            case "Supports":
                Supports supports = supportsRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                supports.setPointsAttribués(supports.getActivityPoints());
                supportsRepository.save(supports);
                break;

            case "Didacticiels":
                Didacticiels didacticiels = didacticielsRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                didacticiels.setPointsAttribués(didacticiels.getActivityPoints());
                didacticielsRepository.save(didacticiels);
                break;

            case "Page web à caractère pédagogique":
                PageWeb pageWeb = pageWebRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                pageWeb.setPointsAttribués(pageWeb.getActivityPoints());
                pageWebRepository.save(pageWeb);
                break;

            case "MOOC : Production de contenus en ligne":
                MOOC mooc = moocRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                mooc.setPointsAttribués(mooc.getActivityPoints());
                moocRepository.save(mooc);
                break;

            case "Coordonnateur d'une filière":
                CoordonateurFilière coordonateurFilière = coordonateurFilièreRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                coordonateurFilière.setPointsAttribués(coordonateurFilière.getActivityPoints());
                coordonateurFilièreRepository.save(coordonateurFilière);
                break;

            case "Coordonnateur d'un module (ou deux au maximum )":
                CoordonateurModule coordonateurModule = coordonateurModuleRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                coordonateurModule.setPointsAttribués(coordonateurModule.getActivityPoints());
                coordonateurModuleRepository.save(coordonateurModule);
                break;

            case "Chef de département":
                ChefDépartement chefDépartement = chefDépartementRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                chefDépartement.setPointsAttribués(chefDépartement.getActivityPoints());
                chefDépartementRepository.save(chefDépartement);
                break;

            case "Vice-doyen ( non cumulable avec commission permanente)":
                ViceDoyen viceDoyen = viceDoyenRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                viceDoyen.setPointsAttribués(viceDoyen.getActivityPoints());
                viceDoyenRepository.save(viceDoyen);
                break;

            case "Membre élu du conseil d'établissement":
                MembreEluConseil membreEluConseil = membreEluConseilRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                membreEluConseil.setPointsAttribués(membreEluConseil.getActivityPoints());
                membreEluConseilRepository.save(membreEluConseil);
                break;

            case "Membre d'une commission permanente de l'établissement":
                MembreCommissionEtablissement membreCommissionEtablissement = membreCommisionEtablissementRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                membreCommissionEtablissement.setPointsAttribués(membreCommissionEtablissement.getActivityPoints());
                membreCommisionEtablissementRepository.save(membreCommissionEtablissement);
                break;

            case "Membre du conseil de coordination":
                MembreConseilCoordination membreConseilCoordination = membreConseilCoordinationRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                membreConseilCoordination.setPointsAttribués(membreConseilCoordination.getActivityPoints());
                membreConseilCoordinationRepository.save(membreConseilCoordination);
                break;

            case "Membre d'une commission permanente du conseil de coordination":
                MembreCommissionConseil membreCommissionConseil = membreCommissionConseilRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                membreCommissionConseil.setPointsAttribués(membreCommissionConseil.getActivityPoints());
                membreCommissionConseilRepository.save(membreCommissionConseil);
                break;

            case "Membre d'une commission ad hoc":
                MembreCommissionAdHoc membreCommissionAdHoc = membreCommissionAdHocRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                membreCommissionAdHoc.setPointsAttribués(membreCommissionAdHoc.getActivityPoints());
                membreCommissionAdHocRepository.save(membreCommissionAdHoc);
                break;

            case "Mémoire de PFE":
                EncadrementPFE encadrementPFE = encadrementPFERepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                encadrementPFE.setPointsAttribués(encadrementPFE.getActivityPoints());
                encadrementPFERepository.save(encadrementPFE);
                break;

            case "Rapport de stage de visite ou de terrain":
                RapportStageVisiteTerrain rapportStageVisiteTerrain = rapportStageVisiteTerrainRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                rapportStageVisiteTerrain.setPointsAttribués(rapportStageVisiteTerrain.getActivityPoints());
                rapportStageVisiteTerrainRepository.save(rapportStageVisiteTerrain);
                break;

            case "Formation de formateurs ou du Personnel administratif ou technique":
                EncadrementRH encadrementRH = encadrementRHRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                encadrementRH.setPointsAttribués(encadrementRH.getActivityPoints());
                encadrementRHRepository.save(encadrementRH);
                break;

            case "Publications dans des revues indexées dans les bases internationales  comme: SCOPUS, THOMPSON":
                PublicationsRevuesIndexées publicationsRevuesIndexées = publicationsRevuesIndexéesRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                publicationsRevuesIndexées.setPointsAttribués(publicationsRevuesIndexées.getActivityPoints());
                publicationsRevuesIndexéesRepository.save(publicationsRevuesIndexées);
                break;

            case "Publications dans des revues scientifiques nationales ou internationales à comité de lecture ISSN (tel qu'il est défini  dans la liste officielle du CNRST)":
                PublicationRevuesScientifiques publicationRevuesScientifiques = publicationRevuesScientifiquesRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                publicationRevuesScientifiques.setPointsAttribués(publicationRevuesScientifiques.getActivityPoints());
                publicationRevuesScientifiquesRepository.save(publicationRevuesScientifiques);
                break;

            case "Ouvrage spécialisé ISBN et publié par une maison d'édition":
                OuvrageSpecialisé ouvrageSpecialisé = ouvrageSpecialiséRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                ouvrageSpecialisé.setPointsAttribués(ouvrageSpecialisé.getActivityPoints());
                ouvrageSpecialiséRepository.save(ouvrageSpecialisé);
                break;

            case "Chapitre d'un ouvrage collectif publié par une maison d'édition ISBN":
                ChapitreOuvrage chapitreOuvrage = chapitreOuvrageRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                chapitreOuvrage.setPointsAttribués(chapitreOuvrage.getActivityPoints());
                chapitreOuvrageRepository.save(chapitreOuvrage);
                break;

            case "Congrès ou conférence (rédigées et publiées dans le Proceeding)(Les communications ne peuvent être comptabilisées qu'une seule fois)":
                CongrèsConférencesPubliées congrèsConférencesPubliées = congrèsConférencesPubliéesRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                congrèsConférencesPubliées.setPointsAttribués(congrèsConférencesPubliées.getActivityPoints());
                congrèsConférencesPubliéesRepository.save(congrèsConférencesPubliées);
                break;

            case "Communications dans des congrès ou des conférences (non publiés)":
                CongrèsConférencesNonPubliées congrèsConférencesNonPubliées = congrèsConférencesNonPubliéesRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                congrèsConférencesNonPubliées.setPointsAttribués(congrèsConférencesNonPubliées.getActivityPoints());
                congrèsConférencesNonPubliéesRepository.save(congrèsConférencesNonPubliées);
                break;

            case "Doctorats encadrés":
                DoctoratsEncadrés doctoratsEncadrés = doctoratsEncadrésRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                doctoratsEncadrés.setPointsAttribués(doctoratsEncadrés.getActivityPoints());
                doctoratsEncadrésRepository.save(doctoratsEncadrés);
                break;

            case "Encadrement des mémoires de Master":
                EncadrementMémoiresMaster encadrementMémoiresMaster = encadrementMémoiresMasterRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                encadrementMémoiresMaster.setPointsAttribués(encadrementMémoiresMaster.getActivityPoints());
                encadrementMémoiresMasterRepository.save(encadrementMémoiresMaster);
                break;

            case "Participaction à thèse doctorat ou d'habilitation":
                ParticipationthèseDoctorat participationthèseDoctorat = participationthèseDoctoratRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                participationthèseDoctorat.setPointsAttribués(participationthèseDoctorat.getActivityPoints());
                participationthèseDoctoratRepository.save(participationthèseDoctorat);
                break;

            case "Responsable ou membre d'une structure de recherche accréditée ou d'un pole de compétence(cumulable)":
                ResponsableMembreStructureRecherchePole responsableMembreStructureRecherchePole = responsableMembreStructureRechercheAccréditéePoleCompetenceRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                responsableMembreStructureRecherchePole.setPointsAttribués(responsableMembreStructureRecherchePole.getActivityPoints());
                responsableMembreStructureRechercheAccréditéePoleCompetenceRepository.save(responsableMembreStructureRecherchePole);
                break;

            case "Association pour la connaissance":
                AssociationConnaissance associationConnaissance = associationConnaissanceRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                associationConnaissance.setPointsAttribués(associationConnaissance.getActivityPoints());
                associationConnaissanceRepository.save(associationConnaissance);
                break;

            case "Projets ou contrats de recherche au niveau national ou international ou les deux":
                ProjetsContratsRecherche projetsContratsRecherche = projetsContratsRechercheRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                projetsContratsRecherche.setPointsAttribués(projetsContratsRecherche.getActivityPoints());
                projetsContratsRechercheRepository.save(projetsContratsRecherche);
                break;

            case "Editeur, membre ou référé d'un journal ou revue scientifique":
                EditeurMembreRéféréJournalRevue editeurMembreRéféréJournalRevue = editeurMembreRéféréJournalRevueRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                editeurMembreRéféréJournalRevue.setPointsAttribués(editeurMembreRéféréJournalRevue.getActivityPoints());
                editeurMembreRéféréJournalRevueRepository.save(editeurMembreRéféréJournalRevue);
                break;

            case "Expertise non rémunérée de projet de recherche scientifique":
                ExpertiseNonRémunéré expertiseNonRémunéré = expertiseNonRémunéréRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                expertiseNonRémunéré.setPointsAttribués(expertiseNonRémunéré.getActivityPoints());
                expertiseNonRémunéréRepository.save(expertiseNonRémunéré);
                break;

            case "Contribution à l'organisation d'activités de rayonnement de l'établissement (séminaires, congrès, colloque, ateliers, formation continue, ou autre)":
                ContributionOrganisationActivitésRayonnement contributionOrganisationActivitésRayonnement = contributionOrganisationActivitésRayonnementRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                contributionOrganisationActivitésRayonnement.setPointsAttribués(contributionOrganisationActivitésRayonnement.getActivityPoints());
                contributionOrganisationActivitésRayonnementRepository.save(contributionOrganisationActivitésRayonnement);
                break;

            case "Projet de recherche et de développement avec le secteur privé":
                ProjetDeRechercheDeveloppement projetDeRechercheDeveloppement = projetDeRechercheDeveloppementRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                projetDeRechercheDeveloppement.setPointsAttribués(projetDeRechercheDeveloppement.getActivityPoints());
                projetDeRechercheDeveloppementRepository.save(projetDeRechercheDeveloppement);
                break;

            case "Brevet":
                Brevet brevet = brevetRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                brevet.setPointsAttribués(brevet.getActivityPoints());
                brevetRepository.save(brevet);
                break;

            case "Incubation de projet de recherche et de développement":
                IncubationProjetRecherche incubationProjetRecherche = incubationProjetRechercheRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                incubationProjetRecherche.setPointsAttribués(incubationProjetRecherche.getActivityPoints());
                incubationProjetRechercheRepository.save(incubationProjetRecherche);
                break;

            case "Création de start up":
                CréationStartUp créationStartUp = créationStartUpRepository.findById(activityId)
                        .orElseThrow(() -> new IllegalArgumentException("Activité non trouvée"));
                créationStartUp.setPointsAttribués(créationStartUp.getActivityPoints());
                créationStartUpRepository.save(créationStartUp);
                break;


            default:
                throw new IllegalArgumentException("Nom d'activité invalide");
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
        addPointsFromOuvrage(user, pointsBySubType1, pointsBySubType2);
        addPointsFromManuel(user, pointsBySubType1, pointsBySubType2);
        addPointsFromPolycopiésPédagogiques(user, pointsBySubType1, pointsBySubType2);
        addPointsFromPetitsLivres(user,pointsBySubType1, pointsBySubType2);
        addPointsFromMontagesExpérimentaux(user,pointsBySubType1, pointsBySubType2);
        addPointsFromPréparationSortiesTerrain(user,pointsBySubType1, pointsBySubType2);
        addPointsFromSupports(user, pointsBySubType1,pointsBySubType2);
        addPointsFromDidacticiels(user,pointsBySubType1, pointsBySubType2);
        addPointsFromPageWeb(user, pointsBySubType1,pointsBySubType2);
        addPointsFromRapportStageVisiteTerrain(user,pointsBySubType1, pointsBySubType2);
        addPointsFromViceDoyen(user,pointsBySubType1, pointsBySubType2);
        addPointsFromAssociationConnaissance(user,pointsBySubType1, pointsBySubType2);
        addPointsFromBrevet(user,pointsBySubType1, pointsBySubType2);
        addPointsFromChapitreOuvrage(user,pointsBySubType1, pointsBySubType2);
        addPointsFromCongrèsConférencesNonPubliées(user,pointsBySubType1, pointsBySubType2);
        addPointsFromCongrèsConférencesPubliées(user,pointsBySubType1, pointsBySubType2);
        addPointsFromContributionOrganisationActivitésRayonnement(user,pointsBySubType1, pointsBySubType2);
        addPointsFromCréationStartUp(user,pointsBySubType1, pointsBySubType2);
        addPointsFromDoctoratsEncadrés(user,pointsBySubType1, pointsBySubType2);
        addPointsFromEditeurMembreRéféréJournalRevue(user,pointsBySubType1, pointsBySubType2);
        addPointsFromEncadrementMémoiresMaster(user,pointsBySubType1, pointsBySubType2);
        addPointsFromExpertiseNonRémunéré(user,pointsBySubType1, pointsBySubType2);
        addPointsFromIncubationProjetRecherche(user,pointsBySubType1, pointsBySubType2);
        addPointsFromOuvrageSpecialisé(user,pointsBySubType1, pointsBySubType2);
        addPointsFromParticipationthèseDoctorat(user,pointsBySubType1, pointsBySubType2);
        addPointsFromProjetsContratsRecherche(user,pointsBySubType1, pointsBySubType2);
        addPointsFromPublicationRevuesScientifiques(user, pointsBySubType1,pointsBySubType2);
        addPointsFromPublicationsRevuesIndexées(user,pointsBySubType1, pointsBySubType2);
        //addPointsFromResponsableMembreStructureRechercheAccréditéePoleCompetence(user, pointsBySubType2);
    }

    // Méthode pour ajouter les points des ouvrages
    private void addPointsFromOuvrage(User user, Map<Integer, Double> pointsBySubType1, Map<Integer, Double> pointsBySubType2) {
        List<Ouvrage> ouvrages = ouvrageRepository.findByUser(user);
        for (Ouvrage ouvrage : ouvrages) {
            ActivitySubType2 subType2 = ouvrage.getActivitySubType2();

            if (subType2 != null) {
                ActivitySubType1 subType1 = subType2.getActivitySubType1();

                // Vérifie si subType1 est non null avant d'accéder à son ID et ActivityType
                if (subType1 != null) {
                    ActivityType activityType1 = subType1.getActivityType();

                    // Vérifie si activityType1 est non null avant d'accéder à son ID
                    if (activityType1 != null) {
                        // Vérifie si l'ID de activityType1 correspond à 1
                        if (activityType1.getId_type() == 1) {
                            Integer subType1Id = subType1.getId_subtype1();
                            double points = ouvrage.getPointsAttribués();
                            pointsBySubType1.put(subType1Id, pointsBySubType1.getOrDefault(subType1Id, 0.0) + points);
                        }
                    }
                }

                // Vérifie si subType2 est non null avant d'accéder à son ActivityType
                ActivityType activityType2 = subType2.getActivityType();

                // Vérifie si activityType2 est non null avant d'accéder à son ID
                if (activityType2 != null && activityType2.getId_type() == 2) {
                    Integer subType2Id = subType2.getId_subtype2();
                    double points = ouvrage.getPointsAttribués();
                    pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
                }
            }
        }
    }


    private void addPointsFromManuel(User user, Map<Integer, Double> pointsBySubType1, Map<Integer, Double> pointsBySubType2) {
        List<Manuel> manuels = manuelRepository.findByUser(user);
        for (Manuel manuel : manuels) {
            ActivitySubType2 subType2 = manuel.getActivitySubType2();

            if (subType2 != null) {
                ActivitySubType1 subType1 = subType2.getActivitySubType1();

                // Vérifie si subType1 est non null avant d'accéder à son ID et ActivityType
                if (subType1 != null) {
                    ActivityType activityType1 = subType1.getActivityType();

                    // Vérifie si activityType1 est non null avant d'accéder à son ID
                    if (activityType1 != null) {
                        // Vérifie si l'ID de activityType1 correspond à 1
                        if (activityType1.getId_type() == 1) {
                            Integer subType1Id = subType1.getId_subtype1();
                            double points = manuel.getPointsAttribués();
                            pointsBySubType1.put(subType1Id, pointsBySubType1.getOrDefault(subType1Id, 0.0) + points);
                        }
                    }
                }

                // Vérifie si subType2 est non null avant d'accéder à son ActivityType
                ActivityType activityType2 = subType2.getActivityType();

                // Vérifie si activityType2 est non null avant d'accéder à son ID
                if (activityType2 != null && activityType2.getId_type() == 2) {
                    Integer subType2Id = subType2.getId_subtype2();
                    double points = manuel.getPointsAttribués();
                    pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
                }
            }
        }
    }

    private void addPointsFromCréationStartUp(User user, Map<Integer, Double> pointsBySubType1, Map<Integer, Double> pointsBySubType2) {
        List<CréationStartUp> créations = créationStartUpRepository.findByUser(user);
        for (CréationStartUp création : créations) {
            ActivitySubType2 subType2 = création.getActivitySubType2();

            if (subType2 != null) {
                ActivitySubType1 subType1 = subType2.getActivitySubType1();

                // Vérifie si subType1 est non null avant d'accéder à son ID et ActivityType
                if (subType1 != null) {
                    ActivityType activityType1 = subType1.getActivityType();

                    // Vérifie si activityType1 est non null avant d'accéder à son ID
                    if (activityType1 != null) {
                        // Vérifie si l'ID de activityType1 correspond à 1
                        if (activityType1.getId_type() == 1) {
                            Integer subType1Id = subType1.getId_subtype1();
                            double points = création.getPointsAttribués();
                            pointsBySubType1.put(subType1Id, pointsBySubType1.getOrDefault(subType1Id, 0.0) + points);
                        }
                    }
                }

                // Vérifie si subType2 est non null avant d'accéder à son ActivityType
                ActivityType activityType2 = subType2.getActivityType();

                // Vérifie si activityType2 est non null avant d'accéder à son ID
                if (activityType2 != null && activityType2.getId_type() == 2) {
                    Integer subType2Id = subType2.getId_subtype2();
                    double points = création.getPointsAttribués();
                    pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
                }
            }
        }
    }

    // Méthode pour ajouter les points des polycopiés pédagogiques
    private void addPointsFromPolycopiésPédagogiques(User user, Map<Integer, Double> pointsBySubType1, Map<Integer, Double> pointsBySubType2) {
        List<PolycopiésPédagogiques> polycopiésPédagogiquesList = polycopiésPédagogiquesRepository.findByUser(user);
        for (PolycopiésPédagogiques polycopiésPédagogiques : polycopiésPédagogiquesList) {
            ActivitySubType2 subType2 = polycopiésPédagogiques.getActivitySubType2();

            if (subType2 != null) {
                ActivitySubType1 subType1 = subType2.getActivitySubType1();

                // Vérifie si subType1 est non null avant d'accéder à son ID et ActivityType
                if (subType1 != null) {
                    ActivityType activityType1 = subType1.getActivityType();

                    // Vérifie si activityType1 est non null avant d'accéder à son ID
                    if (activityType1 != null) {
                        // Vérifie si l'ID de activityType1 correspond à 1
                        if (activityType1.getId_type() == 1) {
                            Integer subType1Id = subType1.getId_subtype1();
                            double points = polycopiésPédagogiques.getPointsAttribués();
                            pointsBySubType1.put(subType1Id, pointsBySubType1.getOrDefault(subType1Id, 0.0) + points);
                        }
                    }
                }

                // Vérifie si subType2 est non null avant d'accéder à son ActivityType
                ActivityType activityType2 = subType2.getActivityType();

                // Vérifie si activityType2 est non null avant d'accéder à son ID
                if (activityType2 != null && activityType2.getId_type() == 2) {
                    Integer subType2Id = subType2.getId_subtype2();
                    double points = polycopiésPédagogiques.getPointsAttribués();
                    pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
                }
            }
        }
    }


    // Méthode pour ajouter les points des petits livres
    // Méthode pour ajouter les points des petits livres
    private void addPointsFromPetitsLivres(User user, Map<Integer, Double> pointsBySubType1, Map<Integer, Double> pointsBySubType2) {
        List<PetitsLivres> petitsLivresList = petitsLivresRepository.findByUser(user);
        for (PetitsLivres petitsLivres : petitsLivresList) {
            ActivitySubType2 subType2 = petitsLivres.getActivitySubType2();

            if (subType2 != null) {
                ActivitySubType1 subType1 = subType2.getActivitySubType1();

                // Vérifie si subType1 est non null avant d'accéder à son ID et ActivityType
                if (subType1 != null) {
                    ActivityType activityType1 = subType1.getActivityType();

                    // Vérifie si activityType1 est non null avant d'accéder à son ID
                    if (activityType1 != null) {
                        // Vérifie si l'ID de activityType1 correspond à 1
                        if (activityType1.getId_type() == 1) {
                            Integer subType1Id = subType1.getId_subtype1();
                            double points = petitsLivres.getPointsAttribués();
                            pointsBySubType1.put(subType1Id, pointsBySubType1.getOrDefault(subType1Id, 0.0) + points);
                        }
                    }
                }

                // Vérifie si subType2 est non null avant d'accéder à son ActivityType
                ActivityType activityType2 = subType2.getActivityType();

                // Vérifie si activityType2 est non null avant d'accéder à son ID
                if (activityType2 != null && activityType2.getId_type() == 2) {
                    Integer subType2Id = subType2.getId_subtype2();
                    double points = petitsLivres.getPointsAttribués();
                    pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
                }
            }
        }
    }

    // Méthode pour ajouter les points des montages expérimentaux
    private void addPointsFromMontagesExpérimentaux(User user, Map<Integer, Double> pointsBySubType1, Map<Integer, Double> pointsBySubType2) {
        List<MontagesExpérimentaux> montagesExpérimentauxList = montagesExpérimentauxRepository.findByUser(user);
        for (MontagesExpérimentaux montagesExpérimentaux : montagesExpérimentauxList) {
            ActivitySubType2 subType2 = montagesExpérimentaux.getActivitySubType2();

            if (subType2 != null) {
                ActivitySubType1 subType1 = subType2.getActivitySubType1();

                // Vérifie si subType1 est non null avant d'accéder à son ID et ActivityType
                if (subType1 != null) {
                    ActivityType activityType1 = subType1.getActivityType();

                    // Vérifie si activityType1 est non null avant d'accéder à son ID
                    if (activityType1 != null) {
                        // Vérifie si l'ID de activityType1 correspond à 1
                        if (activityType1.getId_type() == 1) {
                            Integer subType1Id = subType1.getId_subtype1();
                            double points = montagesExpérimentaux.getPointsAttribués();
                            pointsBySubType1.put(subType1Id, pointsBySubType1.getOrDefault(subType1Id, 0.0) + points);
                        }
                    }
                }

                // Vérifie si subType2 est non null avant d'accéder à son ActivityType
                ActivityType activityType2 = subType2.getActivityType();

                // Vérifie si activityType2 est non null avant d'accéder à son ID
                if (activityType2 != null && activityType2.getId_type() == 2) {
                    Integer subType2Id = subType2.getId_subtype2();
                    double points = montagesExpérimentaux.getPointsAttribués();
                    pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
                }
            }
        }
    }

    // Méthode pour ajouter les points des préparations de sorties terrain
    // Méthode pour ajouter les points des préparation de sorties terrain
    private void addPointsFromPréparationSortiesTerrain(User user, Map<Integer, Double> pointsBySubType1, Map<Integer, Double> pointsBySubType2) {
        List<PréparationSortiesTerrain> préparationSortiesTerrainList = préparationSortiesTerrainRepository.findByUser(user);
        for (PréparationSortiesTerrain préparationSortiesTerrain : préparationSortiesTerrainList) {
            ActivitySubType2 subType2 = préparationSortiesTerrain.getActivitySubType2();

            if (subType2 != null) {
                ActivitySubType1 subType1 = subType2.getActivitySubType1();

                // Vérifie si subType1 est non null avant d'accéder à son ID et ActivityType
                if (subType1 != null) {
                    ActivityType activityType1 = subType1.getActivityType();

                    // Vérifie si activityType1 est non null avant d'accéder à son ID
                    if (activityType1 != null) {
                        // Vérifie si l'ID de activityType1 correspond à 1
                        if (activityType1.getId_type() == 1) {
                            Integer subType1Id = subType1.getId_subtype1();
                            double points = préparationSortiesTerrain.getPointsAttribués();
                            pointsBySubType1.put(subType1Id, pointsBySubType1.getOrDefault(subType1Id, 0.0) + points);
                        }
                    }
                }

                // Vérifie si subType2 est non null avant d'accéder à son ActivityType
                ActivityType activityType2 = subType2.getActivityType();

                // Vérifie si activityType2 est non null avant d'accéder à son ID
                if (activityType2 != null && activityType2.getId_type() == 2) {
                    Integer subType2Id = subType2.getId_subtype2();
                    double points = préparationSortiesTerrain.getPointsAttribués();
                    pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
                }
            }
        }
    }

    // Méthode pour ajouter les points des supports
    private void addPointsFromSupports(User user, Map<Integer, Double> pointsBySubType1, Map<Integer, Double> pointsBySubType2) {
        List<Supports> supportsList = supportsRepository.findByUser(user);
        for (Supports supports : supportsList) {
            ActivitySubType2 subType2 = supports.getActivitySubType2();

            if (subType2 != null) {
                ActivitySubType1 subType1 = subType2.getActivitySubType1();

                // Vérifie si subType1 est non null avant d'accéder à son ID et ActivityType
                if (subType1 != null) {
                    ActivityType activityType1 = subType1.getActivityType();

                    // Vérifie si activityType1 est non null avant d'accéder à son ID
                    if (activityType1 != null) {
                        // Vérifie si l'ID de activityType1 correspond à 1
                        if (activityType1.getId_type() == 1) {
                            Integer subType1Id = subType1.getId_subtype1();
                            double points = supports.getPointsAttribués();
                            pointsBySubType1.put(subType1Id, pointsBySubType1.getOrDefault(subType1Id, 0.0) + points);
                        }
                    }
                }

                // Vérifie si subType2 est non null avant d'accéder à son ActivityType
                ActivityType activityType2 = subType2.getActivityType();

                // Vérifie si activityType2 est non null avant d'accéder à son ID
                if (activityType2 != null && activityType2.getId_type() == 2) {
                    Integer subType2Id = subType2.getId_subtype2();
                    double points = supports.getPointsAttribués();
                    pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
                }
            }
        }
    }

    // Méthode pour ajouter les points des didacticiels
    private void addPointsFromDidacticiels(User user, Map<Integer, Double> pointsBySubType1, Map<Integer, Double> pointsBySubType2) {
        List<Didacticiels> didacticielsList = didacticielsRepository.findByUser(user);
        for (Didacticiels didacticiels : didacticielsList) {
            ActivitySubType2 subType2 = didacticiels.getActivitySubType2();

            if (subType2 != null) {
                ActivitySubType1 subType1 = subType2.getActivitySubType1();

                // Vérifie si subType1 est non null avant d'accéder à son ID et ActivityType
                if (subType1 != null) {
                    ActivityType activityType1 = subType1.getActivityType();

                    // Vérifie si activityType1 est non null avant d'accéder à son ID
                    if (activityType1 != null) {
                        // Vérifie si l'ID de activityType1 correspond à 1
                        if (activityType1.getId_type() == 1) {
                            Integer subType1Id = subType1.getId_subtype1();
                            double points = didacticiels.getPointsAttribués();
                            pointsBySubType1.put(subType1Id, pointsBySubType1.getOrDefault(subType1Id, 0.0) + points);
                        }
                    }
                }

                // Vérifie si subType2 est non null avant d'accéder à son ActivityType
                ActivityType activityType2 = subType2.getActivityType();

                // Vérifie si activityType2 est non null avant d'accéder à son ID
                if (activityType2 != null && activityType2.getId_type() == 2) {
                    Integer subType2Id = subType2.getId_subtype2();
                    double points = didacticiels.getPointsAttribués();
                    pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
                }
            }
        }
    }

    // Méthode pour ajouter les points des pages web
    private void addPointsFromPageWeb(User user, Map<Integer, Double> pointsBySubType1, Map<Integer, Double> pointsBySubType2) {
        List<PageWeb> pageWebList = pageWebRepository.findByUser(user);
        for (PageWeb pageWeb : pageWebList) {
            ActivitySubType2 subType2 = pageWeb.getActivitySubType2();

            if (subType2 != null) {
                ActivitySubType1 subType1 = subType2.getActivitySubType1();

                // Vérifie si subType1 est non null avant d'accéder à son ID et ActivityType
                if (subType1 != null) {
                    ActivityType activityType1 = subType1.getActivityType();

                    // Vérifie si activityType1 est non null avant d'accéder à son ID
                    if (activityType1 != null) {
                        // Vérifie si l'ID de activityType1 correspond à 1
                        if (activityType1.getId_type() == 1) {
                            Integer subType1Id = subType1.getId_subtype1();
                            double points = pageWeb.getPointsAttribués();
                            pointsBySubType1.put(subType1Id, pointsBySubType1.getOrDefault(subType1Id, 0.0) + points);
                        }
                    }
                }

                // Vérifie si subType2 est non null avant d'accéder à son ActivityType
                ActivityType activityType2 = subType2.getActivityType();

                // Vérifie si activityType2 est non null avant d'accéder à son ID
                if (activityType2 != null && activityType2.getId_type() == 2) {
                    Integer subType2Id = subType2.getId_subtype2();
                    double points = pageWeb.getPointsAttribués();
                    pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
                }
            }
        }
    }



    // Méthode pour ajouter les points des rapports de stage et visites de terrain
    private void addPointsFromRapportStageVisiteTerrain(User user, Map<Integer, Double> pointsBySubType1, Map<Integer, Double> pointsBySubType2) {
        List<RapportStageVisiteTerrain> rapportStageVisiteTerrainList = rapportStageVisiteTerrainRepository.findByUser(user);
        for (RapportStageVisiteTerrain rapportStageVisiteTerrain : rapportStageVisiteTerrainList) {
            ActivitySubType2 subType2 = rapportStageVisiteTerrain.getActivitySubType2();

            if (subType2 != null) {
                ActivitySubType1 subType1 = subType2.getActivitySubType1();

                // Vérifie si subType1 est non null avant d'accéder à son ID et ActivityType
                if (subType1 != null) {
                    ActivityType activityType1 = subType1.getActivityType();

                    // Vérifie si activityType1 est non null avant d'accéder à son ID
                    if (activityType1 != null) {
                        // Vérifie si l'ID de activityType1 correspond à 1
                        if (activityType1.getId_type() == 1) {
                            Integer subType1Id = subType1.getId_subtype1();
                            double points = rapportStageVisiteTerrain.getPointsAttribués();
                            pointsBySubType1.put(subType1Id, pointsBySubType1.getOrDefault(subType1Id, 0.0) + points);
                        }
                    }
                }

                // Vérifie si subType2 est non null avant d'accéder à son ActivityType
                ActivityType activityType2 = subType2.getActivityType();

                // Vérifie si activityType2 est non null avant d'accéder à son ID
                if (activityType2 != null && activityType2.getId_type() == 2) {
                    Integer subType2Id = subType2.getId_subtype2();
                    double points = rapportStageVisiteTerrain.getPointsAttribués();
                    pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
                }
            }
        }
    }


    private void addPointsFromViceDoyen(User user, Map<Integer, Double> pointsBySubType1, Map<Integer, Double> pointsBySubType2) {
        List<ViceDoyen> viceDoyens = viceDoyenRepository.findByUser(user);
        for (ViceDoyen viceDoyen : viceDoyens) {
            ActivitySubType2 subType2 = viceDoyen.getActivitySubType2();

            if (subType2 != null) {
                ActivitySubType1 subType1 = subType2.getActivitySubType1();

                // Vérifie si subType1 est non null avant d'accéder à son ID et ActivityType
                if (subType1 != null) {
                    ActivityType activityType1 = subType1.getActivityType();

                    // Vérifie si activityType1 est non null avant d'accéder à son ID
                    if (activityType1 != null) {
                        // Vérifie si l'ID de activityType1 correspond à 1
                        if (activityType1.getId_type() == 1) {
                            Integer subType1Id = subType1.getId_subtype1();
                            double points = viceDoyen.getPointsAttribués();
                            pointsBySubType1.put(subType1Id, pointsBySubType1.getOrDefault(subType1Id, 0.0) + points);
                        }
                    }
                }

                // Vérifie si subType2 est non null avant d'accéder à son ActivityType
                ActivityType activityType2 = subType2.getActivityType();

                // Vérifie si activityType2 est non null avant d'accéder à son ID
                if (activityType2 != null && activityType2.getId_type() == 2) {
                    Integer subType2Id = subType2.getId_subtype2();
                    double points = viceDoyen.getPointsAttribués();
                    pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
                }
            }
        }
    }

    private void addPointsFromAssociationConnaissance(User user, Map<Integer, Double> pointsBySubType1, Map<Integer, Double> pointsBySubType2) {
        List<AssociationConnaissance> associations = associationConnaissanceRepository.findByUser(user);
        for (AssociationConnaissance association : associations) {
            ActivitySubType2 subType2 = association.getActivitySubType2();

            if (subType2 != null) {
                ActivitySubType1 subType1 = subType2.getActivitySubType1();

                // Vérifie si subType1 est non null avant d'accéder à son ID et ActivityType
                if (subType1 != null) {
                    ActivityType activityType1 = subType1.getActivityType();

                    // Vérifie si activityType1 est non null avant d'accéder à son ID
                    if (activityType1 != null) {
                        // Vérifie si l'ID de activityType1 correspond à 1
                        if (activityType1.getId_type() == 1) {
                            Integer subType1Id = subType1.getId_subtype1();
                            double points = association.getPointsAttribués();
                            pointsBySubType1.put(subType1Id, pointsBySubType1.getOrDefault(subType1Id, 0.0) + points);
                        }
                    }
                }

                // Vérifie si subType2 est non null avant d'accéder à son ActivityType
                ActivityType activityType2 = subType2.getActivityType();

                // Vérifie si activityType2 est non null avant d'accéder à son ID
                if (activityType2 != null && activityType2.getId_type() == 2) {
                    Integer subType2Id = subType2.getId_subtype2();
                    double points = association.getPointsAttribués();
                    pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
                }
            }
        }
    }


    private void addPointsFromBrevet(User user, Map<Integer, Double> pointsBySubType1, Map<Integer, Double> pointsBySubType2) {
        List<Brevet> brevets = brevetRepository.findByUser(user);
        for (Brevet brevet : brevets) {
            ActivitySubType2 subType2 = brevet.getActivitySubType2();

            if (subType2 != null) {
                ActivitySubType1 subType1 = subType2.getActivitySubType1();

                // Vérifie si subType1 est non null avant d'accéder à son ID et ActivityType
                if (subType1 != null) {
                    ActivityType activityType1 = subType1.getActivityType();

                    // Vérifie si activityType1 est non null avant d'accéder à son ID
                    if (activityType1 != null) {
                        // Vérifie si l'ID de activityType1 correspond à 1
                        if (activityType1.getId_type() == 1) {
                            Integer subType1Id = subType1.getId_subtype1();
                            double points = brevet.getPointsAttribués();
                            pointsBySubType1.put(subType1Id, pointsBySubType1.getOrDefault(subType1Id, 0.0) + points);
                        }
                    }
                }

                // Vérifie si subType2 est non null avant d'accéder à son ActivityType
                ActivityType activityType2 = subType2.getActivityType();

                // Vérifie si activityType2 est non null avant d'accéder à son ID
                if (activityType2 != null && activityType2.getId_type() == 2) {
                    Integer subType2Id = subType2.getId_subtype2();
                    double points = brevet.getPointsAttribués();
                    pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
                }
            }
        }
    }


    private void addPointsFromChapitreOuvrage(User user, Map<Integer, Double> pointsBySubType1, Map<Integer, Double> pointsBySubType2) {
        List<ChapitreOuvrage> chapitres = chapitreOuvrageRepository.findByUser(user);
        for (ChapitreOuvrage chapitre : chapitres) {
            ActivitySubType2 subType2 = chapitre.getActivitySubType2();

            if (subType2 != null) {
                ActivitySubType1 subType1 = subType2.getActivitySubType1();

                // Vérifie si subType1 est non null avant d'accéder à son ID et ActivityType
                if (subType1 != null) {
                    ActivityType activityType1 = subType1.getActivityType();

                    // Vérifie si activityType1 est non null avant d'accéder à son ID
                    if (activityType1 != null) {
                        // Vérifie si l'ID de activityType1 correspond à 1
                        if (activityType1.getId_type() == 1) {
                            Integer subType1Id = subType1.getId_subtype1();
                            double points = chapitre.getPointsAttribués();
                            pointsBySubType1.put(subType1Id, pointsBySubType1.getOrDefault(subType1Id, 0.0) + points);
                        }
                    }
                }

                // Vérifie si subType2 est non null avant d'accéder à son ActivityType
                ActivityType activityType2 = subType2.getActivityType();

                // Vérifie si activityType2 est non null avant d'accéder à son ID
                if (activityType2 != null && activityType2.getId_type() == 2) {
                    Integer subType2Id = subType2.getId_subtype2();
                    double points = chapitre.getPointsAttribués();
                    pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
                }
            }
        }
    }


    private void addPointsFromCongrèsConférencesNonPubliées(User user, Map<Integer, Double> pointsBySubType1, Map<Integer, Double> pointsBySubType2) {
        List<CongrèsConférencesNonPubliées> conférences = congrèsConférencesNonPubliéesRepository.findByUser(user);
        for (CongrèsConférencesNonPubliées conférence : conférences) {
            ActivitySubType2 subType2 = conférence.getActivitySubType2();

            if (subType2 != null) {
                ActivitySubType1 subType1 = subType2.getActivitySubType1();

                // Vérifie si subType1 est non null avant d'accéder à son ID et ActivityType
                if (subType1 != null) {
                    ActivityType activityType1 = subType1.getActivityType();

                    // Vérifie si activityType1 est non null avant d'accéder à son ID
                    if (activityType1 != null) {
                        // Vérifie si l'ID de activityType1 correspond à 1
                        if (activityType1.getId_type() == 1) {
                            Integer subType1Id = subType1.getId_subtype1();
                            double points = conférence.getPointsAttribués();
                            pointsBySubType1.put(subType1Id, pointsBySubType1.getOrDefault(subType1Id, 0.0) + points);
                        }
                    }
                }

                // Vérifie si subType2 est non null avant d'accéder à son ActivityType
                ActivityType activityType2 = subType2.getActivityType();

                // Vérifie si activityType2 est non null avant d'accéder à son ID
                if (activityType2 != null && activityType2.getId_type() == 2) {
                    Integer subType2Id = subType2.getId_subtype2();
                    double points = conférence.getPointsAttribués();
                    pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
                }
            }
        }
    }


    private void addPointsFromCongrèsConférencesPubliées(User user, Map<Integer, Double> pointsBySubType1, Map<Integer, Double> pointsBySubType2) {
        List<CongrèsConférencesPubliées> conférences = congrèsConférencesPubliéesRepository.findByUser(user);
        for (CongrèsConférencesPubliées conférence : conférences) {
            ActivitySubType2 subType2 = conférence.getActivitySubType2();

            if (subType2 != null) {
                ActivitySubType1 subType1 = subType2.getActivitySubType1();

                // Vérifie si subType1 est non null avant d'accéder à son ID et ActivityType
                if (subType1 != null) {
                    ActivityType activityType1 = subType1.getActivityType();

                    // Vérifie si activityType1 est non null avant d'accéder à son ID
                    if (activityType1 != null) {
                        // Vérifie si l'ID de activityType1 correspond à 1
                        if (activityType1.getId_type() == 1) {
                            Integer subType1Id = subType1.getId_subtype1();
                            double points = conférence.getPointsAttribués();
                            pointsBySubType1.put(subType1Id, pointsBySubType1.getOrDefault(subType1Id, 0.0) + points);
                        }
                    }
                }

                // Vérifie si subType2 est non null avant d'accéder à son ActivityType
                ActivityType activityType2 = subType2.getActivityType();

                // Vérifie si activityType2 est non null avant d'accéder à son ID
                if (activityType2 != null && activityType2.getId_type() == 2) {
                    Integer subType2Id = subType2.getId_subtype2();
                    double points = conférence.getPointsAttribués();
                    pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
                }
            }
        }
    }



    private void addPointsFromContributionOrganisationActivitésRayonnement(User user, Map<Integer, Double> pointsBySubType1, Map<Integer, Double> pointsBySubType2) {
        List<ContributionOrganisationActivitésRayonnement> contributions = contributionOrganisationActivitésRayonnementRepository.findByUser(user);
        for (ContributionOrganisationActivitésRayonnement contribution : contributions) {
            ActivitySubType2 subType2 = contribution.getActivitySubType2();

            if (subType2 != null) {
                ActivitySubType1 subType1 = subType2.getActivitySubType1();

                // Vérifie si subType1 est non null avant d'accéder à son ID et ActivityType
                if (subType1 != null) {
                    ActivityType activityType1 = subType1.getActivityType();

                    // Vérifie si activityType1 est non null avant d'accéder à son ID
                    if (activityType1 != null) {
                        // Vérifie si l'ID de activityType1 correspond à 1
                        if (activityType1.getId_type() == 1) {
                            Integer subType1Id = subType1.getId_subtype1();
                            double points = contribution.getPointsAttribués();
                            pointsBySubType1.put(subType1Id, pointsBySubType1.getOrDefault(subType1Id, 0.0) + points);
                        }
                    }
                }

                // Vérifie si subType2 est non null avant d'accéder à son ActivityType
                ActivityType activityType2 = subType2.getActivityType();

                // Vérifie si activityType2 est non null avant d'accéder à son ID
                if (activityType2 != null && activityType2.getId_type() == 2) {
                    Integer subType2Id = subType2.getId_subtype2();
                    double points = contribution.getPointsAttribués();
                    pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
                }
            }
        }
    }

    private void addPointsFromDoctoratsEncadrés(User user, Map<Integer, Double> pointsBySubType1, Map<Integer, Double> pointsBySubType2) {
        List<DoctoratsEncadrés> doctorats = doctoratsEncadrésRepository.findByUser(user);
        for (DoctoratsEncadrés doctorat : doctorats) {
            ActivitySubType2 subType2 = doctorat.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = doctorat.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);

                // Accéder à subType1 à partir de subType2
                ActivitySubType1 subType1 = subType2.getActivitySubType1();

                if (subType1 != null) {
                    Integer subType1Id = subType1.getId_subtype1();
                    pointsBySubType1.put(subType1Id, pointsBySubType1.getOrDefault(subType1Id, 0.0) + points);
                }
            }
        }
    }



    private void addPointsFromEditeurMembreRéféréJournalRevue(User user, Map<Integer, Double> pointsBySubType1, Map<Integer, Double> pointsBySubType2) {
        List<EditeurMembreRéféréJournalRevue> éditeurs = editeurMembreRéféréJournalRevueRepository.findByUser(user);
        for (EditeurMembreRéféréJournalRevue éditeur : éditeurs) {
            ActivitySubType2 subType2 = éditeur.getActivitySubType2();

            if (subType2 != null) {
                ActivitySubType1 subType1 = subType2.getActivitySubType1();

                // Vérifie si subType1 est non null avant d'accéder à son ID et ActivityType
                if (subType1 != null) {
                    ActivityType activityType1 = subType1.getActivityType();

                    // Vérifie si activityType1 est non null avant d'accéder à son ID
                    if (activityType1 != null) {
                        // Vérifie si l'ID de activityType1 correspond à 1
                        if (activityType1.getId_type() == 1) {
                            Integer subType1Id = subType1.getId_subtype1();
                            double points = éditeur.getPointsAttribués();
                            pointsBySubType1.put(subType1Id, pointsBySubType1.getOrDefault(subType1Id, 0.0) + points);
                        }
                    }
                }

                // Vérifie si subType2 est non null avant d'accéder à son ActivityType
                ActivityType activityType2 = subType2.getActivityType();

                // Vérifie si activityType2 est non null avant d'accéder à son ID
                if (activityType2 != null && activityType2.getId_type() == 2) {
                    Integer subType2Id = subType2.getId_subtype2();
                    double points = éditeur.getPointsAttribués();
                    pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
                }
            }
        }
    }

    private void addPointsFromEncadrementMémoiresMaster(User user, Map<Integer, Double> pointsBySubType1, Map<Integer, Double> pointsBySubType2) {
        List<EncadrementMémoiresMaster> encadrements = encadrementMémoiresMasterRepository.findByUser(user);
        for (EncadrementMémoiresMaster encadrement : encadrements) {
            ActivitySubType2 subType2 = encadrement.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = encadrement.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);

                // Accéder à subType1 à partir de subType2
                ActivitySubType1 subType1 = subType2.getActivitySubType1();

                if (subType1 != null) {
                    Integer subType1Id = subType1.getId_subtype1();
                    pointsBySubType1.put(subType1Id, pointsBySubType1.getOrDefault(subType1Id, 0.0) + points);
                }
            }
        }
    }



    private void addPointsFromExpertiseNonRémunéré(User user, Map<Integer, Double> pointsBySubType1, Map<Integer, Double> pointsBySubType2) {
        List<ExpertiseNonRémunéré> expertises = expertiseNonRémunéréRepository.findByUser(user);
        for (ExpertiseNonRémunéré expertise : expertises) {
            ActivitySubType2 subType2 = expertise.getActivitySubType2();

            if (subType2 != null) {
                ActivitySubType1 subType1 = subType2.getActivitySubType1();

                // Vérifie si subType1 est non null avant d'accéder à son ID et ActivityType
                if (subType1 != null) {
                    ActivityType activityType1 = subType1.getActivityType();

                    // Vérifie si activityType1 est non null avant d'accéder à son ID
                    if (activityType1 != null) {
                        // Vérifie si l'ID de activityType1 correspond à 1
                        if (activityType1.getId_type() == 1) {
                            Integer subType1Id = subType1.getId_subtype1();
                            double points = expertise.getPointsAttribués();
                            pointsBySubType1.put(subType1Id, pointsBySubType1.getOrDefault(subType1Id, 0.0) + points);
                        }
                    }
                }

                // Vérifie si subType2 est non null avant d'accéder à son ActivityType
                ActivityType activityType2 = subType2.getActivityType();

                // Vérifie si activityType2 est non null avant d'accéder à son ID
                if (activityType2 != null && activityType2.getId_type() == 2) {
                    Integer subType2Id = subType2.getId_subtype2();
                    double points = expertise.getPointsAttribués();
                    pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
                }
            }
        }
    }

    private void addPointsFromIncubationProjetRecherche(User user, Map<Integer, Double> pointsBySubType1, Map<Integer, Double> pointsBySubType2) {
        List<IncubationProjetRecherche> incubations = incubationProjetRechercheRepository.findByUser(user);
        for (IncubationProjetRecherche incubation : incubations) {
            ActivitySubType2 subType2 = incubation.getActivitySubType2();

            if (subType2 != null) {
                ActivitySubType1 subType1 = subType2.getActivitySubType1();

                // Vérifie si subType1 est non null avant d'accéder à son ID et ActivityType
                if (subType1 != null) {
                    ActivityType activityType1 = subType1.getActivityType();

                    // Vérifie si activityType1 est non null avant d'accéder à son ID
                    if (activityType1 != null) {
                        // Vérifie si l'ID de activityType1 correspond à 1
                        if (activityType1.getId_type() == 1) {
                            Integer subType1Id = subType1.getId_subtype1();
                            double points = incubation.getPointsAttribués();
                            pointsBySubType1.put(subType1Id, pointsBySubType1.getOrDefault(subType1Id, 0.0) + points);
                        }
                    }
                }

                // Vérifie si subType2 est non null avant d'accéder à son ActivityType
                ActivityType activityType2 = subType2.getActivityType();

                // Vérifie si activityType2 est non null avant d'accéder à son ID
                if (activityType2 != null && activityType2.getId_type() == 2) {
                    Integer subType2Id = subType2.getId_subtype2();
                    double points = incubation.getPointsAttribués();
                    pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
                }
            }
        }
    }


    private void addPointsFromOuvrageSpecialisé(User user, Map<Integer, Double> pointsBySubType1, Map<Integer, Double> pointsBySubType2) {
        List<OuvrageSpecialisé> ouvrages = ouvrageSpecialiséRepository.findByUser(user);
        for (OuvrageSpecialisé ouvrage : ouvrages) {
            ActivitySubType2 subType2 = ouvrage.getActivitySubType2();

            if (subType2 != null) {
                ActivitySubType1 subType1 = subType2.getActivitySubType1();

                // Vérifie si subType1 est non null avant d'accéder à son ID et ActivityType
                if (subType1 != null) {
                    ActivityType activityType1 = subType1.getActivityType();

                    // Vérifie si activityType1 est non null avant d'accéder à son ID
                    if (activityType1 != null) {
                        // Vérifie si l'ID de activityType1 correspond à 1
                        if (activityType1.getId_type() == 1) {
                            Integer subType1Id = subType1.getId_subtype1();
                            double points = ouvrage.getPointsAttribués();
                            pointsBySubType1.put(subType1Id, pointsBySubType1.getOrDefault(subType1Id, 0.0) + points);
                        }
                    }
                }

                // Vérifie si subType2 est non null avant d'accéder à son ActivityType
                ActivityType activityType2 = subType2.getActivityType();

                // Vérifie si activityType2 est non null avant d'accéder à son ID
                if (activityType2 != null && activityType2.getId_type() == 2) {
                    Integer subType2Id = subType2.getId_subtype2();
                    double points = ouvrage.getPointsAttribués();
                    pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
                }
            }
        }
    }


    private void addPointsFromParticipationthèseDoctorat(User user, Map<Integer, Double> pointsBySubType1, Map<Integer, Double> pointsBySubType2) {
        List<ParticipationthèseDoctorat> participations = participationthèseDoctoratRepository.findByUser(user);
        for (ParticipationthèseDoctorat participation : participations) {
            ActivitySubType2 subType2 = participation.getActivitySubType2();

            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                double points = participation.getPointsAttribués();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);

                // Accéder à subType1 à partir de subType2
                ActivitySubType1 subType1 = subType2.getActivitySubType1();

                if (subType1 != null) {
                    Integer subType1Id = subType1.getId_subtype1();
                    pointsBySubType1.put(subType1Id, pointsBySubType1.getOrDefault(subType1Id, 0.0) + points);
                }
            }
        }
    }



    private void addPointsFromProjetsContratsRecherche(User user, Map<Integer, Double> pointsBySubType1, Map<Integer, Double> pointsBySubType2) {
        List<ProjetsContratsRecherche> projets = projetsContratsRechercheRepository.findByUser(user);
        for (ProjetsContratsRecherche projet : projets) {
            ActivitySubType2 subType2 = projet.getActivitySubType2();

            if (subType2 != null) {
                ActivitySubType1 subType1 = subType2.getActivitySubType1();

                // Vérifie si subType1 est non null avant d'accéder à son ID et ActivityType
                if (subType1 != null) {
                    ActivityType activityType1 = subType1.getActivityType();

                    // Vérifie si activityType1 est non null avant d'accéder à son ID
                    if (activityType1 != null) {
                        // Vérifie si l'ID de activityType1 correspond à 1
                        if (activityType1.getId_type() == 1) {
                            Integer subType1Id = subType1.getId_subtype1();
                            double points = projet.getPointsAttribués();
                            pointsBySubType1.put(subType1Id, pointsBySubType1.getOrDefault(subType1Id, 0.0) + points);
                        }
                    }
                }

                // Vérifie si subType2 est non null avant d'accéder à son ActivityType
                ActivityType activityType2 = subType2.getActivityType();

                // Vérifie si activityType2 est non null avant d'accéder à son ID
                if (activityType2 != null && activityType2.getId_type() == 2) {
                    Integer subType2Id = subType2.getId_subtype2();
                    double points = projet.getPointsAttribués();
                    pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
                }
            }
        }
    }


    private void addPointsFromPublicationRevuesScientifiques(User user, Map<Integer, Double> pointsBySubType1, Map<Integer, Double> pointsBySubType2) {
        List<PublicationRevuesScientifiques> publications = publicationRevuesScientifiquesRepository.findByUser(user);
        for (PublicationRevuesScientifiques publication : publications) {
            ActivitySubType2 subType2 = publication.getActivitySubType2();

            if (subType2 != null) {
                ActivitySubType1 subType1 = subType2.getActivitySubType1();

                // Vérifie si subType1 est non null avant d'accéder à son ID et ActivityType
                if (subType1 != null) {
                    ActivityType activityType1 = subType1.getActivityType();

                    // Vérifie si activityType1 est non null avant d'accéder à son ID
                    if (activityType1 != null) {
                        // Vérifie si l'ID de activityType1 correspond à 1
                        if (activityType1.getId_type() == 1) {
                            Integer subType1Id = subType1.getId_subtype1();
                            double points = publication.getPointsAttribués();
                            pointsBySubType1.put(subType1Id, pointsBySubType1.getOrDefault(subType1Id, 0.0) + points);
                        }
                    }
                }

                // Vérifie si subType2 est non null avant d'accéder à son ActivityType
                ActivityType activityType2 = subType2.getActivityType();

                // Vérifie si activityType2 est non null avant d'accéder à son ID
                if (activityType2 != null && activityType2.getId_type() == 2) {
                    Integer subType2Id = subType2.getId_subtype2();
                    double points = publication.getPointsAttribués();
                    pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
                }
            }
        }
    }

    private void addPointsFromPublicationsRevuesIndexées(User user, Map<Integer, Double> pointsBySubType1, Map<Integer, Double> pointsBySubType2) {
        List<PublicationsRevuesIndexées> publications = publicationsRevuesIndexéesRepository.findByUser(user);
        for (PublicationsRevuesIndexées publication : publications) {
            ActivitySubType2 subType2 = publication.getActivitySubType2();

            if (subType2 != null) {
                ActivitySubType1 subType1 = subType2.getActivitySubType1();

                // Vérifie si subType1 est non null avant d'accéder à son ID et ActivityType
                if (subType1 != null) {
                    ActivityType activityType1 = subType1.getActivityType();

                    // Vérifie si activityType1 est non null avant d'accéder à son ID
                    if (activityType1 != null) {
                        // Vérifie si l'ID de activityType1 correspond à 1
                        if (activityType1.getId_type() == 1) {
                            Integer subType1Id = subType1.getId_subtype1();
                            double points = publication.getPointsAttribués();
                            pointsBySubType1.put(subType1Id, pointsBySubType1.getOrDefault(subType1Id, 0.0) + points);
                        }
                    }
                }

                // Vérifie si subType2 est non null avant d'accéder à son ActivityType
                ActivityType activityType2 = subType2.getActivityType();

                // Vérifie si activityType2 est non null avant d'accéder à son ID
                if (activityType2 != null && activityType2.getId_type() == 2) {
                    Integer subType2Id = subType2.getId_subtype2();
                    double points = publication.getPointsAttribués();
                    pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0.0) + points);
                }
            }
        }
    }




    /*private void addPointsFromResponsableMembreStructureRechercheAccréditéePoleCompetence(User user, Map<Integer, Integer> pointsBySubType2) {
        List<ResponsableMembreStructureRechercheAccréditéePoleCompetence> responsables = responsableMembreStructureRechercheAccréditéePoleCompetenceRepository.findByUser(user);
        for (ResponsableMembreStructureRechercheAccréditéePoleCompetence responsable : responsables) {
            ActivitySubType2 subType2 = responsable.getActivitySubType2();
            if (subType2 != null) {
                Integer subType2Id = subType2.getId_subtype2();
                int points = responsable.getActivityPoints();
                pointsBySubType2.put(subType2Id, pointsBySubType2.getOrDefault(subType2Id, 0) + points);
            }
        }
    }*/

}
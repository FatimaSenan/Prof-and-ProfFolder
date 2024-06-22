package com.pfa.PFABackend.Service;

import com.pfa.PFABackend.Model.Activities.Enseignement.*;
import com.pfa.PFABackend.Model.Activities.Recherche.*;
import com.pfa.PFABackend.Model.Activity;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Enseignement.*;
import com.pfa.PFABackend.Repository.Activities.Recherche.*;
import com.pfa.PFABackend.Repository.ActivityRepository;
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

}

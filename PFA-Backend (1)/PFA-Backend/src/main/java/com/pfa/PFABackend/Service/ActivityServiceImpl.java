package com.pfa.PFABackend.Service;

import com.pfa.PFABackend.Model.Activities.Enseignement.ChefDépartement;
import com.pfa.PFABackend.Model.Activities.Enseignement.EncadrementPFE;
import com.pfa.PFABackend.Model.Activity;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Enseignement.*;
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
       /* Map<String, List<?>> filteredActivities = activities.entrySet().stream()
                .filter(entry -> entry.getValue() != null && !entry.getValue().isEmpty())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));*/
        //  System.out.println("Fetched activities: ");
       // filteredActivities.forEach(a -> System.out.println(a));
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

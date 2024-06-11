package com.pfa.PFABackend.Service;

import com.pfa.PFABackend.Model.Activities.Enseignement.ChefDépartement;
import com.pfa.PFABackend.Model.Activity;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Enseignement.ChefDépartementRepository;
import com.pfa.PFABackend.Repository.Activities.Enseignement.CoordonateurFilièreRepository;
import com.pfa.PFABackend.Repository.Activities.Enseignement.CoordonateurModuleRepository;
import com.pfa.PFABackend.Repository.Activities.Enseignement.DidacticielsRepository;
import com.pfa.PFABackend.Repository.ActivityRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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



    @Override
    public Map<String, List<?>> getAllActivitiesForCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));

        Map<String, List<?>> activities = new HashMap<>();
        activities.put("ChefDepartement", chefDépartementRepository.findByUser(user));
        activities.put("CoordonateurFiliere", coordonateurFilièreRepository.findByUser(user));
        activities.put("CoordonateurModule", coordonateurModuleRepository.findByUser(user));
        return activities;
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

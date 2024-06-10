package com.pfa.PFABackend.Service.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.CréationStartUp;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Recherche.CréationStartUpRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Service
public class CréationStartUpServiceImpl implements CréationStartUpService{
    @Autowired
    private CréationStartUpRepository créationStartUpRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public void saveCréationStartUp(ActivitySubType2 activitySubType2, String activityName, String projet, String cadre, String role, String années, MultipartFile file) throws IOException {
        CréationStartUp créationStartUp = new CréationStartUp();
        créationStartUp.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        créationStartUp.setActivityName(activityName);
        créationStartUp.setProjet(projet);
        créationStartUp.setCadre(cadre);
        créationStartUp.setRole(role);
        créationStartUp.setAnnées(années);
        créationStartUp.setJustification(file.getBytes());
        créationStartUp.setUser(user);
        créationStartUpRepository.save(créationStartUp);
    }

    @Override
    public Iterable<CréationStartUp> getCréationStartUps() {
        return créationStartUpRepository.findAll();
    }
}

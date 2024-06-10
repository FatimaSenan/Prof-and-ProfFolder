package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.Manuel;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Enseignement.ManuelRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ManuelServiceImpl implements  ManuelService{
    @Autowired
    private ManuelRepository manuelRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveManuel(ActivitySubType2 activitySubType2, String activityName, String module, String filièreNiveau, String annéesUniversitaires, MultipartFile file) throws IOException {
        Manuel manuel = new Manuel();
        manuel.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        manuel.setActivityName(activityName);
        manuel.setModule(module);
        manuel.setFilièreNiveau(filièreNiveau);
        manuel.setAnnéesUniversitaires(annéesUniversitaires);
        manuel.setJustification(file.getBytes());
        manuel.setUser(user);
        manuelRepository.save(manuel);
    }

    @Override
    public Iterable<Manuel> getManuels() {
        return manuelRepository.findAll();
    }
}

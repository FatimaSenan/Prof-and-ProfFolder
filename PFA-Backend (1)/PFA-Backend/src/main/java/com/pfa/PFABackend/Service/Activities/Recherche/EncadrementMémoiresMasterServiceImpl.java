package com.pfa.PFABackend.Service.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.EncadrementMémoiresMaster;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Recherche.EncadrementMémoiresMasterRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Service
public class EncadrementMémoiresMasterServiceImpl implements EncadrementMémoiresMasterService{
    @Autowired
    private EncadrementMémoiresMasterRepository encadrementMémoiresMasterRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public void saveEncadrementMémoiresMaster(ActivitySubType2 activitySubType2, String activityName, String sujetMaster, String étudiants, int année, String encadrant, MultipartFile file) throws IOException {
        EncadrementMémoiresMaster encadrementMémoiresMaster= new EncadrementMémoiresMaster();
        encadrementMémoiresMaster.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        encadrementMémoiresMaster.setActivityName(activityName);
        encadrementMémoiresMaster.setSujet(sujetMaster);
        encadrementMémoiresMaster.setÉtudiants(étudiants);
        encadrementMémoiresMaster.setAnnée(année);
        encadrementMémoiresMaster.setEncadrant(encadrant);
        encadrementMémoiresMaster.setJustification(file.getBytes());
        encadrementMémoiresMaster.setUser(user);
        encadrementMémoiresMasterRepository.save(encadrementMémoiresMaster);
    }

    @Override
    public Iterable<EncadrementMémoiresMaster> getEncadrementMémoiresMaster() {
        return encadrementMémoiresMasterRepository.findAll();
    }
}

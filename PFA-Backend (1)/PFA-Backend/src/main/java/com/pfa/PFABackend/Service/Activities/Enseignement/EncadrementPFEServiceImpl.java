package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.EncadrementPFE;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Enseignement.EncadrementPFERepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class EncadrementPFEServiceImpl implements EncadrementPFEService{
    @Autowired
    private EncadrementPFERepository encadrementPFERepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveEncadrementPFE(ActivitySubType2 activitySubType2, String activityName, String typeEncadrement, String titrePfe, String étudiants, int année, String filière, MultipartFile file) throws IOException {
        EncadrementPFE encadrementPFE = new EncadrementPFE();
        encadrementPFE.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();


        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        encadrementPFE.setActivityName(activityName);
        encadrementPFE.setTypeEncadrement(typeEncadrement);
        encadrementPFE.setTitrePFE(titrePfe);
        encadrementPFE.setÉtudiants(étudiants);
        encadrementPFE.setAnnée(année);
        encadrementPFE.setUser(user);
        encadrementPFE.setJustification(file.getBytes());
        encadrementPFERepository.save(encadrementPFE);
    }

    @Override
    public Iterable<EncadrementPFE> getEncadrementPFEs() {
        return encadrementPFERepository.findAll();
    }
}

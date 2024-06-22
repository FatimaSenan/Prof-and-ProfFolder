package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.ChefDépartement;
import com.pfa.PFABackend.Model.Activities.Enseignement.EncadrementRH;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Enseignement.EncadrementRHRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class EncadrementRHServiceImpl implements  EncadrementRHService{
    @Autowired
    private EncadrementRHRepository encadrementRHRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public void saveEncadrementRH(ActivitySubType2 activitySubType2, String activityName, String typeEncadrement, String titre, String membres, String dateDébut, String dateFin, MultipartFile file) throws IOException {
       EncadrementRH encadrementRH  = new EncadrementRH();
       encadrementRH.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        encadrementRH.setActivityName(activityName);
        encadrementRH.setTypeEncadrement(typeEncadrement);
        encadrementRH.setTitre(titre);
        encadrementRH.setMembres(membres);
        encadrementRH.setDateDébut(dateDébut);
        encadrementRH.setDateFin(dateFin);
        encadrementRH.setJustification(file.getBytes());
        encadrementRH.setUser(user);
        encadrementRHRepository.save(encadrementRH);
    }

    @Override
    public Iterable<EncadrementRH> getEncadrementRHs() {
        return encadrementRHRepository.findAll();
    }
}

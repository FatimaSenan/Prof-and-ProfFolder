package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.ViceDoyen;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Enseignement.ViceDoyenRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ViceDoyenServiceImpl implements ViceDoyenService{
    @Autowired
    private ViceDoyenRepository viceDoyenRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public void saveViceDoyen(ActivitySubType2 activitySubType2, String activityName, String nomFonction,String établissement, String annéesResponsabilités, MultipartFile file) throws IOException {
        ViceDoyen viceDoyen = new ViceDoyen();
        viceDoyen.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        viceDoyen.setActivityName(activityName);
        viceDoyen.setNomFonction(nomFonction);
        viceDoyen.setÉtablissement(établissement);
        viceDoyen.setAnnéesResposabilité(annéesResponsabilités);
        viceDoyen.setJustification(file.getBytes());
        viceDoyen.setUser(user);
        viceDoyenRepository.save(viceDoyen);
    }

    @Override
    public Iterable<ViceDoyen> getVicesDoyens() {
        return viceDoyenRepository.findAll();
    }
}

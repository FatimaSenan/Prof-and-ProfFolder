package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.CoordonateurFilière;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Enseignement.CoordonateurFilièreRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class CoordonateurFilièreServiceImpl implements CoordonateurFilièreService{

    @Autowired
    private CoordonateurFilièreRepository coordonateurFilièreRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public void saveCoordonateurFilière(ActivitySubType2 activitySubType2, String activityName, String typeFilière,String nomFilière, String établissement, String annéesResponsabilité, MultipartFile file) throws IOException {
        CoordonateurFilière coordonateurFilière = new CoordonateurFilière();
        coordonateurFilière.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();


        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        coordonateurFilière.setActivityName(activityName);
        coordonateurFilière.setTypeFilière(typeFilière);
        coordonateurFilière.setEtablissement(établissement);
        coordonateurFilière.setAnnéesResposabilités(annéesResponsabilité);
        coordonateurFilière.setJustification(file.getBytes());
        coordonateurFilière.setUser(user);
        coordonateurFilièreRepository.save(coordonateurFilière);
    }

    @Override
    public Iterable<CoordonateurFilière> getCoordonateurFilières() {
        return coordonateurFilièreRepository.findAll();
    }
}

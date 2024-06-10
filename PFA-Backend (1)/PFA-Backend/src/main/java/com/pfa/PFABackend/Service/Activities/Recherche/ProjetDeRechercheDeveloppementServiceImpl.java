package com.pfa.PFABackend.Service.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.ProjetDeRechercheDeveloppement;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Recherche.ProjetDeRechercheDeveloppementRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Service
public class ProjetDeRechercheDeveloppementServiceImpl implements ProjetDeRechercheDeveloppementService{
    @Autowired
    private ProjetDeRechercheDeveloppementRepository projetDeRechercheDeveloppementRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public void saveProjetDeRechercheDeveloppement(ActivitySubType2 activitySubType2, String activityName, String titreProjet, String cadre, String role, int année, MultipartFile file) throws IOException {
    ProjetDeRechercheDeveloppement projetDeRechercheDeveloppement = new ProjetDeRechercheDeveloppement();
    projetDeRechercheDeveloppement.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        projetDeRechercheDeveloppement.setActivityName(activityName);
        projetDeRechercheDeveloppement.setTitreProjet(titreProjet);
        projetDeRechercheDeveloppement.setCadre(cadre);
        projetDeRechercheDeveloppement.setRole(role);
        projetDeRechercheDeveloppement.setAnnée(année);
        projetDeRechercheDeveloppement.setJustification(file.getBytes());
        projetDeRechercheDeveloppement.setUser(user);
        projetDeRechercheDeveloppementRepository.save(projetDeRechercheDeveloppement);
    }

    @Override
    public Iterable<ProjetDeRechercheDeveloppement> getProjetDeRechercheDeveloppement() {
        return projetDeRechercheDeveloppementRepository.findAll();
    }
}

package com.pfa.PFABackend.Service.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.ProjetsContratsRecherche;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Recherche.ProjetsContratsRechercheRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Service
public class ProjetsContratsRechercheServiceImpl implements ProjetsContratsRechercheService{

    @Autowired
    private ProjetsContratsRechercheRepository projetsContratsRechercheRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveProjetsContratsRecherche(ActivitySubType2 activitySubType2, String activityName, String titreProjet, String responsabilité, String cadre, String type, String période, MultipartFile file) throws IOException {
        ProjetsContratsRecherche projetsContratsRecherche = new ProjetsContratsRecherche();
        projetsContratsRecherche.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        projetsContratsRecherche.setActivityName(activityName);
        projetsContratsRecherche.setTitreProjet(titreProjet);
        projetsContratsRecherche.setResponsabilite(responsabilité);
        projetsContratsRecherche.setCadreProjet(cadre);
        projetsContratsRecherche.setType(type);
        projetsContratsRecherche.setPériode(période);
        projetsContratsRecherche.setJustification(file.getBytes());
        projetsContratsRecherche.setUser(user);
        projetsContratsRechercheRepository.save(projetsContratsRecherche);
    }

    @Override
    public Iterable<ProjetsContratsRecherche> getProjetsContratsRecherche() {
        return projetsContratsRechercheRepository.findAll();
    }
}

package com.pfa.PFABackend.Service.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.IncubationProjetRecherche;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Recherche.IncubationProjetRechercheRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Service
public class IncubationProjetRechercheServiceImpl implements IncubationProjetRechercheService{

    @Autowired
    private IncubationProjetRechercheRepository incubationProjetRechercheRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public void saveIncubationProjetRecherche(ActivitySubType2 activitySubType2, String activityName, String projet, String cadre, String role, String années, MultipartFile file) throws IOException {
    IncubationProjetRecherche incubationProjetRecherche = new IncubationProjetRecherche();
    incubationProjetRecherche.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        incubationProjetRecherche.setActivityName(activityName);
        incubationProjetRecherche.setProjet(projet);
        incubationProjetRecherche.setCadre(cadre);
        incubationProjetRecherche.setRole(role);
        incubationProjetRecherche.setAnnées(années);
        incubationProjetRecherche.setJustification(file.getBytes());
        incubationProjetRecherche.setUser(user);
        incubationProjetRechercheRepository.save(incubationProjetRecherche);
    }

    @Override
    public Iterable<IncubationProjetRecherche> getIncubationProjetRecherche() {
        return incubationProjetRechercheRepository.findAll();
    }
}

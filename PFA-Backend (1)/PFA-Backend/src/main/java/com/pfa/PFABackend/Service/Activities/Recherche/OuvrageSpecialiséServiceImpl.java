package com.pfa.PFABackend.Service.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.OuvrageSpecialisé;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Recherche.OuvrageSpecialiséRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Service
public class OuvrageSpecialiséServiceImpl implements OuvrageSpecialiséService{

    @Autowired
    private OuvrageSpecialiséRepository ouvrageSpecialiséRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public void saveOuvrageSpecialisé(ActivitySubType2 activitySubType2, String activityName, String publicateur, String titre, String isbnIssn, String auteurs, String depotLegal, String date, MultipartFile file) throws IOException {
        OuvrageSpecialisé ouvrageSpecialisé = new OuvrageSpecialisé();
        ouvrageSpecialisé.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        ouvrageSpecialisé.setActivityName(activityName);
        ouvrageSpecialisé.setPublicateur(publicateur);
        ouvrageSpecialisé.setTitre(titre);
        ouvrageSpecialisé.setIsbn(isbnIssn);
        ouvrageSpecialisé.setAuteurs(auteurs);
        ouvrageSpecialisé.setDepotLegal(depotLegal);
        ouvrageSpecialisé.setDate(date);
        ouvrageSpecialisé.setJustification(file.getBytes());
        ouvrageSpecialisé.setUser(user);
        ouvrageSpecialiséRepository.save(ouvrageSpecialisé);

    }

    @Override
    public Iterable<OuvrageSpecialisé> getOuvrageSpecialisé() {
        return ouvrageSpecialiséRepository.findAll();
    }
}

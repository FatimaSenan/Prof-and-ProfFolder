package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.Ouvrage;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Enseignement.OuvrageRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class OuvrageServiceImpl implements OuvrageService{
    @Autowired
    private OuvrageRepository ouvrageRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public void saveOuvrage(ActivitySubType2 activitySubType2, String activityName, String titreOuvrage, String auteurs, String isbn, String depotLegal, String maisonEdition, int annéePublication, MultipartFile file) throws IOException {
        Ouvrage ouvrage = new Ouvrage();
        ouvrage.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        ouvrage.setActivityName(activityName);
        ouvrage.setTitreOuvrage(titreOuvrage);
        ouvrage.setAuteurs(auteurs);
        ouvrage.setIsbn(isbn);
        ouvrage.setDepotLegal(depotLegal);
        ouvrage.setMaisonEdition(maisonEdition);
        ouvrage.setAnnéePublication(annéePublication);
        ouvrage.setJustification(file.getBytes());
        ouvrage.setUser(user);
        ouvrageRepository.save(ouvrage);
    }

    @Override
    public Iterable<Ouvrage> getOuvrages() {
        return ouvrageRepository.findAll();
    }
}

package com.pfa.PFABackend.Service.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.ChapitreOuvrage;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Recherche.ChapitreOuvrageRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Service
public class ChapitreOuvrageServiceImpl implements ChapitreOuvrageService{

    @Autowired
    private ChapitreOuvrageRepository chapitreOuvrageRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public void saveChapitreOuvrage(ActivitySubType2 activitySubType2, String activityName, String titre, String isbn, String auteurs, String depotLegal, String date, MultipartFile file) throws IOException {
        ChapitreOuvrage chapitreOuvrage = new ChapitreOuvrage();
        chapitreOuvrage.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        chapitreOuvrage.setActivityName(activityName);
        chapitreOuvrage.setTitre(titre);
        chapitreOuvrage.setIsbn(isbn);
        chapitreOuvrage.setAuteurs(auteurs);
        chapitreOuvrage.setDepotLegal(depotLegal);
        chapitreOuvrage.setDate(date);
        chapitreOuvrage.setJustification(file.getBytes());
        chapitreOuvrage.setUser(user);
        chapitreOuvrageRepository.save(chapitreOuvrage);

    }

    @Override
    public Iterable<ChapitreOuvrage> getChapitreOuvrages() {
        return chapitreOuvrageRepository.findAll();
    }
}

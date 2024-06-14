package com.pfa.PFABackend.Service.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.PublicationRevuesScientifiques;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Recherche.PublicationRevuesScientifiquesRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Service
public class PublicationRevuesScientifiquesServiceImpl implements  PublicationRevuesScientifiquesService{

    @Autowired
    private PublicationRevuesScientifiquesRepository publicationRevuesScientifiquesRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void savePublicationRevuesScientifiques(ActivitySubType2 activitySubType2, String activityName, String type, String titre, String auteurs, String lien, String journal, String issn, int annéePublication, MultipartFile file) throws IOException {
    PublicationRevuesScientifiques publicationRevuesScientifiques = new PublicationRevuesScientifiques();
    publicationRevuesScientifiques.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        publicationRevuesScientifiques.setType(type);
        publicationRevuesScientifiques.setTitre(titre);
        publicationRevuesScientifiques.setAuteurs(auteurs);
        publicationRevuesScientifiques.setLien(lien);
        publicationRevuesScientifiques.setJournal(journal);
        publicationRevuesScientifiques.setIssn(issn);
        publicationRevuesScientifiques.setAnnéePublication(annéePublication);
        publicationRevuesScientifiques.setJustification(file.getBytes());
        publicationRevuesScientifiques.setUser(user);
        publicationRevuesScientifiquesRepository.save(publicationRevuesScientifiques);
    }

    @Override
    public Iterable<PublicationRevuesScientifiques> getPublicationRevuesScientifiques() {
        return publicationRevuesScientifiquesRepository.findAll();
    }
}

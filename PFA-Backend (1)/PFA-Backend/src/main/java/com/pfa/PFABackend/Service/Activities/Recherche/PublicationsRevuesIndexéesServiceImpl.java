package com.pfa.PFABackend.Service.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.PublicationsRevuesIndexées;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Recherche.PublicationsRevuesIndexéesRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Service
public class PublicationsRevuesIndexéesServiceImpl implements PublicationsRevuesIndexéesService{

    @Autowired
    private PublicationsRevuesIndexéesRepository publicationsRevuesIndexéesRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public void savePublicationRevuesIndexées(ActivitySubType2 activitySubType2, String activityName, String niveau, String titre, String auteurs, String doi, String lien, String journal, String isbn, int annéePublication, MultipartFile file) throws IOException {
        PublicationsRevuesIndexées publicationsRevuesIndexées = new PublicationsRevuesIndexées();
        publicationsRevuesIndexées.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        publicationsRevuesIndexées.setActivityName(activityName);
        publicationsRevuesIndexées.setNiveau(niveau);
        publicationsRevuesIndexées.setTitre(titre);
        publicationsRevuesIndexées.setAuteurs(auteurs);
        publicationsRevuesIndexées.setDoi(doi);
        publicationsRevuesIndexées.setLien(lien);
        publicationsRevuesIndexées.setJournal(journal);
        publicationsRevuesIndexées.setIsbn(isbn);
        publicationsRevuesIndexées.setAnnéePublication(annéePublication);
        publicationsRevuesIndexées.setJustification(file.getBytes());
        publicationsRevuesIndexées.setUser(user);
        publicationsRevuesIndexéesRepository.save(publicationsRevuesIndexées);
    }

    @Override
    public Iterable<PublicationsRevuesIndexées> getPublicationRevuesIndexées() {
        return publicationsRevuesIndexéesRepository.findAll();
    }
}

package com.pfa.PFABackend.Service.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.CongrèsConférencesNonPubliées;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Recherche.CongrèsConférencesNonPubliéesRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Service
public class CongrèsConférencesNonPubliéesServiceImpl implements CongrèsConférencesNonPubliéesService{

    @Autowired
    private CongrèsConférencesNonPubliéesRepository congrèsConférencesNonPubliéesRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public void saveCongrèsConférencesNonPubliées(ActivitySubType2 activitySubType2, String activityName, String nomConférence, int année, String lien, String titreCommunication, String auteurs, MultipartFile file) throws IOException {
        CongrèsConférencesNonPubliées congrèsConférencesNonPubliées = new CongrèsConférencesNonPubliées();
        congrèsConférencesNonPubliées.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        congrèsConférencesNonPubliées.setActivityName(activityName);
        congrèsConférencesNonPubliées.setNomConference(nomConférence);
        congrèsConférencesNonPubliées.setAnnéeConference(année);
        congrèsConférencesNonPubliées.setLien(lien);
        congrèsConférencesNonPubliées.setTitreCommunication(titreCommunication);
        congrèsConférencesNonPubliées.setAuteurs(auteurs);
        congrèsConférencesNonPubliées.setJustification(file.getBytes());
        congrèsConférencesNonPubliées.setUser(user);
        congrèsConférencesNonPubliéesRepository.save(congrèsConférencesNonPubliées);
    }

    @Override
    public Iterable<CongrèsConférencesNonPubliées> getCongrèsConférencesNonPubliées() {
        return congrèsConférencesNonPubliéesRepository.findAll();
    }
}

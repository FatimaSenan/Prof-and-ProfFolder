package com.pfa.PFABackend.Service.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.CongrèsConférencesPubliées;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Recherche.CongrèsConférencesPubliéesRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Service
public class CongrèsConférencesPubliéesServiceImpl implements CongrèsConférencesPubliéesService{

    @Autowired
    private CongrèsConférencesPubliéesRepository congrèsConférencesPubliéesRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public void saveCongrèsConférencesPubliées(ActivitySubType2 activitySubType2, String activityName, String nomConférence,String type,  int année, String lien, String titreCommunication, String auteurs, MultipartFile file) throws IOException {
        CongrèsConférencesPubliées congrèsConférencesPubliées = new CongrèsConférencesPubliées();
        congrèsConférencesPubliées.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        congrèsConférencesPubliées.setActivityName(activityName);
        congrèsConférencesPubliées.setType(type);
        congrèsConférencesPubliées.setNomConference(nomConférence);
        congrèsConférencesPubliées.setAnnéeConference(année);
        congrèsConférencesPubliées.setLien(lien);
        congrèsConférencesPubliées.setTitreCommunication(titreCommunication);
        congrèsConférencesPubliées.setAuteurs(auteurs);
        congrèsConférencesPubliées.setJustification(file.getBytes());
        congrèsConférencesPubliées.setUser(user);
        congrèsConférencesPubliéesRepository.save(congrèsConférencesPubliées);
    }

    @Override
    public Iterable<CongrèsConférencesPubliées> getCongrèsConférencesPubliées() {
        return congrèsConférencesPubliéesRepository.findAll();
    }
}

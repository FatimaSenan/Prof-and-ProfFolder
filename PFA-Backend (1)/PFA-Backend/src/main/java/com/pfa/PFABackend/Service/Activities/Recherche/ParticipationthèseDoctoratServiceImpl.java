package com.pfa.PFABackend.Service.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.ParticipationthèseDoctorat;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Recherche.ParticipationthèseDoctoratRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Service
public class ParticipationthèseDoctoratServiceImpl implements ParticipationthèseDoctoratService{
    @Autowired
    private ParticipationthèseDoctoratRepository participationthèseDoctoratRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public void saveParticipationthèseDoctorat(ActivitySubType2 activitySubType2, String activityName, String sujetThèse, String doctorant, String date, String université, MultipartFile file) throws IOException {
        ParticipationthèseDoctorat participationthèseDoctorat = new ParticipationthèseDoctorat();
        participationthèseDoctorat.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        participationthèseDoctorat.setActivityName(activityName);
        participationthèseDoctorat.setSujet(sujetThèse);
        //participationthèseDoctorat.setRole(role);
        participationthèseDoctorat.setDoctorant(doctorant);
        participationthèseDoctorat.setDate(date);
        participationthèseDoctorat.setUniversité(université);
        participationthèseDoctorat.setJustification(file.getBytes());
        participationthèseDoctorat.setUser(user);
        participationthèseDoctoratRepository.save(participationthèseDoctorat);
    }

    @Override
    public Iterable<ParticipationthèseDoctorat> getParticipationthèseDoctorat() {
        return participationthèseDoctoratRepository.findAll();
    }
}

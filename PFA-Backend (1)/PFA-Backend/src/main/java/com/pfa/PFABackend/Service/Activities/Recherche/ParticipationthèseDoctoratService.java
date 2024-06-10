package com.pfa.PFABackend.Service.Activities.Recherche;


import com.pfa.PFABackend.Model.Activities.Recherche.ParticipationthèseDoctorat;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ParticipationthèseDoctoratService {
    public void saveParticipationthèseDoctorat(ActivitySubType2 activitySubType2, String activityName, String sujetThèse, String doctorant, String date, String université, MultipartFile file) throws IOException;

    public Iterable<ParticipationthèseDoctorat> getParticipationthèseDoctorat();
}

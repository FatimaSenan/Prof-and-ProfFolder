package com.pfa.PFABackend.Service.Activities.Recherche;


import com.pfa.PFABackend.Model.Activities.Recherche.CongrèsConférencesNonPubliées;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CongrèsConférencesNonPubliéesService {
    public void saveCongrèsConférencesNonPubliées(ActivitySubType2 activitySubType2, String activityName, String nomConférence, int année, String lien, String titreCommunication, String auteurs, MultipartFile file) throws IOException;

    public Iterable<CongrèsConférencesNonPubliées> getCongrèsConférencesNonPubliées();
}

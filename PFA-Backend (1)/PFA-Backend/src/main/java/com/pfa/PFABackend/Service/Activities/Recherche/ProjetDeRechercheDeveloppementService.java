package com.pfa.PFABackend.Service.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.ParticipationthèseDoctorat;
import com.pfa.PFABackend.Model.Activities.Recherche.ProjetDeRechercheDeveloppement;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProjetDeRechercheDeveloppementService {
    public void saveProjetDeRechercheDeveloppement(ActivitySubType2 activitySubType2, String activityName, String titreProjet, String cadre, String role, int année, MultipartFile file) throws IOException;

    public Iterable<ProjetDeRechercheDeveloppement> getProjetDeRechercheDeveloppement();
}

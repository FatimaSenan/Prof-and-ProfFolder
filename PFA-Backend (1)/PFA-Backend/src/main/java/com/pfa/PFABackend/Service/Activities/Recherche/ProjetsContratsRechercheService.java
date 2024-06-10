package com.pfa.PFABackend.Service.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.ProjetDeRechercheDeveloppement;
import com.pfa.PFABackend.Model.Activities.Recherche.ProjetsContratsRecherche;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProjetsContratsRechercheService {
    public void saveProjetsContratsRecherche(ActivitySubType2 activitySubType2, String activityName, String titreProjet, String responsabilité, String cadre, String type, String période, MultipartFile file) throws IOException;

    public Iterable<ProjetsContratsRecherche> getProjetsContratsRecherche();
}

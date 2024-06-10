package com.pfa.PFABackend.Service.Activities.Recherche;


import com.pfa.PFABackend.Model.Activities.Recherche.IncubationProjetRecherche;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IncubationProjetRechercheService {
    public void saveIncubationProjetRecherche(ActivitySubType2 activitySubType2, String activityName, String projet, String cadre, String role,String années, MultipartFile file) throws IOException;

    public Iterable<IncubationProjetRecherche> getIncubationProjetRecherche();
}

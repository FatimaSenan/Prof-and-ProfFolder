package com.pfa.PFABackend.Service.Activities.Recherche;


import com.pfa.PFABackend.Model.Activities.Recherche.ChapitreOuvrage;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ChapitreOuvrageService {
    public void saveChapitreOuvrage(ActivitySubType2 activitySubType2, String activityName, String titre, String isbn, String auteurs, String depotLegal, String date, MultipartFile file) throws IOException;

    public Iterable<ChapitreOuvrage> getChapitreOuvrages();
}

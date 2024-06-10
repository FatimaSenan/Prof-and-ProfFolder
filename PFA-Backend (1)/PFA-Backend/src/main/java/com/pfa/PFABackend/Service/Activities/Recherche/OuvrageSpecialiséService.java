package com.pfa.PFABackend.Service.Activities.Recherche;


import com.pfa.PFABackend.Model.Activities.Recherche.OuvrageSpecialisé;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface OuvrageSpecialiséService {
    public void saveOuvrageSpecialisé(ActivitySubType2 activitySubType2, String activityName, String publicateur, String titre, String isbnIssn, String auteurs,String depotLegal, String date, MultipartFile file) throws IOException;

    public Iterable<OuvrageSpecialisé> getOuvrageSpecialisé();
}

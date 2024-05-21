package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MOOC;
import com.pfa.PFABackend.Model.Activities.Enseignement.Ouvrage;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface OuvrageService {
    public void saveOuvrage(ActivitySubType2 activitySubType2, String activityName, String titreOuvrage, String auteurs, String isbn, String depotLegal, String maisonEdition, int annéePublication, MultipartFile file) throws IOException;

    public Iterable<Ouvrage> getOuvrages();
}

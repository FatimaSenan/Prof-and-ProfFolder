package com.pfa.PFABackend.Service.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Enseignement.ChefDépartement;
import com.pfa.PFABackend.Model.Activities.Recherche.Brevet;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface BrevetService {
    public void saveBrevet(ActivitySubType2 activitySubType2, String activityName, String auteur, String titre, String doi,String journalRevue, String isbn, int année, int pages, String indexation, MultipartFile file) throws IOException;

    public Iterable<Brevet> getBrevets();
}

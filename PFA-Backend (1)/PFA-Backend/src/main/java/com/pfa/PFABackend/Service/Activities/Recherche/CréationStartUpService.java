package com.pfa.PFABackend.Service.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.CréationStartUp;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CréationStartUpService {
    public void saveCréationStartUp(ActivitySubType2 activitySubType2, String activityName, String projet, String cadre, String role, String années , MultipartFile file) throws IOException;

    public Iterable<CréationStartUp> getCréationStartUps();
}

package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MOOC;
import com.pfa.PFABackend.Model.Activities.Enseignement.PréparationSortiesTerrain;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PréparationSortiesTerrainService {
    public void savePréparationSortiesTerrains(ActivitySubType2 activitySubType2, String activityName, String cadre, String date, String nomSociété, MultipartFile file) throws IOException;

    public Iterable<PréparationSortiesTerrain> getPréparationsSortiesTerrain();
}

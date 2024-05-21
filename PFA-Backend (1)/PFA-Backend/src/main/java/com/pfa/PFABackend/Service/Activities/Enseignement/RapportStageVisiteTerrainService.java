package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MOOC;
import com.pfa.PFABackend.Model.Activities.Enseignement.RapportStageVisiteTerrain;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface RapportStageVisiteTerrainService {

    public void saveRapportStageVisiteTerrain(ActivitySubType2 activitySubType2, String activityName, String titreStage, String cadre, int année, String société, MultipartFile file) throws IOException;

    public Iterable<RapportStageVisiteTerrain> getRapportsStagesVisitesTerrains();
}

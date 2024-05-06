package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MOOC;
import com.pfa.PFABackend.Model.Activities.Enseignement.RapportStageVisiteTerrain;

public interface RapportStageVisiteTerrainService {

    public void saveRapportStageVisiteTerrain(RapportStageVisiteTerrain rapportStageVisiteTerrain);

    public Iterable<RapportStageVisiteTerrain> getRapportsStagesVisitesTerrains();
}

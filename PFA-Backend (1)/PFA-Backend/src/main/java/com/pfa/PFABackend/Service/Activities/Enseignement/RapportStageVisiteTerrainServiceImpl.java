package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.RapportStageVisiteTerrain;
import com.pfa.PFABackend.Repository.Activities.Enseignement.RapportStageVisiteTerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RapportStageVisiteTerrainServiceImpl implements RapportStageVisiteTerrainService{
    @Autowired
    private RapportStageVisiteTerrainRepository rapportStageVisiteTerrainRepository;
    @Override
    public void saveRapportStageVisiteTerrain(RapportStageVisiteTerrain rapportStageVisiteTerrain) {
        rapportStageVisiteTerrainRepository.save(rapportStageVisiteTerrain);
    }

    @Override
    public Iterable<RapportStageVisiteTerrain> getRapportsStagesVisitesTerrains() {
        return rapportStageVisiteTerrainRepository.findAll();
    }
}

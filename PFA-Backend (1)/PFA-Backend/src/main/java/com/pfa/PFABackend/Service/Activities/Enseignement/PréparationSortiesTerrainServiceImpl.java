package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.PréparationSortiesTerrain;
import com.pfa.PFABackend.Repository.Activities.Enseignement.PréparationSortiesTerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PréparationSortiesTerrainServiceImpl implements PréparationSortiesTerrainService{
    @Autowired
    private PréparationSortiesTerrainRepository préparationSortiesTerrainRepository;
    @Override
    public void savePréparationSortiesTerrains(PréparationSortiesTerrain préparationSortiesTerrain) {
        préparationSortiesTerrainRepository.save(préparationSortiesTerrain);
    }

    @Override
    public Iterable<PréparationSortiesTerrain> getPréparationsSortiesTerrain() {
        return préparationSortiesTerrainRepository.findAll();
    }
}

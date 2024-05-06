package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MOOC;
import com.pfa.PFABackend.Model.Activities.Enseignement.PréparationSortiesTerrain;

public interface PréparationSortiesTerrainService {
    public void savePréparationSortiesTerrains(PréparationSortiesTerrain préparationSortiesTerrain);

    public Iterable<PréparationSortiesTerrain> getPréparationsSortiesTerrain();
}

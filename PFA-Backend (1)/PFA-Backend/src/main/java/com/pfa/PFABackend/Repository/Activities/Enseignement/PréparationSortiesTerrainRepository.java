package com.pfa.PFABackend.Repository.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.PréparationSortiesTerrain;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PréparationSortiesTerrainRepository extends JpaRepository<PréparationSortiesTerrain, Integer> {
    public List<PréparationSortiesTerrain> findByUser(User user);
}

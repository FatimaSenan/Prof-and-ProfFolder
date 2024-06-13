package com.pfa.PFABackend.Repository.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.RapportStageVisiteTerrain;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RapportStageVisiteTerrainRepository extends JpaRepository<RapportStageVisiteTerrain, Integer> {
    public List<RapportStageVisiteTerrain> findByUser(User user);
}

package com.pfa.PFABackend.Repository.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.EncadrementMémoiresMaster;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EncadrementMémoiresMasterRepository extends JpaRepository<EncadrementMémoiresMaster, Integer> {
    public List<EncadrementMémoiresMaster> findByUser(User user);
}

package com.pfa.PFABackend.Repository.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.CoordonateurModule;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoordonateurModuleRepository extends JpaRepository<CoordonateurModule, Integer> {
    public List<CoordonateurModule> findByUser(User user);
}

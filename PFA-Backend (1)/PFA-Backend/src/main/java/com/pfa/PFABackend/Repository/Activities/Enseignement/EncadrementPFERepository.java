package com.pfa.PFABackend.Repository.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.EncadrementPFE;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EncadrementPFERepository extends JpaRepository<EncadrementPFE, Integer> {
    public List<EncadrementPFE> findByUser(User user);
}

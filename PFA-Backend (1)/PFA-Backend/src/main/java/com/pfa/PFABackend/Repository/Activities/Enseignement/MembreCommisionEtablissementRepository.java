package com.pfa.PFABackend.Repository.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionEtablissement;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MembreCommisionEtablissementRepository extends JpaRepository<MembreCommissionEtablissement, Integer> {
    public List<MembreCommissionEtablissement> findByUser(User user);
}

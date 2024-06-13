package com.pfa.PFABackend.Repository.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.EncadrementRH;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EncadrementRHRepository extends JpaRepository<EncadrementRH, Integer> {
    public List<EncadrementRH> findByUser(User user);
}

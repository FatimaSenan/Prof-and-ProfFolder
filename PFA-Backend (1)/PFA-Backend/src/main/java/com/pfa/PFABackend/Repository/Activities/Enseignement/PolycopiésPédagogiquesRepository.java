package com.pfa.PFABackend.Repository.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.PolycopiésPédagogiques;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PolycopiésPédagogiquesRepository extends JpaRepository<PolycopiésPédagogiques, Integer> {
    public List<PolycopiésPédagogiques> findByUser(User user);
}

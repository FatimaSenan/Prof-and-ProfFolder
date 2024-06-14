package com.pfa.PFABackend.Repository.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.DoctoratsEncadrés;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctoratsEncadrésRepository extends JpaRepository<DoctoratsEncadrés, Integer> {
    public List<DoctoratsEncadrés> findByUser(User user);
}

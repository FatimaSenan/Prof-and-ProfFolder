package com.pfa.PFABackend.Repository.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreConseilCoordination;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MembreConseilCoordinationRepository extends JpaRepository<MembreConseilCoordination, Integer> {
    public List<MembreConseilCoordination> findByUser(User user);
}

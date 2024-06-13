package com.pfa.PFABackend.Repository.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MembreCommissionConseilRepository extends JpaRepository<MembreCommissionConseil, Integer> {
    public List<MembreCommissionConseil> findByUser(User user);
}

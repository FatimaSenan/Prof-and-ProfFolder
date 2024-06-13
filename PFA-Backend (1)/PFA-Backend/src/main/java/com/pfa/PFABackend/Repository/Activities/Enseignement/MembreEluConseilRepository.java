package com.pfa.PFABackend.Repository.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreEluConseil;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MembreEluConseilRepository extends JpaRepository<MembreEluConseil, Integer> {
    public List<MembreEluConseil> findByUser(User user);
}

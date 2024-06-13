package com.pfa.PFABackend.Repository.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.Ouvrage;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OuvrageRepository extends JpaRepository<Ouvrage, Integer> {
    public List<Ouvrage> findByUser(User user);
}

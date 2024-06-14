package com.pfa.PFABackend.Repository.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.OuvrageSpecialisé;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OuvrageSpecialiséRepository extends JpaRepository<OuvrageSpecialisé, Integer> {
    public List<OuvrageSpecialisé> findByUser(User user);
}


package com.pfa.PFABackend.Repository.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.ChapitreOuvrage;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChapitreOuvrageRepository extends JpaRepository<ChapitreOuvrage, Integer> {
    public List<ChapitreOuvrage> findByUser(User user);
}

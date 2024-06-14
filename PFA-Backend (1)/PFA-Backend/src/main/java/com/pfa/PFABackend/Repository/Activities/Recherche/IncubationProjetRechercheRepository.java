package com.pfa.PFABackend.Repository.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.IncubationProjetRecherche;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncubationProjetRechercheRepository extends JpaRepository<IncubationProjetRecherche, Integer> {
    public List<IncubationProjetRecherche> findByUser(User user);
}

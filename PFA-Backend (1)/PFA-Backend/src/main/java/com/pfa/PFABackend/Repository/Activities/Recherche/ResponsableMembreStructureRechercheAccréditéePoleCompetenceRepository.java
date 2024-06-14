package com.pfa.PFABackend.Repository.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.ResponsableMembreStructureRecherchePole;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResponsableMembreStructureRechercheAccréditéePoleCompetenceRepository extends JpaRepository<ResponsableMembreStructureRecherchePole, Integer> {
    public List<ResponsableMembreStructureRecherchePole> findByUser(User user);
}

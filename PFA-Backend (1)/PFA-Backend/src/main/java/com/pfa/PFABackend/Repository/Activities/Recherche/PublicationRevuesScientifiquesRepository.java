package com.pfa.PFABackend.Repository.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.PublicationRevuesScientifiques;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicationRevuesScientifiquesRepository extends JpaRepository<PublicationRevuesScientifiques, Integer> {
    public List<PublicationRevuesScientifiques> findByUser(User user);
}

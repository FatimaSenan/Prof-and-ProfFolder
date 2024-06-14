package com.pfa.PFABackend.Repository.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.AssociationConnaissance;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssociationConnaissanceRepository extends JpaRepository<AssociationConnaissance, Integer> {
    public List<AssociationConnaissance> findByUser(User user);
}

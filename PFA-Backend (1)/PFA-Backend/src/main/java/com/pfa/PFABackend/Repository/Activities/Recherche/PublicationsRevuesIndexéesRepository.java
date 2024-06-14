package com.pfa.PFABackend.Repository.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.PublicationsRevuesIndexées;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicationsRevuesIndexéesRepository extends JpaRepository<PublicationsRevuesIndexées, Integer> {
    public List<PublicationsRevuesIndexées> findByUser(User user);
}

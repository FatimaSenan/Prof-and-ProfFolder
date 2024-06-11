package com.pfa.PFABackend.Repository.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.CoordonateurFilière;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoordonateurFilièreRepository extends JpaRepository<CoordonateurFilière, Integer> {
    public List<CoordonateurFilière> findByUser(User user);
}

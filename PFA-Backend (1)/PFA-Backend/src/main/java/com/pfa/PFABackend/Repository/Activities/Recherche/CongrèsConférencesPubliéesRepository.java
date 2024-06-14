package com.pfa.PFABackend.Repository.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.CongrèsConférencesPubliées;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CongrèsConférencesPubliéesRepository extends JpaRepository<CongrèsConférencesPubliées, Integer> {
    public List<CongrèsConférencesPubliées> findByUser(User user);
}

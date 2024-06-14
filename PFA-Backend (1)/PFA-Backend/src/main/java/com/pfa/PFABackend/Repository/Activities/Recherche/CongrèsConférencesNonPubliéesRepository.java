package com.pfa.PFABackend.Repository.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.CongrèsConférencesNonPubliées;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CongrèsConférencesNonPubliéesRepository extends JpaRepository<CongrèsConférencesNonPubliées, Integer> {
    public List<CongrèsConférencesNonPubliées> findByUser(User user);
}

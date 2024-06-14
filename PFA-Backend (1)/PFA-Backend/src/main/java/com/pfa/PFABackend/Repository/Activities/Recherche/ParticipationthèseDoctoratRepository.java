package com.pfa.PFABackend.Repository.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.ParticipationthèseDoctorat;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipationthèseDoctoratRepository extends JpaRepository<ParticipationthèseDoctorat, Integer> {
    public List<ParticipationthèseDoctorat> findByUser(User user);
}

package com.pfa.PFABackend.Repository.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.ExpertiseNonRémunéré;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpertiseNonRémunéréRepository extends JpaRepository<ExpertiseNonRémunéré, Integer> {
    public List<ExpertiseNonRémunéré> findByUser(User user);
}

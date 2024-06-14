package com.pfa.PFABackend.Repository.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.CréationStartUp;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CréationStartUpRepository extends JpaRepository<CréationStartUp, Integer> {
    public List<CréationStartUp> findByUser(User user);
}

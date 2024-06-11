package com.pfa.PFABackend.Repository.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.ChefDépartement;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChefDépartementRepository extends JpaRepository<ChefDépartement, Integer> {
    public List<ChefDépartement> findByUser(User user);
}

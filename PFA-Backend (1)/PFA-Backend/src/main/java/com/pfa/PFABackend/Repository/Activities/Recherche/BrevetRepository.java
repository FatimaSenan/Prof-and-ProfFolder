
package com.pfa.PFABackend.Repository.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.Brevet;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrevetRepository extends JpaRepository<Brevet, Integer> {
    public List<Brevet> findByUser(User user);
}

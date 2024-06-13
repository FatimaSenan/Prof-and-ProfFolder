package com.pfa.PFABackend.Repository.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.Manuel;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManuelRepository extends JpaRepository<Manuel, Integer> {
    public List<Manuel> findByUser(User user);
}

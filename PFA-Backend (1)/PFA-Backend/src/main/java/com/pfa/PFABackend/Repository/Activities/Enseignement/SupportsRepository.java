package com.pfa.PFABackend.Repository.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.Supports;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupportsRepository extends JpaRepository<Supports, Integer> {
    public List<Supports> findByUser(User user);
}

package com.pfa.PFABackend.Repository.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.Didacticiels;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DidacticielsRepository extends JpaRepository<Didacticiels, Integer> {
    public List<Didacticiels> findByUser(User user);
}

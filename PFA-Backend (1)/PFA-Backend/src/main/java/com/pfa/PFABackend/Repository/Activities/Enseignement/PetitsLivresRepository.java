package com.pfa.PFABackend.Repository.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.PetitsLivres;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetitsLivresRepository extends JpaRepository<PetitsLivres, Integer> {
    public List<PetitsLivres> findByUser(User user);
}

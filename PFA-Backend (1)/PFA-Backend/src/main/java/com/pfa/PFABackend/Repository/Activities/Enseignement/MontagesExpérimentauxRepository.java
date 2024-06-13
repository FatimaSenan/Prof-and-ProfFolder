package com.pfa.PFABackend.Repository.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MontagesExpérimentaux;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MontagesExpérimentauxRepository extends JpaRepository<MontagesExpérimentaux, Integer> {
    public List<MontagesExpérimentaux> findByUser(User user);
}

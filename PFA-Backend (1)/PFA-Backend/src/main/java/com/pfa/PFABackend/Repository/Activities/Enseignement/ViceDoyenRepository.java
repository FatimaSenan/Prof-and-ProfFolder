package com.pfa.PFABackend.Repository.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.ViceDoyen;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ViceDoyenRepository extends JpaRepository<ViceDoyen, Integer> {
    public List<ViceDoyen> findByUser(User user);
}

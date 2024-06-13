package com.pfa.PFABackend.Repository.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionAdHoc;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MembreCommissionAdHocRepository extends JpaRepository<MembreCommissionAdHoc, Integer> {
    public List<MembreCommissionAdHoc> findByUser(User user);
}

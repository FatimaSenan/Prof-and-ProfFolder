package com.pfa.PFABackend.Repository;

import com.pfa.PFABackend.Model.Annexe3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Annexe3Repository extends JpaRepository<Annexe3, Long> {

    public Optional<Annexe3> findByUserEmail(String userEmail);
}

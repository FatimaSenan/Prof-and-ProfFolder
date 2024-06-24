package com.pfa.PFABackend.Repository;

import com.pfa.PFABackend.Model.Annexe2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Annexe2Repository extends JpaRepository<Annexe2, Long> {

    Optional<Annexe2> findByUserEmail(String email);
}
package com.pfa.PFABackend.Repository;

import com.pfa.PFABackend.Model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {
}

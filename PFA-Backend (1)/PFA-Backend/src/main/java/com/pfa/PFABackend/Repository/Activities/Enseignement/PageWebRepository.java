package com.pfa.PFABackend.Repository.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.PageWeb;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PageWebRepository extends JpaRepository<PageWeb, Integer> {
    public List<PageWeb> findByUser(User user);
}

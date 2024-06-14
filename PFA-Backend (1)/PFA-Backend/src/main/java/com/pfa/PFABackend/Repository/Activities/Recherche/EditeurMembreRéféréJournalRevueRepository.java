package com.pfa.PFABackend.Repository.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.EditeurMembreRéféréJournalRevue;
import com.pfa.PFABackend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EditeurMembreRéféréJournalRevueRepository extends JpaRepository<EditeurMembreRéféréJournalRevue, Integer> {
    public List<EditeurMembreRéféréJournalRevue> findByUser(User user);
}

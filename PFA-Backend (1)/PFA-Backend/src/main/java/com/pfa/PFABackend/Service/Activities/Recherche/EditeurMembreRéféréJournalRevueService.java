package com.pfa.PFABackend.Service.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.EditeurMembreRéféréJournalRevue;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface EditeurMembreRéféréJournalRevueService {
    public void saveEditeurMembreRéféréJournalRevue(ActivitySubType2 activitySubType2, String activityName, String journalRevue, String isbnIssn, String role, int année,  MultipartFile file) throws IOException;

    public Iterable<EditeurMembreRéféréJournalRevue> getEditeurMembreRéféréJournalRevues();
}

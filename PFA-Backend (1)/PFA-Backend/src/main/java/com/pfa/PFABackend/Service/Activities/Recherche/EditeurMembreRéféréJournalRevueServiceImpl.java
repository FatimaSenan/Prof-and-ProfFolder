package com.pfa.PFABackend.Service.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.EditeurMembreRéféréJournalRevue;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Recherche.EditeurMembreRéféréJournalRevueRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Service
public class EditeurMembreRéféréJournalRevueServiceImpl implements EditeurMembreRéféréJournalRevueService{

    @Autowired
    private EditeurMembreRéféréJournalRevueRepository editeurMembreRéféréJournalRevueRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public void saveEditeurMembreRéféréJournalRevue(ActivitySubType2 activitySubType2, String activityName, String journalRevue, String isbnIssn, String role, int année, MultipartFile file) throws IOException {
        EditeurMembreRéféréJournalRevue editeurMembreRéféréJournalRevue = new EditeurMembreRéféréJournalRevue();
        editeurMembreRéféréJournalRevue.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        editeurMembreRéféréJournalRevue.setActivityName(activityName);
        editeurMembreRéféréJournalRevue.setJournalRevue(journalRevue);
        editeurMembreRéféréJournalRevue.setIsbnIssn(isbnIssn);
        editeurMembreRéféréJournalRevue.setRole(role);
        editeurMembreRéféréJournalRevue.setAnnée(année);
        editeurMembreRéféréJournalRevue.setJustification(file.getBytes());
        editeurMembreRéféréJournalRevue.setUser(user);
        editeurMembreRéféréJournalRevueRepository.save(editeurMembreRéféréJournalRevue);

    }

    @Override
    public Iterable<EditeurMembreRéféréJournalRevue> getEditeurMembreRéféréJournalRevues() {
        return editeurMembreRéféréJournalRevueRepository.findAll();
    }
}

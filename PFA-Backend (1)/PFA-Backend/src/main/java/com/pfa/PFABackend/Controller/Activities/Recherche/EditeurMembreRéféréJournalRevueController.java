package com.pfa.PFABackend.Controller.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.EditeurMembreRéféréJournalRevue;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Recherche.EditeurMembreRéféréJournalRevueService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class EditeurMembreRéféréJournalRevueController {

    @Autowired
    private EditeurMembreRéféréJournalRevueService editeurMembreRéféréJournalRevueService;

    @Autowired
    ActivitySubType2Service activitySubType2Service;

    @PostMapping("/add-editeur-membre-référé-journal-revue")
    public String addEditeurMembreRéféréJournalRevue(@RequestParam("activityName") String activityName,@RequestParam("journalRevue") String journalRevue,@RequestParam("isbnIssn") String isbnIssn,@RequestParam("role") String role,@RequestParam("année") int année,@RequestParam("file") MultipartFile file){
        try{
            ActivitySubType2 activitySubType2Instance = activitySubType2Service.findById(18);
            editeurMembreRéféréJournalRevueService.saveEditeurMembreRéféréJournalRevue(activitySubType2Instance, activityName, journalRevue, isbnIssn, role, année, file);
            return " A new Editeur membre référé journal revue is added";
        }catch(IOException e) {
            e.printStackTrace();
            return "Failed to add Editeur membre référé journal revue";
        }
    }

    @GetMapping("/editeur-membre-référé-journaml-revue")
    public Iterable<EditeurMembreRéféréJournalRevue> getEditeurMembreRéféréJournalRevue(){
        return editeurMembreRéféréJournalRevueService.getEditeurMembreRéféréJournalRevues();
    }
}

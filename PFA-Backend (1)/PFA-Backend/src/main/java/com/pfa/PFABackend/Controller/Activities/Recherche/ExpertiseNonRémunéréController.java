package com.pfa.PFABackend.Controller.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.ExpertiseNonRémunéré;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Recherche.ExpertiseNonRémunéréService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ExpertiseNonRémunéréController {

    @Autowired
    private ExpertiseNonRémunéréService expertiseNonRémunéréService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service;

    @PostMapping("/add-expertise-non-rémunéré")
    public String addExpertiseNonRémunéré(@RequestParam("activityName") String activityName,@RequestParam("projet") String projet,@RequestParam("natureExpertise") String natureExpetise,@RequestParam("année") int année,@RequestParam("file") MultipartFile file){
        try{
            ActivitySubType2 activitySubType2Instance = activitySubType2Service.findById(18);
            expertiseNonRémunéréService.saveExpertiseNonRémunéré(activitySubType2Instance, activityName, projet, natureExpetise, année, file);
            return " A Expertise non rémunéré is added";
        }catch(IOException e) {
            e.printStackTrace();
            return "Failed to add Expertise non rémunéré";
        }
    }

    @GetMapping("/expertise-non-rémunéré")
    public Iterable<ExpertiseNonRémunéré> getExpertiseNonRémunére(){
        return expertiseNonRémunéréService.getExpertiseNonRémunéré();
    }
}

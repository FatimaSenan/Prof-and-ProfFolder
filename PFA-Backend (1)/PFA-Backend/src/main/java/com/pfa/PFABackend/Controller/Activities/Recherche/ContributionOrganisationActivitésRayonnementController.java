package com.pfa.PFABackend.Controller.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.ContributionOrganisationActivitésRayonnement;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Recherche.ContributionOrganisationActivitésRayonnementService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ContributionOrganisationActivitésRayonnementController {

    @Autowired
    private ContributionOrganisationActivitésRayonnementService contributionOrganisationActivitésRayonnementService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service;

    @PostMapping("/add-contribution-organisation-activités-rayonnement")
    public String addContributionOrganisationActivitésRayonnement(@RequestParam("activityName") String activityName,@RequestParam("nomConférence") String nomConférence,@RequestParam("lien") String lien,@RequestParam("type") String type,@RequestParam("role") String role,@RequestParam("date") String date ,@RequestParam("file") MultipartFile file){
        try{
            ActivitySubType2 activitySubType2 = activitySubType2Service.findById(19);
            contributionOrganisationActivitésRayonnementService.saveContributionOrganisationActivitésRayonnement(activitySubType2, activityName, nomConférence, lien, type, role, date, file);
            return "A new Contribution Organisation Activités Rayonnement is added";
        }catch(IOException e) {
            e.printStackTrace();
            return "Failed to add Contribution Organisation Activités Rayonnement";
        }
    }

    @GetMapping("/contribution-organisation-activités-rayonnement")
    public Iterable<ContributionOrganisationActivitésRayonnement> getContributionOrganisationActivitésRayonnement(){
        return contributionOrganisationActivitésRayonnementService.getContributionOrganisationActivitésRayonnements();
    }
}

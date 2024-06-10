package com.pfa.PFABackend.Controller.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.AssociationConnaissance;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Recherche.AssociationConnaissanceService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class AssociationConnaissanceController {
    @Autowired
    private AssociationConnaissanceService associationConnaissanceService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service;

    @PostMapping("/add-association-connaissance")
    public String addAssociationConnaissance(@RequestParam("activityName") String activityName,@RequestParam("responsabilité") String responsabilité,@RequestParam("années") String années, @RequestParam("file")MultipartFile file){
        ActivitySubType2 activitySubType2Instance = activitySubType2Service.findById(9);
        try{
            associationConnaissanceService.saveAssociationConnaissance(activitySubType2Instance, activityName, responsabilité, années, file);
            return "A new Association connaissance is added";
        } catch(IOException e) {
            e.printStackTrace();
            return "Failed to add Association Connaissance";
        }
    }

    @GetMapping("/associations-connaissance")
    public Iterable<AssociationConnaissance> getAssociationConnaissances(){
        return associationConnaissanceService.getAssociationConnaissances();

    }


}

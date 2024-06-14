package com.pfa.PFABackend.Controller.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.IncubationProjetRecherche;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Recherche.IncubationProjetRechercheService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class IncubationProjetRechercheController {

    @Autowired
    private IncubationProjetRechercheService incubationProjetRechercheService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service;

    @PostMapping("/add-incubation-projet-recherche")
    public String addIncubationProjetRecherche(@RequestParam("activityName") String activityName,@RequestParam("projet") String projet,@RequestParam("cadre") String cadre,@RequestParam("role") String role,@RequestParam("années") String années,@RequestParam("file") MultipartFile file) {
        try{
            ActivitySubType2 activitySubType2Instance = activitySubType2Service.findById(20);
            incubationProjetRechercheService.saveIncubationProjetRecherche(activitySubType2Instance, activityName, projet, cadre, role, années, file);
            return " A new Incubation projet recherche is  added";
        }catch(IOException e) {
            e.printStackTrace();
            return "Failed to add Incubation projet recherche";
        }
    }

    @GetMapping("/incubation-projet-recherche")
    public Iterable<IncubationProjetRecherche> getIncubationProjetRecherche(){
        return incubationProjetRechercheService.getIncubationProjetRecherche();
    }
}

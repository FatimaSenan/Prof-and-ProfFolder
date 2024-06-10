package com.pfa.PFABackend.Controller.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.ResponsableMembreStructureRecherchePole;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Recherche.ResponsableMembreStructureRechercheAccréditéePoleCompetenceService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ResponsableMembreStructureRechercheAccréditéePoleCompetenceController {

    @Autowired
    private ResponsableMembreStructureRechercheAccréditéePoleCompetenceService responsableMembreStructureRechercheAccréditéePoleCompetenceService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service;

    @PostMapping("/add-responsable-membre-structure-recherche-accréditée-pole-competence")
    public String addResponsableMembreStructureRechercheAccréditéePoleCompetence(@RequestParam("activityName") String activityName,@RequestParam("responsabilité") String responsabilité,@RequestParam("années") String années,@RequestParam("file") MultipartFile file){
        try{
            ActivitySubType2 activitySubType2Instance = activitySubType2Service.findById(16);
            responsableMembreStructureRechercheAccréditéePoleCompetenceService.saveResponsableMembreStructureRechercheAccréditéePoleCompetence(activitySubType2Instance, activityName, responsabilité, années, file);
            return " A new Responsable Membre Structure Recherche Accréditée Pole Competence is added";
        }catch(IOException e) {
            e.printStackTrace();
            return "Failed to add Responsable Membre Structure Recherche Accréditée Pole Competence";
        }
    }

    @GetMapping("/responsable-membre-structure-recherche-accréditée-pol-competence")
    public Iterable<ResponsableMembreStructureRecherchePole> getResponsableMembreStructureRechercheAccréditéePoleCompetence(){
        return responsableMembreStructureRechercheAccréditéePoleCompetenceService.getResponsableMembreStructureRechercheAccréditéePoleCompetences();
    }
}

package com.pfa.PFABackend.Controller.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.ProjetDeRechercheDeveloppement;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Recherche.ProjetDeRechercheDeveloppementService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ProjetDeRechercheDeveloppementController {

    @Autowired
    private ProjetDeRechercheDeveloppementService projetDeRechercheDeveloppementService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service;

    @PostMapping("/add-projet-de-recherche-developpement")
    public String addProjetDeRechercheDeveloppement(@RequestParam("activityName") String activityName,@RequestParam("titreProjet") String titreProjet,@RequestParam("cadre") String cadre,@RequestParam("role") String role,@RequestParam("année") int année,@RequestParam("file") MultipartFile file){
        try{
            ActivitySubType2 activitySubType2Instance = activitySubType2Service.findById(20);
            projetDeRechercheDeveloppementService.saveProjetDeRechercheDeveloppement(activitySubType2Instance, activityName, titreProjet, cadre, role, année, file);
            return "A new Projet de recherche developpement is added";
        }catch(IOException e) {
            e.printStackTrace();
            return "Failed to add Projet de recherche developpement";
        }

    }

    @GetMapping("/projet-de-recherche-developpement")
    public Iterable<ProjetDeRechercheDeveloppement> getProjetDeRechercheDeveloppement(){
        return  projetDeRechercheDeveloppementService.getProjetDeRechercheDeveloppement();
    }
}

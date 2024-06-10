package com.pfa.PFABackend.Controller.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.ChapitreOuvrage;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Recherche.ChapitreOuvrageService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ChapitreOuvrageController {

    @Autowired
    private ChapitreOuvrageService chapitreOuvrageService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service;

    @PostMapping("/add-chapitre-ouvrage")
    public String addChapitreOuvrage(@RequestParam("activityName") String activityName,@RequestParam("titre") String titre,@RequestParam("isbn") String isbn,@RequestParam("auteurs") String auteurs,@RequestParam("depotLegal") String depotLegal,@RequestParam("date") String date,@RequestParam("file") MultipartFile file){
        try{
            ActivitySubType2 activitySubType2Instance = activitySubType2Service.findById(10);
            chapitreOuvrageService.saveChapitreOuvrage(activitySubType2Instance, activityName, titre, isbn, auteurs, depotLegal, date, file);
            return "A new Chapitre ouvrage is added";
        }catch(IOException e) {
            e.printStackTrace();
            return "Failed to add Chapitre Ouvrage";
        }
    }

    @GetMapping("/chapitres-ouvrage")
    public Iterable<ChapitreOuvrage> getChapitreOuvrages(){
        return  chapitreOuvrageService.getChapitreOuvrages();
    }
}

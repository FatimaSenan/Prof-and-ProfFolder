package com.pfa.PFABackend.Controller.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.OuvrageSpecialisé;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Recherche.OuvrageSpecialiséService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class OuvrageSpecialiséController {
    @Autowired
    private OuvrageSpecialiséService ouvrageSpecialiséService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service;

    @PostMapping("/add-ouvrage-specialisé")
    public String addOuvrageSpecialisé(@RequestParam("activityName") String activityName,@RequestParam("publicateur") String publicateur,@RequestParam("titre") String titre,@RequestParam("isbnIssn") String isbnIssn,@RequestParam("auteurs") String auteurs,@RequestParam("depotLegal") String depotLegal,@RequestParam("date") String date,@RequestParam("file") MultipartFile file){
        try{
            ActivitySubType2 activitySubType2Instance = activitySubType2Service.findById(10);
            ouvrageSpecialiséService.saveOuvrageSpecialisé(activitySubType2Instance, activityName, publicateur, titre, isbnIssn, auteurs, depotLegal, date, file);
            return " A new Ouvrage spécialisé is added";
        }catch(IOException e) {
            e.printStackTrace();
            return "Failed to add Ouvrage spécialisé recherche";
        }
    }

    @GetMapping("/ovrage-spécialisés")
    public Iterable<OuvrageSpecialisé> getOuvrageSpécialisés(){
        return ouvrageSpecialiséService.getOuvrageSpecialisé();
    }
}

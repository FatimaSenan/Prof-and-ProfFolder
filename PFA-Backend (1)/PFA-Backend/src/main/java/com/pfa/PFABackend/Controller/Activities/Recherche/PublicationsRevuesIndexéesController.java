package com.pfa.PFABackend.Controller.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.PublicationRevuesScientifiques;
import com.pfa.PFABackend.Model.Activities.Recherche.PublicationsRevuesIndexées;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Recherche.PublicationsRevuesIndexéesService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class PublicationsRevuesIndexéesController {

    @Autowired
    private PublicationsRevuesIndexéesService publicationsRevuesIndexéesService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service;

    @PostMapping("/add-publications-revues-indexées")
    @PreAuthorize("hasRole('PROFESSOR')")
    public String addPblicationsRevuesIndexées(@RequestParam("activityName") String activityName,@RequestParam("niveau") String niveau,@RequestParam("titre") String titre,@RequestParam("auteurs") String auteurs,@RequestParam("doi") String doi,@RequestParam("lien") String lien,@RequestParam("journal") String journal,@RequestParam("isbn") String isbn,@RequestParam("annéePublication") int annéePublication,@RequestParam("file") MultipartFile file){
        try{
            ActivitySubType2 activitySubType2Instance = activitySubType2Service.findById(9);
            publicationsRevuesIndexéesService.savePublicationRevuesIndexées(activitySubType2Instance, activityName, niveau, titre, auteurs, doi, lien, journal, isbn, annéePublication, file);
            return " A new Publications Revues Indexées is added";
        }catch(IOException e) {
            e.printStackTrace();
            return "Failed to add Publications Revues Indexées";
        }
    }

    @GetMapping("/publication-revues-indexées")
    public Iterable<PublicationsRevuesIndexées> getPublicationsRevuesIndexées(){
        return publicationsRevuesIndexéesService.getPublicationRevuesIndexées();
    }
}

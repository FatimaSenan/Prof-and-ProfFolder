package com.pfa.PFABackend.Controller.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.PublicationRevuesScientifiques;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Recherche.PublicationRevuesScientifiquesService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class PublicationRevuesScientifiquesController {

    @Autowired
    private PublicationRevuesScientifiquesService publicationRevuesScientifiquesService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service;

    @PostMapping("/add-publication-revues-scientifiques")
    @PreAuthorize("hasRole('PROFESSOR')")
    public String addPublicationRevuesScientifiques(@RequestParam("activityName") String activityName,@RequestParam("type") String type,@RequestParam("titre") String titre,@RequestParam("auteurs") String auteurs,@RequestParam("lien") String lien,@RequestParam("journal") String journal,@RequestParam("issn") String isbn,@RequestParam("annéePublication") int annéePublication,@RequestParam("file") MultipartFile file){
        try{
            ActivitySubType2 activitySubType2Instance = activitySubType2Service.findById(9);
            publicationRevuesScientifiquesService.savePublicationRevuesScientifiques(activitySubType2Instance, activityName, type, titre, auteurs, lien, journal, isbn, annéePublication, file);
            return "A new publication revues scientifiques is added";
        }catch(IOException e) {
            e.printStackTrace();
            return "Failed to addpublication revues scientifiques";
        }
    }

    @GetMapping("/publication-revues-scientifiques")
    public Iterable<PublicationRevuesScientifiques> getPublicationsRevuesScientifiqes(){
        return publicationRevuesScientifiquesService.getPublicationRevuesScientifiques();
    }
}

package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.Activities.Enseignement.Ouvrage;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.OuvrageService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class OuvrageController {
    @Autowired
    private OuvrageService ouvrageService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/add-ouvrage")
    @PreAuthorize("hasRole('PROFESSOR')")
    public String addOuvrage(@RequestParam("activityName") String activityName, @RequestParam("titreOuvrage") String titreOuvrage, @RequestParam("auteurs") String auteurs, @RequestParam("isbn") String isbn, @RequestParam("depotLegal") String depotLegal, @RequestParam("maisonEdition") String maisonEdition, @RequestParam("annéePublication") int annéePublication, @RequestParam("file") MultipartFile file){
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(1);

        try {
            ouvrageService.saveOuvrage(specificActivitySubType2Instance, activityName,titreOuvrage, auteurs, isbn, depotLegal, maisonEdition, annéePublication, file);
            return "A new Ouvrage is added";
        }catch(IOException e){
            e.printStackTrace();
            return "Failed to add Ouvrage";
        }

    }

    @GetMapping("/ouvrages")
    public Iterable<Ouvrage> getOuvrages() {
        return ouvrageService.getOuvrages();
    }
}

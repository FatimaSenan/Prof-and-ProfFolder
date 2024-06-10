package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.Activities.Enseignement.PetitsLivres;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.PetitsLivresService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class PetitsLivresController {
    @Autowired
    private PetitsLivresService petitsLivresService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/add-petit-livre")
    @PreAuthorize("hasRole('PROFESSOR')")
    public String addPetitLivre(@RequestParam("activityName") String activityName, @RequestParam("titreLivre") String titreLivre, @RequestParam("auteurs") String auteurs, @RequestParam("annéePublication") int annéePublication, @RequestParam("file") MultipartFile file) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(2);


        try{
            petitsLivresService.savePetitsLivres(specificActivitySubType2Instance, activityName, titreLivre, auteurs, annéePublication, file);
            return "A new Petit Livre is added";
        }catch(IOException e){
            e.printStackTrace();
            return "Failed to add Petit Livre";
        }

    }

    @GetMapping("/petits-livres")
    public Iterable<PetitsLivres> getPetitsLivres() {
        return petitsLivresService.getPetitsLivres();
    }
}

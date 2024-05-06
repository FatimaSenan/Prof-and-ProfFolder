package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.Activities.Enseignement.PetitsLivres;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.PetitsLivresService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String addPetitLivre(@RequestBody PetitsLivres petitsLivres) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(2);

        petitsLivres.setActivitySubType2(specificActivitySubType2Instance);
        petitsLivresService.saveMPetitsLivres(petitsLivres);
        return "A new Petit Livre is added";
    }

    @GetMapping("/petits-livres")
    public Iterable<PetitsLivres> getPetitsLivres() {
        return petitsLivresService.getPetitsLivres();
    }
}

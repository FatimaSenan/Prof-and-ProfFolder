package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.Activities.Enseignement.Ouvrage;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.OuvrageService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String addOuvrage(@RequestBody Ouvrage ouvrage ){
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(1);

        ouvrage.setActivitySubType2(specificActivitySubType2Instance);
        ouvrageService.saveOuvrage(ouvrage);
        return "A new Ouvrage is added";
    }

    @GetMapping("/ouvrages")
    public Iterable<Ouvrage> getOuvrages() {
        return ouvrageService.getOuvrages();
    }
}

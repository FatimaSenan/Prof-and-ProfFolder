package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.Activities.Enseignement.MontagesExpérimentaux;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.MontagesExpérimentauxService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class MontagesExpérimentauxController {
    @Autowired
    private MontagesExpérimentauxService montagesExpérimentauxService;
    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/add-montages-expérimentaux")
    public String addMontagesExpérimentaux(@RequestBody MontagesExpérimentaux montagesExpérimentaux) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(2);

        montagesExpérimentaux.setActivitySubType2(specificActivitySubType2Instance);
        montagesExpérimentauxService.saveMontagesExpérimentaux(montagesExpérimentaux);
        return "A new Montages expérimentaux is added";
    }

    @GetMapping("/montages-expérimentaux")
    public Iterable<MontagesExpérimentaux> getMontagesExpérimentaux() {
        return montagesExpérimentauxService.getMontagesExpérimentaux();
    }
}

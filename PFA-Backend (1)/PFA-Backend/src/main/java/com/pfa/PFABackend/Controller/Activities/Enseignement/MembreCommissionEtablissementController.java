package com.pfa.PFABackend.Controller.Activities.Enseignement;


import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionEtablissement;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.MembreCommissionEtablissementService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")

public class MembreCommissionEtablissementController {
    @Autowired
    private MembreCommissionEtablissementService membreCommissionEtablissementService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/add-membre-commission-etablissement")
    public String addMembreCommissionEtablissement(@RequestBody MembreCommissionEtablissement membreCommissionEtablissement) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(8);

        membreCommissionEtablissement.setActivitySubType2(specificActivitySubType2Instance);
        membreCommissionEtablissementService.saveMembreCommissionEtablissement(membreCommissionEtablissement);
        return "A new membre commission etablissement  is added";
    }

    @GetMapping("/membre-commissions-etablissement")
    public Iterable<MembreCommissionEtablissement> getMembreCommissionEtablissement() {
        return membreCommissionEtablissementService.getMembreCommissionsEtablisements();
    }
}

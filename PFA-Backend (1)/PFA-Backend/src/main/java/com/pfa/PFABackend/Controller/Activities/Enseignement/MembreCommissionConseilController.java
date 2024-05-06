package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.EncadrementRH;
import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.MembreCommissionConseilService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class MembreCommissionConseilController {
    @Autowired
    private MembreCommissionConseilService membreCommissionConseilService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/add-membre-commission-conseil")
    public String addMembreCommissionConseil(@RequestBody MembreCommissionConseil membreCommissionConseil) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(8);

        membreCommissionConseil.setActivitySubType2(specificActivitySubType2Instance);
       membreCommissionConseilService.saveMembreCommissionConseil(membreCommissionConseil);
        return "A new Encadrement RH is added";
    }

    @GetMapping("/membre-commissions-conseils")
    public Iterable<MembreCommissionConseil> getMembreCommissionsConseils() {
        return membreCommissionConseilService.getMembreCommissionConseils();
    }
}

package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.Activities.Enseignement.MembreConseilCoordination;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.MembreConseilCoordinationService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class MembreConseilCoordinationController {
    @Autowired
    private MembreConseilCoordinationService membreConseilCoordinationService;
    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PersistenceContext
    private EntityManager entityManager;
    @PostMapping("/add-membre-conseil-coordination")
    public String addMembreConseilCoordination(@RequestBody MembreConseilCoordination membreConseilCoordination) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(8);

        membreConseilCoordination.setActivitySubType2(specificActivitySubType2Instance);
        membreConseilCoordinationService.saveMembreConseilCoordination(membreConseilCoordination);
        return "A new Membre Conseil Coordination is added";
    }

    @GetMapping("/membre-conseils-coordinations")
    public Iterable<MembreConseilCoordination> getMembreConseilsCoordinations() {
        return membreConseilCoordinationService.getMembreConseilsCoordinations();
    }
}

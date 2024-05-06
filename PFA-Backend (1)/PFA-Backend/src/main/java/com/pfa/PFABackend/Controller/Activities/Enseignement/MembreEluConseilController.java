package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.Activities.Enseignement.MembreEluConseil;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.MembreEluConseilService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class MembreEluConseilController {
    @Autowired
    private MembreEluConseilService membreEluConseilService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PersistenceContext
    private EntityManager entityManager;
    @PostMapping("/add-membre-elu-conseil")
    public String addMembreEluConseil(@RequestBody MembreEluConseil membreEluConseil) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(8);

        membreEluConseil.setActivitySubType2(specificActivitySubType2Instance);
        membreEluConseilService.saveMembreEluConseil(membreEluConseil);
        return "A new EMembre Elu Conseil is added";
    }

    @GetMapping("/membre-elu-conseils")
    public Iterable<MembreEluConseil> getMembreEluConseils() {
        return membreEluConseilService.getMembreEluConseils();
    }
}

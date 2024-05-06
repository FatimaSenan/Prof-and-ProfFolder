package com.pfa.PFABackend.Controller.Activities.Enseignement;


import com.pfa.PFABackend.Model.Activities.Enseignement.Manuel;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.ManuelService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ManuelController {
    @Autowired
    private ManuelService manuelService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/add-manuel")
    public String addManuel(@RequestBody Manuel manuel) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(1);

        manuel.setActivitySubType2(specificActivitySubType2Instance);
        manuelService.saveManuel(manuel);
        return "A new manuel is added";
    }

    @GetMapping("/manuels")
    public Iterable<Manuel> getManuels() {
        return manuelService.getManuels();
    }
}

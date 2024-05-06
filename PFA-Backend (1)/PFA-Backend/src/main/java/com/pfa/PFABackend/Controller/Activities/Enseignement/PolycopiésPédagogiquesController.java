package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.Activities.Enseignement.PolycopiésPédagogiques;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.PolycopiésPédagogiquesService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class PolycopiésPédagogiquesController {
    @Autowired
    private PolycopiésPédagogiquesService polycopiésPédagogiquesService;
    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service



    @PostMapping("/add-polycopié-pédagogique")
    public String addPolycopiéPédagogique(@RequestBody PolycopiésPédagogiques polycopiésPédagogiques) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(2);

        polycopiésPédagogiques.setActivitySubType2(specificActivitySubType2Instance);
        polycopiésPédagogiquesService.savePolycopiésPédagogiques(polycopiésPédagogiques);
        return "A new Polycopié pédagigique is added";
    }

    @GetMapping("/polycopiés-pédagigiques")
    public Iterable<PolycopiésPédagogiques> getPolycopiésPédagogiques() {
        return polycopiésPédagogiquesService.getPolycopiésPédagogiques();
    }
}

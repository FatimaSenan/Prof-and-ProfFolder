package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.Didacticiels;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.DidacticielsService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class DidacticielsController {
    @Autowired
    private DidacticielsService didacticielsService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PersistenceContext
    private EntityManager entityManager;


    @PostMapping("/add-didacticiels")
    public String addDidacticiels(@RequestBody Didacticiels didacticiels) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(3);

        didacticiels.setActivitySubType2(specificActivitySubType2Instance);
        didacticielsService.saveDidacticiels(didacticiels);
        return "A new didacticiel is added";
    }

    @GetMapping("/didacticiels")
    public Iterable<Didacticiels> getDidacticiels() {
        return didacticielsService.getDidacticiels();
    }
}

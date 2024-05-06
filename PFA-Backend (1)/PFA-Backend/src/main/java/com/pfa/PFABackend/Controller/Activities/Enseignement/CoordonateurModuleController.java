package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.CoordonateurModule;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.CoordonateurModuleService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class CoordonateurModuleController {
    @Autowired
    private CoordonateurModuleService coordonateurModuleService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PersistenceContext
    private EntityManager entityManager;


    @PostMapping("/add-coordonateur-module")
    public String addCoordonateurModule(@RequestBody CoordonateurModule coordonateurModule) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(7);

        coordonateurModule.setActivitySubType2(specificActivitySubType2Instance);
        coordonateurModuleService.saveCoordonateurModule(coordonateurModule);
        return "A new Coordonateur de module is added";
    }

    @GetMapping("/coordonateur-modules")
    public Iterable<CoordonateurModule> getCoordonateurModules() {
        return coordonateurModuleService.getCoordonateurModules();
    }

}

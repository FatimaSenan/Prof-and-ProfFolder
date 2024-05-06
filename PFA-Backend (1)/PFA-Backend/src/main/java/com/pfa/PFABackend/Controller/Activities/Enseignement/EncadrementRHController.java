package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.Didacticiels;
import com.pfa.PFABackend.Model.Activities.Enseignement.EncadrementRH;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.DidacticielsService;
import com.pfa.PFABackend.Service.Activities.Enseignement.EncadrementRHService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class EncadrementRHController {
    @Autowired
    private EncadrementRHService encadrementRHService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/add-encadrement-RH")
    public String addEncadrementRH(@RequestBody EncadrementRH encadrementRH) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(6);

        encadrementRH.setActivitySubType2(specificActivitySubType2Instance);
        encadrementRHService.saveEncadrementRH(encadrementRH);
        return "A new Encadrement RH is added";
    }

    @GetMapping("/encadrement-RH")
    public Iterable<EncadrementRH> getEncadrementRHs() {
        return encadrementRHService.getEncadrementRHs();
    }
}

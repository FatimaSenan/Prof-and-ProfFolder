package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MOOC;
import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.MOOCService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class MOOCController {
    @Autowired
    private MOOCService moocService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/add-mooc")
    public String addMooc(@RequestBody MOOC mooc) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(3);

        mooc.setActivitySubType2(specificActivitySubType2Instance);
        moocService.saveMOOC(mooc);
        return "A new MOOC is added";
    }

    @GetMapping("/moocs")
    public Iterable<MOOC> getMoocs() {
        return moocService.getMoocs();
    }
}

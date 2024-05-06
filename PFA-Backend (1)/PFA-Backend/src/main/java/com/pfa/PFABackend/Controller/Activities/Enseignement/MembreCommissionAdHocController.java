package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.EncadrementRH;
import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionAdHoc;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.MembreCommissionAdHocService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class MembreCommissionAdHocController {
    @Autowired
    private MembreCommissionAdHocService membreCommissionAdHocService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/add-membre-commission-adhoc")
    public String addMembreCommissionAdHoc(@RequestBody MembreCommissionAdHoc membreCommissionAdHoc) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(8);

        membreCommissionAdHoc.setActivitySubType2(specificActivitySubType2Instance);
        membreCommissionAdHocService.saveMembreCommissionAdHoc(membreCommissionAdHoc);
        return "A new membre commission ad hoc is added";
    }

    @GetMapping("/membre-commissions-adhoc")
    public Iterable<MembreCommissionAdHoc> getMembreCommissionAdHoc() {
        return membreCommissionAdHocService.getMembreCommissionAdHocs();
    }
}

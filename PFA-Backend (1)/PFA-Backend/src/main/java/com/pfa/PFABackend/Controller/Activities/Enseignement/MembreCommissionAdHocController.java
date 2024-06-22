package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.EncadrementRH;
import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionAdHoc;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.MembreCommissionAdHocService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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
    @PreAuthorize("hasRole('PROFESSOR')")
    public String addMembreCommissionAdHoc(@RequestParam("activityName") String activityName, @RequestParam("typeCommissionAdHoc") String typeCommissionAdHoc, @RequestParam("année") int année, MultipartFile file) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(8);

        try{
            membreCommissionAdHocService.saveMembreCommissionAdHoc(specificActivitySubType2Instance, activityName, typeCommissionAdHoc, année, file);
            return "A new membre commission ad hoc is added";
        } catch(IOException e) {
            e.printStackTrace();
            return "Failed to add membre commission ad hoc";
        }

    }

    @GetMapping("/membre-commissions-adhoc")
    public Iterable<MembreCommissionAdHoc> getMembreCommissionAdHoc() {
        return membreCommissionAdHocService.getMembreCommissionAdHocs();
    }
}

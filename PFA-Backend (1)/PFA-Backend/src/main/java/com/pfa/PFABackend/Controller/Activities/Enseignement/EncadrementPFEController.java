package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.Didacticiels;
import com.pfa.PFABackend.Model.Activities.Enseignement.EncadrementPFE;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.DidacticielsService;
import com.pfa.PFABackend.Service.Activities.Enseignement.EncadrementPFEService;
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
public class EncadrementPFEController {
    @Autowired
    private EncadrementPFEService encadrementPFEService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PersistenceContext
    private EntityManager entityManager;


    @PostMapping("/add-encadrement-pfe")
    @PreAuthorize("hasRole('PROFESSOR')")
    public String addEncadrementPFE(@RequestParam("activityName") String activityName, @RequestParam("typeEncadrement") String typeEncadrement, @RequestParam("titrePfe") String titrePfe, @RequestParam("étudiants") String étudiants, @RequestParam("année") int année, @RequestParam("filière") String filière, @RequestParam("file")MultipartFile file) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(4);

        try{
            encadrementPFEService.saveEncadrementPFE(specificActivitySubType2Instance, activityName, typeEncadrement, titrePfe,étudiants, année, filière, file);
            return "A new encadrement pfe is added";
        }catch(IOException e) {
            e.printStackTrace();
            return "Failed to add encadrement PFE";
        }

    }

    @GetMapping("/encadrement-PFE")
    public Iterable<EncadrementPFE> getEncadrementPFEs() {
        return encadrementPFEService.getEncadrementPFEs();
    }
}

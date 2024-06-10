package com.pfa.PFABackend.Controller.Activities.Enseignement;


import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionEtablissement;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.MembreCommissionEtablissementService;
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

public class MembreCommissionEtablissementController {
    @Autowired
    private MembreCommissionEtablissementService membreCommissionEtablissementService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/add-membre-commission-etablissement")
    @PreAuthorize("hasRole('PROFESSOR')")
    public String addMembreCommissionEtablissement(@RequestParam("activityName") String activityName, @RequestParam("titreCommission") String titreCommission, @RequestParam("typeCommission") String typeCommission, @RequestParam("période") String période, @RequestParam("file")MultipartFile file) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(8);

      try{
          membreCommissionEtablissementService.saveMembreCommissionEtablissement(specificActivitySubType2Instance, activityName, titreCommission, typeCommission, période, file);
          return "A new membre commission etablissement  is added";
      }catch(IOException e) {
          e.printStackTrace();
          return "Failed to add Membre Commission Etablissement";
      }

    }

    @GetMapping("/membre-commissions-etablissement")
    public Iterable<MembreCommissionEtablissement> getMembreCommissionEtablissement() {
        return membreCommissionEtablissementService.getMembreCommissionsEtablisements();
    }
}

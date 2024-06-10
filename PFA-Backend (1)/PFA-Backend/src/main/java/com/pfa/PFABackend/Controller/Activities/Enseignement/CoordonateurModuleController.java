package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.CoordonateurModule;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.CoordonateurModuleService;
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
public class CoordonateurModuleController {
    @Autowired
    private CoordonateurModuleService coordonateurModuleService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PersistenceContext
    private EntityManager entityManager;


    @PostMapping("/add-coordonateur-module")
    @PreAuthorize("hasRole('PROFESSOR')")
    public String addCoordonateurModule(@RequestParam("activityName") String activityName, @RequestParam("nomModule") String nomModule, @RequestParam("filière") String filière, @RequestParam("niveau") String niveau, @RequestParam("departement") String departement, @RequestParam("etablissement") String etablissement, @RequestParam("annéesResponsabilités") String annéesResponsabilités, @RequestParam("file")MultipartFile file) throws IOException {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(7);

        try{
            coordonateurModuleService.saveCoordonateurModule(specificActivitySubType2Instance, activityName,nomModule, filière, niveau, departement, etablissement, annéesResponsabilités, file);
            return "A new Coordonateur de module is added";
        }catch(IOException e) {
            e.printStackTrace();
            return "Failed to add Coordonateur module";
        }

    }

    @GetMapping("/coordonateur-modules")
    public Iterable<CoordonateurModule> getCoordonateurModules() {
        return coordonateurModuleService.getCoordonateurModules();
    }

}

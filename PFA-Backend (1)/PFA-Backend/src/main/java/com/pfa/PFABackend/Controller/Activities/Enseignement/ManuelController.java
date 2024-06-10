package com.pfa.PFABackend.Controller.Activities.Enseignement;


import com.pfa.PFABackend.Model.Activities.Enseignement.Manuel;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.ManuelService;
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
public class ManuelController {
    @Autowired
    private ManuelService manuelService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/add-manuel")
    @PreAuthorize("hasRole('PROFESSOR')")
    public String addManuel(@RequestParam("activityName") String activityName, @RequestParam("module") String module, @RequestParam("filièreNiveau") String filièreNiveau, @RequestParam("annéesUniversitaires") String annéesUniversitaires, @RequestParam("file")MultipartFile file) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(1);

        try {
            manuelService.saveManuel(specificActivitySubType2Instance, activityName, module, filièreNiveau, annéesUniversitaires, file);
            return "A new manuel is added";
        }catch(IOException e){
            e.printStackTrace();
            return "Failed to add Manuel";
        }

    }

    @GetMapping("/manuels")
    public Iterable<Manuel> getManuels() {
        return manuelService.getManuels();
    }
}

package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.Activities.Enseignement.PolycopiésPédagogiques;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.PolycopiésPédagogiquesService;
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
public class PolycopiésPédagogiquesController {
    @Autowired
    private PolycopiésPédagogiquesService polycopiésPédagogiquesService;
    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service



    @PostMapping("/add-polycopié-pédagogique")
    @PreAuthorize("hasRole('PROFESSOR')")
    public String addPolycopiéPédagogique(@RequestParam("activityName") String activityName, @RequestParam("module") String module, @RequestParam("filièreNiveau") String filièreNiveau, @RequestParam("annéesUniversitaires") String annéesUniversitaires, @RequestParam("file")MultipartFile file) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(2);

        try{
            polycopiésPédagogiquesService.savePolycopiésPédagogiques(specificActivitySubType2Instance, activityName, module , filièreNiveau, annéesUniversitaires, file);
            return "A new Polycopié pédagigique is added";
        }catch(IOException e){
            e.printStackTrace();
            return "Failed to add Polycopié pédagogique";
        }

    }

    @GetMapping("/polycopiés-pédagigiques")
    public Iterable<PolycopiésPédagogiques> getPolycopiésPédagogiques() {
        return polycopiésPédagogiquesService.getPolycopiésPédagogiques();
    }
}

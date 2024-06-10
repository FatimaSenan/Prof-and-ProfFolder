package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.CoordonateurFilière;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.CoordonateurFilièreService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class CoordonateurFilièreController {
    @Autowired
    private CoordonateurFilièreService coordonateurFilièreService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/add-coordonateur-filière")
    @PreAuthorize("hasRole('PROFESSOR')")
    public String addCoordonateurFilière(@RequestParam("activityName") String activityName, @RequestParam("typeFilière") String typeFilière, @RequestParam("nomFilière") String nomFilière, @RequestParam("etablissement") String etablissement, @RequestParam("annéesResponsabilités") String annéesResponsabilités , @RequestParam("file")MultipartFile file) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(7);

       try {
           coordonateurFilièreService.saveCoordonateurFilière(specificActivitySubType2Instance, activityName, typeFilière, nomFilière, etablissement, annéesResponsabilités, file);

           return "A new Coordonateur filière is added";
       }catch(IOException e) {
           e.printStackTrace();
           return "Failed to add Coordonateur filière";
       }
    }

    @GetMapping("/coordonateur-filières")
    public Iterable<CoordonateurFilière> getCoordonateurFilières() {
        return coordonateurFilièreService.getCoordonateurFilières();
    }

    /*@GetMapping("/coordonateur-filière/type-filière-options")
    public ResponseEntity<List<String>> getTypeFilièreOptions() {
        List <String> options = Arrays.asList(
                "licence fondamentale (non cumulable avec le chef de département)",
                "Master ou cycle d'ingénieur ou autre cycle bac +5",
                "licence professionnelle ou DUT"
        );
        return ResponseEntity.ok(options);
    }*/
}

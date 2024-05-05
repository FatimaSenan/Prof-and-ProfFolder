package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.CoordonateurFilière;
import com.pfa.PFABackend.Service.Activities.Enseignement.CoordonateurFilièreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class CoordonateurFilièreController {
    @Autowired
    private CoordonateurFilièreService coordonateurFilièreService;

    @PostMapping("/add-coordonateur-filière")
    public String addCoordonateurFilière(@RequestBody CoordonateurFilière coordonateurFilière) {
        coordonateurFilièreService.saveCoordonateurFilière(coordonateurFilière);
        return "A new Coordonateur filière is added";
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

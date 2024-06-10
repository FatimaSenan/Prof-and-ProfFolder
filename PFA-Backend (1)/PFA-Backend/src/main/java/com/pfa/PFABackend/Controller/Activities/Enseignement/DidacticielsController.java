package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.Didacticiels;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.DidacticielsService;
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
public class DidacticielsController {
    @Autowired
    private DidacticielsService didacticielsService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PersistenceContext
    private EntityManager entityManager;


    @PostMapping("/add-didacticiels")
    @PreAuthorize("hasRole('PROFESSOR')")
    public String addDidacticiels(@RequestParam("activityName") String activityName, @RequestParam("support") String support, @RequestParam("module") String module, @RequestParam("année") int année, @RequestParam("file")MultipartFile file) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(3);

        try{
            didacticielsService.saveDidacticiels(specificActivitySubType2Instance, activityName, support, module, année ,file);
            return "A new didacticiel is added";
        }catch(IOException e){
            e.printStackTrace();
            return "Failed to add Didacticiels";
        }

    }

    @GetMapping("/didacticiels")
    public Iterable<Didacticiels> getDidacticiels() {
        return didacticielsService.getDidacticiels();
    }
}

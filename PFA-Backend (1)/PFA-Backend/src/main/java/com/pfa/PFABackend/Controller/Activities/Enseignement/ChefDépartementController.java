package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pfa.PFABackend.Model.Activities.Enseignement.ChefDépartement;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.ChefDépartementService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ChefDépartementController {

    @Autowired
    private ChefDépartementService chefDépartementService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PersistenceContext
    private EntityManager entityManager;



    @PostMapping("/add-chef-departement")
    @PreAuthorize("hasRole('PROFESSOR')") // Ensure the user has the correct role
    public String addChefDépartement(@RequestParam("activityName") String activityName, @RequestParam("département") String département,@RequestParam("établissement") String établissement,@RequestParam("annéesResponsabilités") String annéesResponsabilité,@RequestParam("file")MultipartFile file){
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(7);
        try{
          /*  ChefDépartement chefDépartement = new ChefDépartement();

            chefDépartement.setActivitySubType2(specificActivitySubType2Instance);
           */
            chefDépartementService.saveChefDépartement(specificActivitySubType2Instance, activityName, département, établissement, annéesResponsabilité, file);


            return "A new Chef department is added";
        } catch(IOException e) {
            e.printStackTrace();
            return "Failed to add Chef Departement";
        }


    }

    @GetMapping("/chef-departements")
    public Iterable<ChefDépartement> getChefDépartemets(){
        return chefDépartementService.getChefDépartements();
    }
}

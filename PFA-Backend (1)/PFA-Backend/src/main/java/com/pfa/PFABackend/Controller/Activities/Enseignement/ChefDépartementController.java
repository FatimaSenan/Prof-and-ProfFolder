package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pfa.PFABackend.Model.Activities.Enseignement.ChefDépartement;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.ChefDépartementService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String addChefDépartement(@RequestBody ChefDépartement chefDépartement){
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(7);

        chefDépartement.setActivitySubType2(specificActivitySubType2Instance);
        chefDépartementService.saveChefDépartement(chefDépartement);
        return "A new Chef departemet added";
    }

    @GetMapping("/chef-departements")
    public Iterable<ChefDépartement> getChefDépartemets(){
        return chefDépartementService.getChefDépartements();
    }
}

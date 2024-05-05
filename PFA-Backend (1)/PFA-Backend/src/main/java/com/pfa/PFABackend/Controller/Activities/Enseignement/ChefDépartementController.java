package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pfa.PFABackend.Model.Activities.Enseignement.ChefDépartement;
import com.pfa.PFABackend.Service.Activities.Enseignement.ChefDépartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ChefDépartementController {

    @Autowired
    private ChefDépartementService chefDépartementService;



    @PostMapping("/add-chef-departement")
    public String addChefDépartement(@RequestBody ChefDépartement chefDépartement){
        chefDépartementService.saveChefDépartement(chefDépartement);
        return "A new Chef departemet added";
    }

    @GetMapping("/chef-departements")
    public Iterable<ChefDépartement> getChefDépartemets(){
        return chefDépartementService.getChefDépartements();
    }
}

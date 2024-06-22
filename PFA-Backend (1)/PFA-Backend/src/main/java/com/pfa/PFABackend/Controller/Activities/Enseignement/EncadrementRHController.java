package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.Didacticiels;
import com.pfa.PFABackend.Model.Activities.Enseignement.EncadrementRH;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.DidacticielsService;
import com.pfa.PFABackend.Service.Activities.Enseignement.EncadrementRHService;
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
public class EncadrementRHController {
    @Autowired
    private EncadrementRHService encadrementRHService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/add-encadrement-RH")
    @PreAuthorize("hasRole('PROFESSOR')")
    public String addEncadrementRH(@RequestParam("activityName")String activityName, @RequestParam("typeEncadrement") String typeEncadrement, @RequestParam("titre") String titre, @RequestParam("membres") String membres, @RequestParam("dateDébut") String dateDébut, @RequestParam("dateFin") String dateFin, @RequestParam("file")MultipartFile file) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(6);

        try {
            encadrementRHService.saveEncadrementRH(specificActivitySubType2Instance, activityName, typeEncadrement, titre,membres, dateDébut, dateFin, file);
            return "A new Encadrement RH is added";
        }catch(IOException e){
            e.printStackTrace();
            return "Failed to add Encadrement RH";
        }

    }

    @GetMapping("/encadrement-RH")
    public Iterable<EncadrementRH> getEncadrementRHs() {
        return encadrementRHService.getEncadrementRHs();
    }
}

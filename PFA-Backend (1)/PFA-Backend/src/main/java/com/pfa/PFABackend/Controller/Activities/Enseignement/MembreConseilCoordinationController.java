package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.Activities.Enseignement.MembreConseilCoordination;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.MembreConseilCoordinationService;
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
public class MembreConseilCoordinationController {
    @Autowired
    private MembreConseilCoordinationService membreConseilCoordinationService;
    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PersistenceContext
    private EntityManager entityManager;
    @PostMapping("/add-membre-conseil-coordination")
    @PreAuthorize("hasRole('PROFESSOR')")
    public String addMembreConseilCoordination(@RequestParam("activityName") String activityName, @RequestParam("titreConseil") String titreConseil, @RequestParam("période") String période, @RequestParam("file")MultipartFile file) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(8);

       try{
           membreConseilCoordinationService.saveMembreConseilCoordination(specificActivitySubType2Instance, activityName, titreConseil, période, file);
           return "A new Membre Conseil Coordination is added";
       } catch(IOException e) {
           e.printStackTrace();
           return "Failed to add Membre Conseil Coordination ";
       }

    }

    @GetMapping("/membre-conseils-coordinations")
    public Iterable<MembreConseilCoordination> getMembreConseilsCoordinations() {
        return membreConseilCoordinationService.getMembreConseilsCoordinations();
    }
}

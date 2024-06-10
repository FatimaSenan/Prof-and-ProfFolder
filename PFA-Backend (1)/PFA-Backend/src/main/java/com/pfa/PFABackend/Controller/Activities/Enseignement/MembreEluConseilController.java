package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.Activities.Enseignement.MembreEluConseil;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.MembreEluConseilService;
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
public class MembreEluConseilController {
    @Autowired
    private MembreEluConseilService membreEluConseilService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PersistenceContext
    private EntityManager entityManager;
    @PostMapping("/add-membre-elu-conseil")
    @PreAuthorize("hasRole('PROFESSOR')")
    public String addMembreEluConseil(@RequestParam("activityName") String activityName, @RequestParam("membreConseil") String membreConseil, @RequestParam("période") String période, @RequestParam("file")MultipartFile file) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(8);
        try{
            membreEluConseilService.saveMembreEluConseil(specificActivitySubType2Instance, activityName, membreConseil, période, file);
            return "A new Membre Elu Conseil is added";
        }catch(IOException e){
            e.printStackTrace();
            return "Failed to add Membre Elu Conseil";
        }


    }

    @GetMapping("/membre-elu-conseils")
    public Iterable<MembreEluConseil> getMembreEluConseils() {
        return membreEluConseilService.getMembreEluConseils();
    }
}

package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MOOC;
import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.MOOCService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class MOOCController {
    @Autowired
    private MOOCService moocService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/add-mooc")
    @PreAuthorize("hasRole('PROFESSOR')")
    public String addMooc(@RequestParam("activityName") String activityName, @RequestParam("titreMooc") String titreMooc, @RequestParam("datePublication") String datePublication, @RequestParam("lien") String lien) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(3);

        try{
            moocService.saveMOOC(specificActivitySubType2Instance, activityName, titreMooc, datePublication, lien);
            return "A new MOOC is added";
        }catch(IOException e){
            e.printStackTrace();
            return "Failed to add MOOC";
        }

    }

    @GetMapping("/moocs")
    public Iterable<MOOC> getMoocs() {
        return moocService.getMoocs();
    }
}

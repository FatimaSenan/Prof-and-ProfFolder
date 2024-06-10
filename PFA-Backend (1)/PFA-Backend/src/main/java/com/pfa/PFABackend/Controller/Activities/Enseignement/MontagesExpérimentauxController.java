package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.Activities.Enseignement.MontagesExpérimentaux;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.MontagesExpérimentauxService;
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
public class MontagesExpérimentauxController {
    @Autowired
    private MontagesExpérimentauxService montagesExpérimentauxService;
    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping("/add-montages-expérimentaux")
    @PreAuthorize("hasRole('PROFESSOR')")
    public String addMontagesExpérimentaux(@RequestParam("activityName") String activityName, @RequestParam("module") String module, @RequestParam("filière") String filière, @RequestParam("nombreManip") int nombreManip, @RequestParam("file")MultipartFile file) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(2);
        try{
            montagesExpérimentauxService.saveMontagesExpérimentaux(specificActivitySubType2Instance, activityName, module, filière, nombreManip, file);
            return "A new Montages expérimentaux is added";

        }catch(IOException e){
            e.printStackTrace();
            return "Failed to add Montages experimentaux";
        }


    }

    @GetMapping("/montages-expérimentaux")
    public Iterable<MontagesExpérimentaux> getMontagesExpérimentaux() {
        return montagesExpérimentauxService.getMontagesExpérimentaux();
    }
}

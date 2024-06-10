package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.Activities.Enseignement.ViceDoyen;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.ViceDoyenService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ViceDoyenController {
    @Autowired
    private ViceDoyenService viceDoyenService;
    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PostMapping("/add-vice-doyen")
    @PreAuthorize("hasRole('PROFESSOR')")
    public String addViceDoyen(@RequestParam("activityName") String activityName, @RequestParam("nomFonction") String nomFonction, @RequestParam("établissement") String établissement, @RequestParam("annéesResponsabilités") String annéesResponsabilités, @RequestParam("file")MultipartFile file) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(8);
        try {
            viceDoyenService.saveViceDoyen(specificActivitySubType2Instance, activityName, nomFonction, établissement, annéesResponsabilités, file);
            return "A new Vice Doyen is added";
        }catch(IOException e) {
            e.printStackTrace();
            return "Failed to add Vice doyen";
        }
    }

    @GetMapping("/vices-doyens")
    public Iterable<ViceDoyen> getVicesDoyens() {
        return viceDoyenService.getVicesDoyens();
    }
}

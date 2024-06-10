package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.Activities.Enseignement.Supports;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.SupportsService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class SupportsController {
    @Autowired
    private SupportsService supportsService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PostMapping("/add-support")
    @PreAuthorize("hasRole('PROFESSOR')")
    public String addSupport(@RequestParam("activityName") String activityName, @RequestParam("typeSupport") String typeSupport, @RequestParam("titre") String  titre, @RequestParam("type") String type, @RequestParam("module") String module, @RequestParam("année") int année, @RequestParam("file")MultipartFile file) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(3);

        try {
            supportsService.saveSpports(specificActivitySubType2Instance, activityName, typeSupport, titre, type, module, année, file);
            return "A new Support is added";
        } catch(IOException e) {
            e.printStackTrace();
            return "Failed to add Support";
        }

    }

    @GetMapping("/supports")
    public Iterable<Supports> getSupports() {
        return supportsService.getSupports();
    }
}

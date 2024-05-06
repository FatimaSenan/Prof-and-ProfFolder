package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.Activities.Enseignement.Supports;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.SupportsService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class SupportsController {
    @Autowired
    private SupportsService supportsService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PostMapping("/add-support")
    public String addSupport(@RequestBody Supports supports) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(3);

        supports.setActivitySubType2(specificActivitySubType2Instance);
        supportsService.saveSpports(supports);
        return "A new Support is added";
    }

    @GetMapping("/supports")
    public Iterable<Supports> getSupports() {
        return supportsService.getSupports();
    }
}

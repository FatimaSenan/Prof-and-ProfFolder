package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.Activities.Enseignement.ViceDoyen;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.ViceDoyenService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ViceDoyenController {
    @Autowired
    private ViceDoyenService viceDoyenService;
    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PostMapping("/add-vice-doyen")
    public String addViceDoyen(@RequestBody ViceDoyen viceDoyen) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(8);

        viceDoyen.setActivitySubType2(specificActivitySubType2Instance);
       viceDoyenService.saveViceDoyen(viceDoyen);
        return "A new Vice Doyen is added";
    }

    @GetMapping("/vices-doyens")
    public Iterable<ViceDoyen> getVicesDoyens() {
        return viceDoyenService.getVicesDoyens();
    }
}

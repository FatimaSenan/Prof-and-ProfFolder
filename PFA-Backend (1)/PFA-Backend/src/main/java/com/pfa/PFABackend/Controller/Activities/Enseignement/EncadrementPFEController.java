package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.Didacticiels;
import com.pfa.PFABackend.Model.Activities.Enseignement.EncadrementPFE;
import com.pfa.PFABackend.Service.Activities.Enseignement.DidacticielsService;
import com.pfa.PFABackend.Service.Activities.Enseignement.EncadrementPFEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EncadrementPFEController {
    @Autowired
    private EncadrementPFEService encadrementPFEService;

    @PostMapping("/add-encadrement-pfe")
    public String addEncadrementPFE(@RequestBody EncadrementPFE encadrementPFE) {
        encadrementPFEService.saveEncadrementPFE(encadrementPFE);
        return "A new encadrement pfe is added";
    }

    @GetMapping("/encadrement-PFE")
    public Iterable<EncadrementPFE> getEncadrementPFEs() {
        return encadrementPFEService.getEncadrementPFEs();
    }
}

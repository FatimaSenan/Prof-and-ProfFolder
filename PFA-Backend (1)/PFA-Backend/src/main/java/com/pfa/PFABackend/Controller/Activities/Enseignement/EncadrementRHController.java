package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.Didacticiels;
import com.pfa.PFABackend.Model.Activities.Enseignement.EncadrementRH;
import com.pfa.PFABackend.Service.Activities.Enseignement.DidacticielsService;
import com.pfa.PFABackend.Service.Activities.Enseignement.EncadrementRHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EncadrementRHController {
    @Autowired
    private EncadrementRHService encadrementRHService;

    @PostMapping("/add-encadrement-RH")
    public String addEncadrementRH(@RequestBody EncadrementRH encadrementRH) {
        encadrementRHService.saveEncadrementRH(encadrementRH);
        return "A new Encadrement RH is added";
    }

    @GetMapping("/encadrement-RH")
    public Iterable<EncadrementRH> getEncadrementRHs() {
        return encadrementRHService.getEncadrementRHs();
    }
}

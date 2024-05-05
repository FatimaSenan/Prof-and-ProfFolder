package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.CoordonateurModule;
import com.pfa.PFABackend.Service.Activities.Enseignement.CoordonateurModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CoordonateurModuleController {
    @Autowired
    private CoordonateurModuleService coordonateurModuleService;

    @PostMapping("/add-coordonateur-module")
    public String addCoordonateurModule(@RequestBody CoordonateurModule coordonateurModule) {
        coordonateurModuleService.saveCoordonateurModule(coordonateurModule);
        return "A new Coordonateur de module is added";
    }

    @GetMapping("/coordonateur-modules")
    public Iterable<CoordonateurModule> getCoordonateurModules() {
        return coordonateurModuleService.getCoordonateurModules();
    }

}

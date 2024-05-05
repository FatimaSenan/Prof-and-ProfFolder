package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.Didacticiels;
import com.pfa.PFABackend.Service.Activities.Enseignement.DidacticielsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DidacticielsController {
    @Autowired
    private DidacticielsService didacticielsService;

    @PostMapping("/add-didacticiels")
    public String addDidacticiels(@RequestBody Didacticiels didacticiels) {
        didacticielsService.saveDidacticiels(didacticiels);
        return "A new didacticiel is added";
    }

    @GetMapping("/didacticiels")
    public Iterable<Didacticiels> getDidacticiels() {
        return didacticielsService.getDidacticiels();
    }
}

package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.Activities.Enseignement.PréparationSortiesTerrain;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.PréparationSortiesTerrainService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class PréparationSortiesTerrainController {
    @Autowired
    private PréparationSortiesTerrainService préparationSortiesTerrainService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PostMapping("/add-préparation-sorties-terrain")
    public String addPréparationSortiesTerrain(@RequestBody PréparationSortiesTerrain préparationSortiesTerrain) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(2);

        préparationSortiesTerrain.setActivitySubType2(specificActivitySubType2Instance);
        préparationSortiesTerrainService.savePréparationSortiesTerrains(préparationSortiesTerrain);
        return "A new préparation storties terrain is added";
    }

    @GetMapping("/préparations-sorties-terrains")
    public Iterable<PréparationSortiesTerrain> getPréparationSortiesTerrain() {
        return préparationSortiesTerrainService.getPréparationsSortiesTerrain();
    }
}

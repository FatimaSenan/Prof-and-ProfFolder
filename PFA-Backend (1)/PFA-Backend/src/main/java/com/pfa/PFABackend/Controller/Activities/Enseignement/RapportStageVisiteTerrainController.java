package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.Activities.Enseignement.RapportStageVisiteTerrain;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.RapportStageVisiteTerrainService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class RapportStageVisiteTerrainController {
    @Autowired
    private RapportStageVisiteTerrainService rapportStageVisiteTerrainService;
    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PostMapping("/add-rapport-stage-visite-terrain")
    public String addRapportVisiteTerrain(@RequestBody RapportStageVisiteTerrain rapportStageVisiteTerrain) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(5);

        rapportStageVisiteTerrain.setActivitySubType2(specificActivitySubType2Instance);
        rapportStageVisiteTerrainService.saveRapportStageVisiteTerrain(rapportStageVisiteTerrain);
        return "A new Rapport Stage Visite Terrain is added";
    }

    @GetMapping("/rapports-stages-visite-terrain")
    public Iterable<RapportStageVisiteTerrain> getRapportsStagesVisiteTerrain() {
        return rapportStageVisiteTerrainService.getRapportsStagesVisitesTerrains();
    }
}

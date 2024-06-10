package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.Activities.Enseignement.RapportStageVisiteTerrain;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.RapportStageVisiteTerrainService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class RapportStageVisiteTerrainController {
    @Autowired
    private RapportStageVisiteTerrainService rapportStageVisiteTerrainService;
    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PostMapping("/add-rapport-stage-visite-terrain")
    @PreAuthorize("hasRole('PROFESSOR')")
    public String addRapportVisiteTerrain(@RequestParam("activityName") String activityName, @RequestParam("titreStage") String titreStage, @RequestParam("cadre") String cadre, @RequestParam("année") int année, @RequestParam("société") String société, @RequestParam("file")MultipartFile file) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(5);

        try{
            rapportStageVisiteTerrainService.saveRapportStageVisiteTerrain(specificActivitySubType2Instance, activityName, titreStage, cadre,année, société, file);
            return "A new Rapport Stage Visite Terrain is added";
        } catch(IOException e){
            e.printStackTrace();
            return "Failed to add Rapport Stage Visite Terrain";
        }

    }

    @GetMapping("/rapports-stages-visite-terrain")
    public Iterable<RapportStageVisiteTerrain> getRapportsStagesVisiteTerrain() {
        return rapportStageVisiteTerrainService.getRapportsStagesVisitesTerrains();
    }
}

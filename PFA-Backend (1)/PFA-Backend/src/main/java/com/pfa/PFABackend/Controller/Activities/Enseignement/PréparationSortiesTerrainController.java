package com.pfa.PFABackend.Controller.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.Activities.Enseignement.PréparationSortiesTerrain;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Enseignement.PréparationSortiesTerrainService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class PréparationSortiesTerrainController {
    @Autowired
    private PréparationSortiesTerrainService préparationSortiesTerrainService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service; // Inject ActivitySubType2 service

    @PostMapping("/add-préparation-sorties-terrain")
    @PreAuthorize("hasRole('PROFESSOR')")
    public String addPréparationSortiesTerrain(@RequestParam("activityName") String activityName, @RequestParam("cadre") String cadre, @RequestParam("date") String date, @RequestParam("nomSociété") String nomSociété, @RequestParam("file")MultipartFile file) {
        ActivitySubType2 specificActivitySubType2Instance = activitySubType2Service.findById(2);

        try{
            préparationSortiesTerrainService.savePréparationSortiesTerrains(specificActivitySubType2Instance, activityName, cadre, date, nomSociété, file);
            return "A new préparation sorties terrain is added";
        }catch(IOException e){
            e.printStackTrace();
            return "Failed to add préparation Sorties terrain";
        }

    }

    @GetMapping("/préparations-sorties-terrains")
    public Iterable<PréparationSortiesTerrain> getPréparationSortiesTerrain() {
        return préparationSortiesTerrainService.getPréparationsSortiesTerrain();
    }
}

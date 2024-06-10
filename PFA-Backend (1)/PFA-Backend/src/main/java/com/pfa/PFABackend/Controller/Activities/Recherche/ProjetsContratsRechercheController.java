package com.pfa.PFABackend.Controller.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.ProjetsContratsRecherche;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Recherche.ProjetsContratsRechercheService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ProjetsContratsRechercheController {

    @Autowired
    private ProjetsContratsRechercheService projetsContratsRechercheService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service;

    @PostMapping("/add-projets-contrats-recherche")
    public String addProjetsContratsRecherche(@RequestParam("activityName") String activityName,@RequestParam("titreProjet") String titreProjet,@RequestParam("responsabilité") String responsabilité,@RequestParam("cadre") String cadre,@RequestParam("type") String type,@RequestParam("période") String période,@RequestParam("file") MultipartFile file){
        try{
            ActivitySubType2 activitySubType2Instance = activitySubType2Service.findById(17);
            projetsContratsRechercheService.saveProjetsContratsRecherche(activitySubType2Instance, activityName, titreProjet, responsabilité, cadre, type, période, file);
            return "A new Projets contrats recherche is added";
        }catch(IOException e) {
            e.printStackTrace();
            return "Failed to add Projets contrats recherche";
        }
    }

    @GetMapping("/projets-contrats-recherches")
    public Iterable<ProjetsContratsRecherche> getProjetsContratsRecherche(){
        return projetsContratsRechercheService.getProjetsContratsRecherche();
    }
}

package com.pfa.PFABackend.Controller.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.CongrèsConférencesNonPubliées;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Recherche.CongrèsConférencesNonPubliéesService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class CongrèsConférencesNonPubliéesController {

    @Autowired
    private CongrèsConférencesNonPubliéesService congrèsConférencesNonPubliéesService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service;

    @PostMapping("/add-congrès-conférences-non-publiées")
    public String addCongrèsConférencesNonPubliées(@RequestParam("activityName") String activityName,@RequestParam("nomConférence") String nomConférence,@RequestParam("année") int année,@RequestParam("lien") String lien,@RequestParam("titreCommunication") String titreCommunication,@RequestParam("auteurs") String auteurs,@RequestParam("file") MultipartFile file){
        try{
            ActivitySubType2 activitySubType2Instance = activitySubType2Service.findById(12);
            congrèsConférencesNonPubliéesService.saveCongrèsConférencesNonPubliées(activitySubType2Instance, activityName, nomConférence, année, lien, titreCommunication, auteurs, file);
            return "A new Congrès Conférences non publiées is added";
        }catch(IOException e) {
            e.printStackTrace();
            return "Failed to add Congrès Conférences non publiées";
        }
    }

    @GetMapping("/congrès-conférences-non-publiées")
    public Iterable<CongrèsConférencesNonPubliées> getCongrèsConférencesNonPubliées(){
        return congrèsConférencesNonPubliéesService.getCongrèsConférencesNonPubliées();
    }
}

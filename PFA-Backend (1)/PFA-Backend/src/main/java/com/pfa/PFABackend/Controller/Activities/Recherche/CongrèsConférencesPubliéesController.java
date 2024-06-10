package com.pfa.PFABackend.Controller.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.CongrèsConférencesPubliées;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Recherche.CongrèsConférencesPubliéesService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class CongrèsConférencesPubliéesController {

    @Autowired
    private CongrèsConférencesPubliéesService congrèsConférencesPubliéesService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service;

    @PostMapping("/add-congrès-conférences-publiées")
    public String addCongrèsConférencesPubliées(@RequestParam("activityName") String activityName,@RequestParam("type") String type, @RequestParam("nomConférence") String nomConférence, @RequestParam("année") int année, @RequestParam("lien") String lien, @RequestParam("titreCommunication") String titreCommunication, @RequestParam("auteurs") String auteurs, @RequestParam("file") MultipartFile file){
        try{
            ActivitySubType2 activitySubType2 = activitySubType2Service.findById(11);
            congrèsConférencesPubliéesService.saveCongrèsConférencesPubliées(activitySubType2, activityName, type, nomConférence, année, lien, titreCommunication, auteurs, file);
            return "A new Congrès Conférences Publiées is added";
        }catch(IOException e) {
            e.printStackTrace();
            return "Failed to add Congrès Conférences  publiées";
        }
    }

    @GetMapping("/congrès-conférences-publiées")
    public Iterable<CongrèsConférencesPubliées> getCongrèsConférencesPubliées(){
        return  congrèsConférencesPubliéesService.getCongrèsConférencesPubliées();
    }
}

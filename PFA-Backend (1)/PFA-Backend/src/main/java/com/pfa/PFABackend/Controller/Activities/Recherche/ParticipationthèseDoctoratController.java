package com.pfa.PFABackend.Controller.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.ParticipationthèseDoctorat;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Recherche.ParticipationthèseDoctoratService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ParticipationthèseDoctoratController {

    @Autowired
    private ParticipationthèseDoctoratService participationthèseDoctoratService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service;

    @PostMapping("/add-participation-thèse-doctorat")
    public String addParticipationthèseDoctorat(@RequestParam("activityName") String activityName,@RequestParam("sujet") String sujetThèse,@RequestParam("role") String role,@RequestParam("doctorant") String doctorant,@RequestParam("date") String date,@RequestParam("université") String université,@RequestParam("file") MultipartFile file){
        try{
            ActivitySubType2 activitySubType2Instance = activitySubType2Service.findById(15);
            participationthèseDoctoratService.saveParticipationthèseDoctorat(activitySubType2Instance, activityName, sujetThèse, doctorant, date, université, file);
            return " A new Participation thèse Doctorat is added";
        }catch(IOException e) {
            e.printStackTrace();
            return "Failed to add Participation thèse Doctorat";
        }
    }

    @GetMapping("/participation-thèse-doctorat")
    public Iterable<ParticipationthèseDoctorat> getParticipationThèseDoctorats(){
        return participationthèseDoctoratService.getParticipationthèseDoctorat();
    }
}

package com.pfa.PFABackend.Controller.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.Brevet;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Recherche.BrevetService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class BrevetController {

    @Autowired
    private BrevetService brevetService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service;

    @PostMapping("/add-brevet")
    public String addBrevet(@RequestParam("activityName") String activityName,@RequestParam("auteur") String auteur,@RequestParam("titre") String titre,@RequestParam("doi") String doi,@RequestParam("journalRevue") String journalRevue,@RequestParam("isbn") String isbn,@RequestParam("année") int année,@RequestParam("pages") int pages,@RequestParam("indexation") String indexation,@RequestParam("file") MultipartFile file){
        try{
            ActivitySubType2 activitySubType2Instance = activitySubType2Service.findById(20);
            brevetService.saveBrevet(activitySubType2Instance, activityName, auteur, titre, doi, journalRevue, isbn, année, pages, indexation, file);
            return "A new Brevet is added";
        }catch(IOException e) {
            e.printStackTrace();
            return "Failed to add Brevet";
        }
    }

    @GetMapping("/brevets")
    public Iterable<Brevet> getBrevets(){
        return brevetService.getBrevets();
    }
}

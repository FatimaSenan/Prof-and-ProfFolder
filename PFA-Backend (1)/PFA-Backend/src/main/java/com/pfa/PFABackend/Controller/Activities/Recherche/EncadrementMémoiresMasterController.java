package com.pfa.PFABackend.Controller.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.EncadrementMémoiresMaster;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Recherche.EncadrementMémoiresMasterService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class EncadrementMémoiresMasterController {

    @Autowired
    private EncadrementMémoiresMasterService encadrementMémoiresMasterService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service;

    @PostMapping("/add-encadrement-mémoires-master")
    public String addEncadrementMémoiresMaster(@RequestParam("activityName") String activityName,@RequestParam("sujet") String sujetMaster,@RequestParam("étudiants") String étudiants,@RequestParam("année") int année,@RequestParam("encadrant") String encadrant,@RequestParam("file") MultipartFile file){
        try{
            ActivitySubType2 activitySubType2Instance = activitySubType2Service.findById(14);
            encadrementMémoiresMasterService.saveEncadrementMémoiresMaster(activitySubType2Instance, activityName, sujetMaster, étudiants, année, encadrant, file);
            return "A new Encadrement Mémoires Master is added";
        }catch(IOException e) {
            e.printStackTrace();
            return "Failed to add Encadrement Mémoires Master";
        }
    }

    @GetMapping("/encadrement-mémoires-master")
    public Iterable<EncadrementMémoiresMaster> getEncadrementMémoiresMaster(){
        return encadrementMémoiresMasterService.getEncadrementMémoiresMaster();
    }
}

package com.pfa.PFABackend.Controller.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.DoctoratsEncadrés;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.Activities.Recherche.DoctoratsEncadrésService;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class DoctoratsEncadrésServiceController {

    @Autowired
    private DoctoratsEncadrésService doctoratsEncadrésService;

    @Autowired
    private ActivitySubType2Service activitySubType2Service;

    @PostMapping("/add-doctorats-encadrés")
    public String addDoctoratsEncadrés(@RequestParam("activityName") String activityName,@RequestParam("inscription") String inscription,@RequestParam("sujet") String sujet,@RequestParam("formationDoctorale") String formationDOctorale,@RequestParam("laboratoire") String laboratoire,@RequestParam("doctorant") String doctorant,@RequestParam("directeurThèse") String directeurThèse,@RequestParam("dateSoutenance") String dateSoutenance,@RequestParam("file") MultipartFile file){
        try{
            ActivitySubType2 activitySubType2Instance = activitySubType2Service.findById(13);
            doctoratsEncadrésService.saveDoctoratsEncadrés(activitySubType2Instance, activityName, inscription, sujet, formationDOctorale, laboratoire, doctorant, directeurThèse, dateSoutenance, file);
            return "A new Doctorats Encadrés is added";
        }catch(IOException e) {
            e.printStackTrace();
            return "Failed to add Doctorats Encadrés";
        }
    }

    @GetMapping("/doctorats-encadrés")
    public Iterable<DoctoratsEncadrés> getDoctoratsEncadrés(){
        return doctoratsEncadrésService.getDoctoratsEncadrés();
    }
}

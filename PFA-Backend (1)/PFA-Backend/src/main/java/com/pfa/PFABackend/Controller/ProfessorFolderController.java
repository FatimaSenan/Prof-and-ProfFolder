package com.pfa.PFABackend.Controller;

import com.pfa.PFABackend.Model.Professor;
import com.pfa.PFABackend.Model.ProfessorFolder;
import com.pfa.PFABackend.Service.ProfessorFolderService;
import com.pfa.PFABackend.Service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/professor")
@CrossOrigin
public class ProfessorFolderController {

    @Autowired
    private ProfessorFolderService professorFolderService;

    @PostMapping("/add-professor-folder")
    public String addProfessorFolder(
            //@RequestParam int professorId,
            @RequestParam String civility,
            @RequestParam String nom,
            @RequestParam String prenom,
            @RequestParam String email,
            @RequestParam String drpp,
            @RequestParam String cne,
            @RequestParam String birthDate,
            @RequestParam String phone,
            @RequestParam String grade,
            @RequestParam String profile,
            @RequestParam String speciality,
            @RequestParam String establishment,
            @RequestParam String phdType,
            @RequestParam MultipartFile cv,
            @RequestParam MultipartFile applicationDemande,
            @RequestParam MultipartFile phdDiplome,
            @RequestParam MultipartFile habilitationDiplome,
            @RequestParam MultipartFile arretNomination,
            @RequestParam MultipartFile attestation
    ) {
        ProfessorFolder professorFolder = new ProfessorFolder();
        // Set non-file fields
        professorFolder.setCivility(civility);
        professorFolder.setNom(nom);
        professorFolder.setPrenom(prenom);
        professorFolder.setEmail(email);
        professorFolder.setDrpp(drpp);
        professorFolder.setCne(cne);
        professorFolder.setBirthDate(birthDate);
        professorFolder.setPhone(phone);
        professorFolder.setGrade(grade);
        professorFolder.setProfile(profile);
        professorFolder.setSpeciality(speciality);
        professorFolder.setEstablishment(establishment);
        professorFolder.setPhdType(phdType);
        // Set file fields
        try {
            professorFolder.setCv(cv.getBytes());
            professorFolder.setApplicationDemande(applicationDemande.getBytes());
            professorFolder.setPhdDiplome(phdDiplome.getBytes());
            professorFolder.setHabilitationDiplome(habilitationDiplome.getBytes());
            professorFolder.setArretNomination(arretNomination.getBytes());
            professorFolder.setAttestation(attestation.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload files";
        }

        professorFolderService.addProfessorFolder( professorFolder);
        return "Professor folder added successfully";
    }
}

package com.pfa.PFABackend.Controller;

import com.pfa.PFABackend.Model.Annexe2;
import com.pfa.PFABackend.Model.Professor;
import com.pfa.PFABackend.Model.ProfessorFolder;
import com.pfa.PFABackend.Service.ProfessorFolderService;
import com.pfa.PFABackend.Service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController

@CrossOrigin
public class ProfessorFolderController {

    @Autowired
    private ProfessorFolderService professorFolderService;

    @PostMapping("/professor/add-professor-folder")
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
            @RequestParam MultipartFile equivalence,
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
            professorFolder.setEquivalence(equivalence.getBytes());
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

    @GetMapping("/commission/get-professor-folder")
    public ResponseEntity<ProfessorFolder> getAnnexe2(@RequestParam(name = "userEmail") String userEmail) {
        ProfessorFolder professorFolder = professorFolderService.getProfessorFolderByUser(userEmail);
        return new ResponseEntity<>(professorFolder, HttpStatus.OK);
    }
    @GetMapping("/commission/get-equivalence")
    public ResponseEntity<byte[]> getEquivalencePdf(@RequestParam(name = "id") int id, @RequestParam(name = "userEmail") String userEmail){
        byte[] pdfBytes = professorFolderService.getEquivalencePdfForSelectedUser(id, userEmail);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachement", "cv.pdf");
        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }
    @GetMapping("/commission/get-cv")
    public ResponseEntity<byte[]> getCvPdf(@RequestParam(name = "id") int id, @RequestParam(name = "userEmail") String userEmail){
        byte[] pdfBytes = professorFolderService.getCVPdfForSelectedUser(id, userEmail);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachement", "cv.pdf");
        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }
    @GetMapping("/commission/get-application-demande")
    public ResponseEntity<byte[]> getApplicationDemandePdf(@RequestParam(name = "id") int id, @RequestParam(name = "userEmail") String userEmail){
        byte[] pdfBytes = professorFolderService.getApplicationDemandePdfForSelectedUser(id, userEmail);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachement", "cv.pdf");
        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }
    @GetMapping("/commission/get-phd-diplome")
    public ResponseEntity<byte[]> getPhdDiplomePdf(@RequestParam(name = "id") int id, @RequestParam(name = "userEmail") String userEmail){
        byte[] pdfBytes = professorFolderService.getPhdDiplomePdfForSelectedUser(id, userEmail);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachement", "cv.pdf");
        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

    @GetMapping("/commission/get-habilitation-diplome")
    public ResponseEntity<byte[]> getHabilitationDiplomePdf(@RequestParam(name = "id") int id, @RequestParam(name = "userEmail") String userEmail){
        byte[] pdfBytes = professorFolderService.getHabilitationDiplomePdfForSelectedUser(id, userEmail);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachement", "cv.pdf");
        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

    @GetMapping("/commission/get-arret-nomination")
    public ResponseEntity<byte[]> getArretNominationPdf(@RequestParam(name = "id") int id, @RequestParam(name = "userEmail") String userEmail){
        byte[] pdfBytes = professorFolderService.getArretNominationPdfForSelectedUser(id, userEmail);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachement", "cv.pdf");
        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

    @GetMapping("/commission/get-attestation")
    public ResponseEntity<byte[]> getAttestationPdf(@RequestParam(name = "id") int id, @RequestParam(name = "userEmail") String userEmail){
        byte[] pdfBytes = professorFolderService.getAttestationPdfForSelectedUser(id, userEmail);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachement", "cv.pdf");
        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }
}

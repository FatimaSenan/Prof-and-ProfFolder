package com.pfa.PFABackend.Controller;

import com.pfa.PFABackend.Model.Annexe3;
import com.pfa.PFABackend.Service.Annexe3Service;
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
public class Annexe3Controller {

    @Autowired
    private Annexe3Service annexe3Service;

    @PostMapping("/annexe3/add-annexe3")
    public String addAnnexe3(
            @RequestParam MultipartFile file,
            @RequestParam(required = false) byte[] teachingTable
    ) throws IOException {
        Annexe3 annexe3 = new Annexe3();

        if (file != null && !file.isEmpty()) {
            annexe3.setTeachingTable(file.getBytes());
        }

        if (teachingTable != null) {
            annexe3.setTeachingTable(teachingTable);
        }

        annexe3Service.addAnnexe3(annexe3);
        return "Annexe3 added successfully";
    }

    @GetMapping("/annexe3/get-annexe3")
    public ResponseEntity<byte[]> getAnnexe3Pdf( @RequestParam(name = "userEmail") String userEmail) {
        byte[] pdfBytes = annexe3Service.getAnnexe3PdfForSelectedUser(userEmail);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachement", "cv.pdf");
        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }
}

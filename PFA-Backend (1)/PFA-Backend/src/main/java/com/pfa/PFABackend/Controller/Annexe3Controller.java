package com.pfa.PFABackend.Controller;

import com.pfa.PFABackend.Model.Annexe3;
import com.pfa.PFABackend.Service.Annexe3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@RestController
@RequestMapping("/annexe3")
@CrossOrigin
public class Annexe3Controller {

    @Autowired
    private Annexe3Service annexe3Service;

    @PostMapping("/add-annexe3")
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
}

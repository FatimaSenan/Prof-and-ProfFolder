package com.pfa.PFABackend.Controller;

import com.pfa.PFABackend.Model.Annexe2;
import com.pfa.PFABackend.Service.Annexe2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/annexe2")
public class Annexe2Controller {

    @Autowired
    private Annexe2Service annexe2Service;

    @PostMapping("/save")
    public ResponseEntity<String> saveAnnexe2(@RequestBody Annexe2 annexe2) {
        String response = annexe2Service.addAnnexe2(annexe2);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}

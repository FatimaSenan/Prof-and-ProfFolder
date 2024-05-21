package com.pfa.PFABackend.Controller;

import com.pfa.PFABackend.Service.FileService;
import com.pfa.PFABackend.message.ResponseMessage;
import com.sun.net.httpserver.HttpsServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin("http://localhost:9005")
@RequestMapping("/api")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file")MultipartFile multipartFile) {
        String message = "";
        try{
            fileService.store(multipartFile);
            message = "Uploaded the file successfully: "+multipartFile.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage((message)));
        } catch(Exception e) {
            message = "Could not upload the file: "+multipartFile.getOriginalFilename()+" !";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }
}

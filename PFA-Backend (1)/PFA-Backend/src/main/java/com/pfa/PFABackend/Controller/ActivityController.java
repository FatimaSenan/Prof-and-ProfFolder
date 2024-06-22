package com.pfa.PFABackend.Controller;

import com.pfa.PFABackend.Model.Activity;
import com.pfa.PFABackend.Model.ActivitySubType1;
import com.pfa.PFABackend.Service.ActivityService;
import com.pfa.PFABackend.Service.ActivitySubType1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/professor/activities")
@CrossOrigin(origins = "http://localhost:3000")
public class ActivityController {
    @Autowired
    private ActivityService activityService;


    @GetMapping("/professor/activities/current-user")
    public List<List<?>> getActivitiesByCurrentUser() {
        return activityService.getAllActivitiesForCurrentUser();
    }

    @GetMapping("/commission/activities/selected-user")
    public List<List<?>> getActivitiesBySelectedUser(@RequestParam("email") String userEmail) {return activityService.getAllActivitiesForSelectedUser(userEmail);}

    @DeleteMapping("/professor/activities/delete-activity")
    public ResponseEntity<?> deleteSelectedActivity(@RequestParam(name = "activityName") String activityName, @RequestParam(name ="id") int activityId){
        try{
            activityService.deleteSelectedActivityForCurrentUser(activityName, activityId);
            return ResponseEntity.ok().body("Activity deleted Succesfully");
        }catch(IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred while deleting the activity");
        }
    }

    @GetMapping("/justification")
    public ResponseEntity<byte[]> getPdfJustification(@RequestParam(name = "activityName") String activityName, @RequestParam(name = "id") int id){
        byte[] pdfBytes = activityService.getJustificationPdf(activityName, id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachement", "justification.pdf");
        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }
}

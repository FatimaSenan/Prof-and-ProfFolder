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

    @GetMapping("/professor/activities/justification")
    public ResponseEntity<byte[]> getPdfJustification(@RequestParam(name = "activityName") String activityName, @RequestParam(name = "id") int id){
        byte[] pdfBytes = activityService.getJustificationPdf(activityName, id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachement", "justification.pdf");
        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

    @GetMapping("/commission/activities/justification")
    public ResponseEntity<byte[]> getPdfJustificationForSelectedUser(@RequestParam(name = "activityName") String activityName, @RequestParam(name = "id") int id, @RequestParam(name = "userEmail") String userEmail){
        byte[] pdfBytes = activityService.getJustificationPdfForSelectedUser(activityName, id, userEmail);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachement", "justification.pdf");
        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

    @PatchMapping("/commission/activities/validate")
    public ResponseEntity<?> validateActivity(@RequestParam(name = "activityName") String activityName,
                                              @RequestParam(name = "id") int activityId) {
        System.out.println("Activity ID: " + activityId);
        System.out.println("Activity Name: " + activityName);
        try {
            activityService.validateActivity(activityName, activityId);
            return ResponseEntity.ok().body("Activity validated successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while validating the activity");
        }
    }

    @PatchMapping("/commission/activities/cancel")
    public ResponseEntity<?> cancelActivity(@RequestParam(name = "activityName") String activityName,
                                              @RequestParam(name = "id") int activityId) {
        System.out.println("Activity ID: " + activityId);
        System.out.println("Activity Name: " + activityName);
        try {
            activityService.cancelActivity(activityName, activityId);
            return ResponseEntity.ok().body("Activity validated successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while validating the activity");
        }
    }

    @GetMapping("/administration/total-points")
    public ResponseEntity<Double>  calculateTotalPointsForUser(@RequestParam("email") String userEmail) {
        try {
            double totalPoints = activityService.calculateTotalPointsForUser(userEmail);
            return ResponseEntity.ok(totalPoints);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

}

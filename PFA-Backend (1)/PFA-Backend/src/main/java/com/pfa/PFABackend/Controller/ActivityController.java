package com.pfa.PFABackend.Controller;

import com.pfa.PFABackend.Model.Activity;
import com.pfa.PFABackend.Model.ActivitySubType1;
import com.pfa.PFABackend.Service.ActivityService;
import com.pfa.PFABackend.Service.ActivitySubType1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/professor/activities")
@CrossOrigin(origins = "http://localhost:3000")
public class ActivityController {
    @Autowired
    private ActivityService activityService;


    @GetMapping("/current-user")
    public List<List<?>> getActivitiesByCurrentUser() {
        return activityService.getAllActivitiesForCurrentUser();
    }

    @DeleteMapping("/delete-activity")
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
}

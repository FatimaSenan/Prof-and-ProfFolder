package com.pfa.PFABackend.Controller;

import com.pfa.PFABackend.Service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admincommission/activities")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminCommissionController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/professor/{id}")
    public ResponseEntity<List<List<?>>> getActivitiesByProfessorId(@PathVariable int id) {
        try {
            List<List<?>> activities = activityService.getActivitiesByProfessorId(id);
            return ResponseEntity.ok(activities);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}

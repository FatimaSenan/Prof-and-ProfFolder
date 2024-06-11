package com.pfa.PFABackend.Controller;

import com.pfa.PFABackend.Model.Activity;
import com.pfa.PFABackend.Model.ActivitySubType1;
import com.pfa.PFABackend.Service.ActivityService;
import com.pfa.PFABackend.Service.ActivitySubType1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/professorcommission/activities")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    /*@PostMapping("/add-activity")
    public String addActivity(@RequestBody Activity activity){
        activityService.saveActivity(activity);
        return "new activity added";
    }

    @GetMapping("/activities")
    public Iterable<Activity> getActivities(){
        return activityService.getActivities();
    }*/
    @GetMapping("/crrent-user")
    public Map<String, List<?>> getActivitiesByCurrentUser() {
        return activityService.getAllActivitiesForCurrentUser();
    }
}

package com.pfa.PFABackend.Controller;

import com.pfa.PFABackend.Model.ActivityType;
import com.pfa.PFABackend.Service.ActivityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ActivityTypeController {
    @Autowired
    private ActivityTypeService activityTypeService;

    @PostMapping("/add-activity-type")
    public String addActivityType(@RequestBody ActivityType activityType){
        activityTypeService.saveActivity(activityType);
        return "new activity type added";
    }

    @GetMapping("/activity-types")
    public Iterable<ActivityType> getActivityTypes(){
        return activityTypeService.getActivityTypes();
    }


}

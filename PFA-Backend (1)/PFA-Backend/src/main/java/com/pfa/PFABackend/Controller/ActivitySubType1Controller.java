package com.pfa.PFABackend.Controller;

import com.pfa.PFABackend.Model.ActivitySubType1;
import com.pfa.PFABackend.Service.ActivitySubType1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professorcommission")
public class ActivitySubType1Controller {
    @Autowired
    private ActivitySubType1Service activitySubType1Service;

    @PostMapping("/add-activity-subtype1")
    public String addActivitySubType1(@RequestBody ActivitySubType1 activitySubType1){
        activitySubType1Service.saveActivitySubType1(activitySubType1);
        return "new activitySubType1 added";
    }

    @GetMapping("/activity_subTypes1")
    public Iterable<ActivitySubType1> getActivityTypes1(){
        return activitySubType1Service.getActivitySubtypes1();
    }

}

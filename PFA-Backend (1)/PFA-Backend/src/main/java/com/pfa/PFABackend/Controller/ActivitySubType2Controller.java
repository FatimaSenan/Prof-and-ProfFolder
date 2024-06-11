package com.pfa.PFABackend.Controller;

import com.pfa.PFABackend.Model.ActivitySubType1;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Service.ActivitySubType1Service;
import com.pfa.PFABackend.Service.ActivitySubType2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professorcommission")
public class ActivitySubType2Controller {
    @Autowired
    private ActivitySubType2Service activitySubType2Service;

    @PostMapping("/add-activity-subtype2")
    public String addActivitySubType2(@RequestBody ActivitySubType2 activitySubType2){
        activitySubType2Service.saveActivitySubType2(activitySubType2);
        return "new activitySubType2 added";
    }

    @GetMapping("/activity_subTypes2")
    public Iterable<ActivitySubType2> getActivityTypes2(){
        return activitySubType2Service.getActivitySubtypes2();
    }
}

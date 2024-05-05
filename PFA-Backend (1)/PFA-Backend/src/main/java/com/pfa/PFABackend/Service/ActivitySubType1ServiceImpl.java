package com.pfa.PFABackend.Service;

import com.pfa.PFABackend.Model.ActivitySubType1;
import com.pfa.PFABackend.Repository.ActivitySubType1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivitySubType1ServiceImpl implements ActivitySubType1Service{
    @Autowired
    private ActivitySubType1Repository activitySubType1Repository;
    @Override
    public void saveActivitySubType1(ActivitySubType1 activitySubType1) {
        activitySubType1Repository.save(activitySubType1);
    }

    @Override
    public Iterable<ActivitySubType1> getActivitySubtypes1() {
        return activitySubType1Repository.findAll();
    }
}

package com.pfa.PFABackend.Service;

import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Repository.ActivitySubType2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivitySubType2ServiceImpl implements ActivitySubType2Service{
    @Autowired
    private ActivitySubType2Repository activitySubType2Repository;
    @Override
    public void saveActivitySubType2(ActivitySubType2 activitySubType2) {
        activitySubType2Repository.save(activitySubType2);
    }

    @Override
    public Iterable<ActivitySubType2> getActivitySubtypes2() {
        return activitySubType2Repository.findAll();
    }

    @Override
    public ActivitySubType2 findById(int id) {
        return activitySubType2Repository.findById(id).orElse(null);
    }
}

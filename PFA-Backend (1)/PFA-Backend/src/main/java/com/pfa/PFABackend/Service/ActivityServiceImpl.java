package com.pfa.PFABackend.Service;

import com.pfa.PFABackend.Model.Activity;
import com.pfa.PFABackend.Repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements ActivityService{
    @Autowired
    private ActivityRepository activityRepository;
    @Override
    public void saveActivity(Activity activity) {
        activityRepository.save(activity);
    }

    @Override
    public Iterable<Activity> getActivities() {
        return activityRepository.findAll();
    }
}

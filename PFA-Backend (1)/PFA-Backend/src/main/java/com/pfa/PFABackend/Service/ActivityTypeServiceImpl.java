package com.pfa.PFABackend.Service;

import com.pfa.PFABackend.Model.ActivityType;
import com.pfa.PFABackend.Repository.ActivityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityTypeServiceImpl implements ActivityTypeService{
    @Autowired
    private ActivityTypeRepository activityTypeRepository;
    @Override
    public void saveActivity(ActivityType activityType) {
        activityTypeRepository.save(activityType);
    }

    @Override
    public Iterable<ActivityType> getActivityTypes() {
        return activityTypeRepository.findAll();
    }
}

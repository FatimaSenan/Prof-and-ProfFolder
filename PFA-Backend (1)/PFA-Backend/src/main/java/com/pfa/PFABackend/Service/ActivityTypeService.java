package com.pfa.PFABackend.Service;

import com.pfa.PFABackend.Model.Activity;
import com.pfa.PFABackend.Model.ActivitySubType1;
import com.pfa.PFABackend.Model.ActivityType;

public interface ActivityTypeService {
    public void saveActivity(ActivityType activityType);
    public Iterable<ActivityType> getActivityTypes();
}

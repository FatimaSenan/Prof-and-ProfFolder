package com.pfa.PFABackend.Service;

import com.pfa.PFABackend.Model.ActivitySubType2;

public interface ActivitySubType2Service {
    public void saveActivitySubType2(ActivitySubType2 activitySubType2);
    public Iterable<ActivitySubType2> getActivitySubtypes2();

    public ActivitySubType2 findById(int id);
}

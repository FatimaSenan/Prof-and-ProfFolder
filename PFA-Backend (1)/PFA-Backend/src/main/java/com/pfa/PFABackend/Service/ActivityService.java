package com.pfa.PFABackend.Service;

import com.pfa.PFABackend.Model.Activity;

public interface ActivityService {
    public void saveActivity(Activity activity);
    public Iterable<Activity> getActivities();
}

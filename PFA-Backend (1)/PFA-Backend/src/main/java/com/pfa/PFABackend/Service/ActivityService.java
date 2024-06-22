package com.pfa.PFABackend.Service;

import com.pfa.PFABackend.Model.Activity;
import com.pfa.PFABackend.Model.User;

import java.util.List;
import java.util.Map;

public interface ActivityService {
   // public void saveActivity(Activity activity);
    //public Iterable<Activity> getActivities();
    public List<List<?>> getAllActivitiesForCurrentUser();

    public List<List<?>> getAllActivitiesForSelectedUser(String userEmail);

    public String deleteSelectedActivityForCurrentUser(String activityName, int activityId);

    public byte[] getJustificationPdf(String activityName, int activityId);
}

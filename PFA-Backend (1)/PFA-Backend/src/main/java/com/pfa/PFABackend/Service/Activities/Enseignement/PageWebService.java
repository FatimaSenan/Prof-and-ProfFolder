package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MOOC;
import com.pfa.PFABackend.Model.Activities.Enseignement.PageWeb;
import com.pfa.PFABackend.Model.ActivitySubType2;

import java.io.IOException;

public interface PageWebService {
    public void savePageWeb(ActivitySubType2 activitySubType2, String activityName, String lien) throws IOException;

    public Iterable<PageWeb> getPageWebs();
}

package com.pfa.PFABackend.Service.Activities.Recherche;


import com.pfa.PFABackend.Model.Activities.Recherche.ExpertiseNonRémunéré;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ExpertiseNonRémunéréService {
    public void saveExpertiseNonRémunéré(ActivitySubType2 activitySubType2, String activityName, String projet, String natureExpetise, int année,  MultipartFile file) throws IOException;

    public Iterable<ExpertiseNonRémunéré> getExpertiseNonRémunéré();
}

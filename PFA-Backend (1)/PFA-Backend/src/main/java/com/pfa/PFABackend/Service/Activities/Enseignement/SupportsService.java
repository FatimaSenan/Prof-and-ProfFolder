package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.Supports;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface SupportsService {
    public void saveSpports(ActivitySubType2 activitySubType2, String activityName, String typeSupport, String titre, String type, String module, int année, MultipartFile file) throws IOException;

    public Iterable<Supports> getSupports();
}

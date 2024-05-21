package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.Manuel;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ManuelService {

    public void saveManuel(ActivitySubType2 activitySubType2, String activityName, String module, String filièreNiveau, String annéesUniversitaires, MultipartFile file) throws IOException;

    public Iterable<Manuel> getManuels();
}

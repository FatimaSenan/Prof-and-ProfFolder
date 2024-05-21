package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.Didacticiels;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface DidacticielsService {

    public void saveDidacticiels(ActivitySubType2 activitySubType2, String activityName, String support, String module, int année, MultipartFile file) throws IOException;

    public Iterable<Didacticiels> getDidacticiels();
}

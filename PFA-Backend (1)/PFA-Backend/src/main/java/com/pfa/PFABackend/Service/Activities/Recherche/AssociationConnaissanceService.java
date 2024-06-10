package com.pfa.PFABackend.Service.Activities.Recherche;


import com.pfa.PFABackend.Model.Activities.Recherche.AssociationConnaissance;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AssociationConnaissanceService {
    public void saveAssociationConnaissance(ActivitySubType2 activitySubType2, String activityName, String responsabilité, String années,  MultipartFile file) throws IOException;

    public Iterable<AssociationConnaissance> getAssociationConnaissances();
}

package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.ChefDépartement;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.File;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ChefDépartementService {
    public void saveChefDépartement(ActivitySubType2 activitySubType2, String activityName, String typeFilière, String établisseent, String annéesResponsabilités, MultipartFile file) throws IOException;

    public Iterable<ChefDépartement> getChefDépartements();



}

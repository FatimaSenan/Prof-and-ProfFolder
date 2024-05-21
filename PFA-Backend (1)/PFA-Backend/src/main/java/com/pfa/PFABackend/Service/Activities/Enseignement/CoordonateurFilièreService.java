package com.pfa.PFABackend.Service.Activities.Enseignement;


import com.pfa.PFABackend.Model.Activities.Enseignement.CoordonateurFilière;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface CoordonateurFilièreService {

    public void saveCoordonateurFilière(ActivitySubType2 activitySubType2, String activityName, String typeFilière, String nomFilière, String établissement, String annéesResponsabilité, MultipartFile file) throws IOException;

    public Iterable<CoordonateurFilière> getCoordonateurFilières();


}

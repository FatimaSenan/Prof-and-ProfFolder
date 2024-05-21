package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.CoordonateurModule;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CoordonateurModuleService {

    public void saveCoordonateurModule(ActivitySubType2 activitySubType2, String activityName, String nomModule, String filière, String niveau, String departement, String etablissement, String annéesResponsabilités, MultipartFile file) throws IOException;

    public Iterable<CoordonateurModule> getCoordonateurModules();
}

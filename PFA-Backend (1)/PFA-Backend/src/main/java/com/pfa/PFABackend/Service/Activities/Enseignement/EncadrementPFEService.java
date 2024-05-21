package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.EncadrementPFE;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface EncadrementPFEService {

    public void saveEncadrementPFE(ActivitySubType2 activitySubType2, String activityName, String typeEncadrement, String titrePfe, String étudiants, int année, String filière, MultipartFile file) throws IOException;

    public Iterable<EncadrementPFE> getEncadrementPFEs();
}

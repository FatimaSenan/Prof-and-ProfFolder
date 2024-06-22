package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.EncadrementRH;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface EncadrementRHService {

    public void saveEncadrementRH(ActivitySubType2 activitySubType2, String activityName, String typeEncadrement, String titre, String membres, String dateDébut, String dateFin, MultipartFile file) throws IOException;

    public Iterable<EncadrementRH> getEncadrementRHs();
}

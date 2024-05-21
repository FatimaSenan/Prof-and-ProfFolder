package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MOOC;
import com.pfa.PFABackend.Model.Activities.Enseignement.ViceDoyen;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ViceDoyenService {

    public void saveViceDoyen(ActivitySubType2 activitySubType2, String activityName, String nomFonction,String établissement, String annéesResponsabilités, MultipartFile file) throws IOException;

    public Iterable<ViceDoyen> getVicesDoyens();
}

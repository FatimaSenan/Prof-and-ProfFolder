package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionAdHoc;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface MembreCommissionAdHocService {

    public void saveMembreCommissionAdHoc(ActivitySubType2 activitySubType2, String activityName, String typeCommissionAdHoc, int année, MultipartFile file) throws IOException;

    public Iterable<MembreCommissionAdHoc> getMembreCommissionAdHocs();
}

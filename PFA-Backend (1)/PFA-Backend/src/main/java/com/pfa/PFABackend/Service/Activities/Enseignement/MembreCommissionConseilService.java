package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface MembreCommissionConseilService {

    public void saveMembreCommissionConseil(ActivitySubType2 activitySubType2, String activityName, String titreConseil, String période, MultipartFile file) throws IOException;

    public Iterable<MembreCommissionConseil> getMembreCommissionConseils();
}

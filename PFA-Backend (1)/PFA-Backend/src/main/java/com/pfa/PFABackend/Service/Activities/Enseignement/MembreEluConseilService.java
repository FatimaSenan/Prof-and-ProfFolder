package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionEtablissement;
import com.pfa.PFABackend.Model.Activities.Enseignement.MembreEluConseil;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface MembreEluConseilService {
    public void saveMembreEluConseil(ActivitySubType2 activitySubType2, String activityName, String membreConseil, String période, MultipartFile file)throws IOException;

    public Iterable<MembreEluConseil> getMembreEluConseils();
}

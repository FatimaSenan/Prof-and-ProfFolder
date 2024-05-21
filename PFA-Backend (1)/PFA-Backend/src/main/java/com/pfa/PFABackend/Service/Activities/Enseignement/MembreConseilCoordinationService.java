package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionEtablissement;
import com.pfa.PFABackend.Model.Activities.Enseignement.MembreConseilCoordination;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface MembreConseilCoordinationService {

    public void saveMembreConseilCoordination(ActivitySubType2 activitySubType2, String activityName, String titreConseil, String période, MultipartFile file) throws IOException;

    public Iterable<MembreConseilCoordination> getMembreConseilsCoordinations();

}

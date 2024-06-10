package com.pfa.PFABackend.Service.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.CréationStartUp;
import com.pfa.PFABackend.Model.Activities.Recherche.DoctoratsEncadrés;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface DoctoratsEncadrésService {
    public void saveDoctoratsEncadrés(ActivitySubType2 activitySubType2, String activityName, String inscription, String sujet, String formationDOctorale, String laboratoire, String doctorant, String directeurThèse, String dateSoutenance , MultipartFile file) throws IOException;

    public Iterable<DoctoratsEncadrés> getDoctoratsEncadrés();
}

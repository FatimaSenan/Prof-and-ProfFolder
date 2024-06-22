package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MOOC;
import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionEtablissement;
import com.pfa.PFABackend.Model.ActivitySubType2;

import java.io.IOException;

public interface MOOCService {
    public void saveMOOC(ActivitySubType2 activitySubType2, String activityName, String titreMooc, String datePublication, String lien) throws IOException;

    public Iterable<MOOC> getMoocs();
}

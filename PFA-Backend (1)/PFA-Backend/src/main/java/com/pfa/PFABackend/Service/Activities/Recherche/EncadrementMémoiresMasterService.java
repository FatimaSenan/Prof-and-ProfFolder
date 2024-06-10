package com.pfa.PFABackend.Service.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.EditeurMembreRéféréJournalRevue;
import com.pfa.PFABackend.Model.Activities.Recherche.EncadrementMémoiresMaster;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface EncadrementMémoiresMasterService {
    public void saveEncadrementMémoiresMaster(ActivitySubType2 activitySubType2, String activityName, String sujetMaster, String étudiants, int année,String encadrant, MultipartFile file) throws IOException;

    public Iterable<EncadrementMémoiresMaster> getEncadrementMémoiresMaster();
}

package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionEtablissement;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface MembreCommissionEtablissementService {

    public void saveMembreCommissionEtablissement(ActivitySubType2 activitySubType2, String activityName, String titreCommission, String typeCommission, String période, MultipartFile file)throws IOException;

    public Iterable<MembreCommissionEtablissement> getMembreCommissionsEtablisements();
}

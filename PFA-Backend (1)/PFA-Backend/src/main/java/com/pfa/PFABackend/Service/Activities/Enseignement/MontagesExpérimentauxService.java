package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionEtablissement;
import com.pfa.PFABackend.Model.Activities.Enseignement.MontagesExpérimentaux;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface MontagesExpérimentauxService {
    public void saveMontagesExpérimentaux(ActivitySubType2 activitySubType2, String activityName, String module, String filière, int nombreManip, MultipartFile file) throws IOException;

    public Iterable<MontagesExpérimentaux> getMontagesExpérimentaux();
}

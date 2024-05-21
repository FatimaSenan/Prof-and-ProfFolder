package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MOOC;
import com.pfa.PFABackend.Model.Activities.Enseignement.PetitsLivres;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PetitsLivresService {
    public void savePetitsLivres(ActivitySubType2 activitySubType2, String activityName, String titreLivre, String auteurs, int annéePublication, MultipartFile file) throws IOException;

    public Iterable<PetitsLivres> getPetitsLivres();
}

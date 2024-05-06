package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MOOC;
import com.pfa.PFABackend.Model.Activities.Enseignement.PetitsLivres;

public interface PetitsLivresService {
    public void saveMPetitsLivres(PetitsLivres petitsLivres);

    public Iterable<PetitsLivres> getPetitsLivres();
}

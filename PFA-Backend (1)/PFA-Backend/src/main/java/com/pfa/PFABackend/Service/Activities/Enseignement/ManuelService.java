package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.Manuel;

public interface ManuelService {

    public void saveManuel(Manuel manuel);

    public Iterable<Manuel> getManuels();
}

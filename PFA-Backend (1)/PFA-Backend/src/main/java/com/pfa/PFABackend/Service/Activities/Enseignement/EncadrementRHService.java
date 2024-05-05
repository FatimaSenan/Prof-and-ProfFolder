package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.EncadrementRH;

public interface EncadrementRHService {

    public void saveEncadrementRH(EncadrementRH encadrementRH);

    public Iterable<EncadrementRH> getEncadrementRHs();
}

package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.EncadrementPFE;

public interface EncadrementPFEService {

    public void saveEncadrementPFE(EncadrementPFE encadrementPFE);

    public Iterable<EncadrementPFE> getEncadrementPFEs();
}

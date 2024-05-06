package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MOOC;
import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionEtablissement;

public interface MOOCService {
    public void saveMOOC(MOOC mooc);

    public Iterable<MOOC> getMoocs();
}

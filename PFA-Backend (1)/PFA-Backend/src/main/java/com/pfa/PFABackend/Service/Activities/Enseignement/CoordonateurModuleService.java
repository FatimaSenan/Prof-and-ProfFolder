package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.CoordonateurModule;

public interface CoordonateurModuleService {

    public void saveCoordonateurModule(CoordonateurModule coordonateurModule);

    public Iterable<CoordonateurModule> getCoordonateurModules();
}

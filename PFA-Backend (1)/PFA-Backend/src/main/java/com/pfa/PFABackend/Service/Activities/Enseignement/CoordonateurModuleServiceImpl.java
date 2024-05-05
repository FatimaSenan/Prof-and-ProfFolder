package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.CoordonateurModule;
import com.pfa.PFABackend.Repository.Activities.Enseignement.CoordonateurModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordonateurModuleServiceImpl implements CoordonateurModuleService{
    @Autowired
    private CoordonateurModuleRepository coordonateurModuleRepository;
    @Override
    public void saveCoordonateurModule(CoordonateurModule coordonateurModule) {
        coordonateurModuleRepository.save(coordonateurModule);
    }

    @Override
    public Iterable<CoordonateurModule> getCoordonateurModules() {
        return coordonateurModuleRepository.findAll();
    }
}

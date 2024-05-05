package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.EncadrementPFE;
import com.pfa.PFABackend.Repository.Activities.Enseignement.EncadrementPFERepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncadrementPFEServiceImpl implements EncadrementPFEService{
    @Autowired
    private EncadrementPFERepository encadrementPFERepository;
    @Override
    public void saveEncadrementPFE(EncadrementPFE encadrementPFE) {
        encadrementPFERepository.save(encadrementPFE);
    }

    @Override
    public Iterable<EncadrementPFE> getEncadrementPFEs() {
        return encadrementPFERepository.findAll();
    }
}

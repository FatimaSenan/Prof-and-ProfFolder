package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.EncadrementRH;
import com.pfa.PFABackend.Repository.Activities.Enseignement.EncadrementRHRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncadrementRHServiceImpl implements  EncadrementRHService{
    @Autowired
    private EncadrementRHRepository encadrementRHRepository;
    @Override
    public void saveEncadrementRH(EncadrementRH encadrementRH) {
        encadrementRHRepository.save(encadrementRH);
    }

    @Override
    public Iterable<EncadrementRH> getEncadrementRHs() {
        return encadrementRHRepository.findAll();
    }
}

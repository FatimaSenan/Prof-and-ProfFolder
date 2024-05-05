package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionAdHoc;
import com.pfa.PFABackend.Repository.Activities.Enseignement.MembreCommissionAdHocRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembreCommissionAdHocServiceImpl implements MembreCommissionAdHocService{
    @Autowired
    private MembreCommissionAdHocRepository membreCommissionAdHocRepository;
    @Override
    public void saveMembreCommissionAdHoc(MembreCommissionAdHoc membreCommissionAdHoc) {
        membreCommissionAdHocRepository.save(membreCommissionAdHoc);
    }

    @Override
    public Iterable<MembreCommissionAdHoc> getMembreCommissionAdHocs() {
        return membreCommissionAdHocRepository.findAll();
    }
}

package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionEtablissement;
import com.pfa.PFABackend.Repository.Activities.Enseignement.MembreCommisionEtablissementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembreCommissionEtablissementServiceImpl implements MembreCommissionEtablissementService {
    @Autowired
    private MembreCommisionEtablissementRepository membreCommisionEtablissementRepository;
    @Override
    public void saveMembreCommissionEtablissement(MembreCommissionEtablissement membreCommissionEtablissement) {
        membreCommisionEtablissementRepository.save(membreCommissionEtablissement);

    }

    @Override
    public Iterable<MembreCommissionEtablissement> getMembreCommissionsEtablisements() {
        return membreCommisionEtablissementRepository.findAll();
    }
}

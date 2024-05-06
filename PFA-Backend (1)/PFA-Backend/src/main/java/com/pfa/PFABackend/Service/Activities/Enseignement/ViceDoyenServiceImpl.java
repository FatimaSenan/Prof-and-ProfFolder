package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.ViceDoyen;
import com.pfa.PFABackend.Repository.Activities.Enseignement.ViceDoyenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViceDoyenServiceImpl implements ViceDoyenService{
    @Autowired
    private ViceDoyenRepository viceDoyenRepository;
    @Override
    public void saveViceDoyen(ViceDoyen viceDoyen) {
        viceDoyenRepository.save(viceDoyen);
    }

    @Override
    public Iterable<ViceDoyen> getVicesDoyens() {
        return viceDoyenRepository.findAll();
    }
}

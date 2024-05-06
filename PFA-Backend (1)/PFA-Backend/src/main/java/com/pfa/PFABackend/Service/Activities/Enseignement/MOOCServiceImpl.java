package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MOOC;
import com.pfa.PFABackend.Repository.Activities.Enseignement.MOOCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MOOCServiceImpl implements MOOCService{
    @Autowired
    private MOOCRepository moocRepository;
    @Override
    public void saveMOOC(MOOC mooc) {
        moocRepository.save(mooc);
    }

    @Override
    public Iterable<MOOC> getMoocs() {
        return moocRepository.findAll();
    }
}

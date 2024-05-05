package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.Didacticiels;
import com.pfa.PFABackend.Repository.Activities.Enseignement.DidacticielsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DidacticielsServiceImpl implements DidacticielsService{

    @Autowired
    private DidacticielsRepository didacticielsRepository;
    @Override
    public void saveDidacticiels(Didacticiels didacticiels) {
        didacticielsRepository.save(didacticiels);
    }

    @Override
    public Iterable<Didacticiels> getDidacticiels() {
        return didacticielsRepository.findAll();
    }
}

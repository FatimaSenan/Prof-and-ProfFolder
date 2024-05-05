package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.Manuel;
import com.pfa.PFABackend.Repository.Activities.Enseignement.ManuelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManuelServiceImpl implements  ManuelService{
    @Autowired
    private ManuelRepository manuelRepository;
    @Override
    public void saveManuel(Manuel manuel) {
        manuelRepository.save(manuel);
    }

    @Override
    public Iterable<Manuel> getManuels() {
        return manuelRepository.findAll();
    }
}

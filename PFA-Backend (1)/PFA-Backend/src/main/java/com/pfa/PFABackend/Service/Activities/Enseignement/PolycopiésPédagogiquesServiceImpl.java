package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.PolycopiésPédagogiques;
import com.pfa.PFABackend.Repository.Activities.Enseignement.PolycopiésPédagogiquesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolycopiésPédagogiquesServiceImpl implements PolycopiésPédagogiquesService{
    @Autowired
    private PolycopiésPédagogiquesRepository polycopiésPédagogiquesRepository;
    @Override
    public void savePolycopiésPédagogiques(PolycopiésPédagogiques polycopiésPédagogiques) {
        polycopiésPédagogiquesRepository.save(polycopiésPédagogiques);
    }

    @Override
    public Iterable<PolycopiésPédagogiques> getPolycopiésPédagogiques() {
        return polycopiésPédagogiquesRepository.findAll();
    }
}

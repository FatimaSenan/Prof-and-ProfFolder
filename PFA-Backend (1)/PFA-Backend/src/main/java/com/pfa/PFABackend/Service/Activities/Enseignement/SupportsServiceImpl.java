package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.pfa.PFABackend.Model.Activities.Enseignement.Supports;
import com.pfa.PFABackend.Repository.Activities.Enseignement.SupportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupportsServiceImpl implements SupportsService{
    @Autowired
    private SupportsRepository supportsRepository;
    @Override
    public void saveSpports(Supports supports) {
        supportsRepository.save(supports);
    }

    @Override
    public Iterable<Supports> getSupports() {
        return supportsRepository.findAll();
    }
}

package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.Ouvrage;
import com.pfa.PFABackend.Repository.Activities.Enseignement.OuvrageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OuvrageServiceImpl implements OuvrageService{
    @Autowired
    private OuvrageRepository ouvrageRepository;
    @Override
    public void saveOuvrage(Ouvrage ouvrage) {
        ouvrageRepository.save(ouvrage);
    }

    @Override
    public Iterable<Ouvrage> getOuvrages() {
        return ouvrageRepository.findAll();
    }
}

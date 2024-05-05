package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.CoordonateurFilière;
import com.pfa.PFABackend.Repository.Activities.Enseignement.CoordonateurFilièreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordonateurFilièreServiceImpl implements CoordonateurFilièreService{

    @Autowired
    private CoordonateurFilièreRepository coordonateurFilièreRepository;
    @Override
    public void saveCoordonateurFilière(CoordonateurFilière coordonateurFilière) {
        coordonateurFilièreRepository.save(coordonateurFilière);
    }

    @Override
    public Iterable<CoordonateurFilière> getCoordonateurFilières() {
        return coordonateurFilièreRepository.findAll();
    }
}

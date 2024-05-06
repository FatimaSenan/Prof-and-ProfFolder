package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.PetitsLivres;
import com.pfa.PFABackend.Repository.Activities.Enseignement.PetitsLivresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetitsLivresServiceImpl implements PetitsLivresService{
    @Autowired
    private PetitsLivresRepository petitsLivresRepository;
    @Override
    public void saveMPetitsLivres(PetitsLivres petitsLivres) {
        petitsLivresRepository.save(petitsLivres);
    }

    @Override
    public Iterable<PetitsLivres> getPetitsLivres() {
        return petitsLivresRepository.findAll();
    }
}

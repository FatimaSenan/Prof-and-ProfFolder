package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.ChefDépartement;
import com.pfa.PFABackend.Repository.Activities.Enseignement.ChefDépartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChefDépartementServiceImpl implements ChefDépartementService{
    @Autowired
    private ChefDépartementRepository chefDépartementRepository;

    @Override
    public void saveChefDépartement(ChefDépartement chefDépartement) {
        chefDépartementRepository.save(chefDépartement);
    }

    @Override
    public Iterable<ChefDépartement> getChefDépartements() {
        return chefDépartementRepository.findAll();
    }
}

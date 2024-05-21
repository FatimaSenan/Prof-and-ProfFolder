package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.PetitsLivres;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Repository.Activities.Enseignement.PetitsLivresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PetitsLivresServiceImpl implements PetitsLivresService{
    @Autowired
    private PetitsLivresRepository petitsLivresRepository;


    @Override
    public void savePetitsLivres(ActivitySubType2 activitySubType2, String activityName, String titreLivre, String auteurs, int annéePublication, MultipartFile file) throws IOException {
        PetitsLivres petitsLivres = new PetitsLivres();
        petitsLivres.setActivitySubType2(activitySubType2);
        petitsLivres.setActivityName(activityName);
        petitsLivres.setTitreLivre(titreLivre);
        petitsLivres.setAuteurs(auteurs);
        petitsLivres.setAnnéePublication(annéePublication);
        petitsLivres.setJustification(file.getBytes());

        petitsLivresRepository.save(petitsLivres);
    }

    @Override
    public Iterable<PetitsLivres> getPetitsLivres() {
        return petitsLivresRepository.findAll();
    }
}

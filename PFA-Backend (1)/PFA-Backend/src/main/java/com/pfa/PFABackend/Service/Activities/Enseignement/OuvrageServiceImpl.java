package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.Ouvrage;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Repository.Activities.Enseignement.OuvrageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class OuvrageServiceImpl implements OuvrageService{
    @Autowired
    private OuvrageRepository ouvrageRepository;

    @Override
    public void saveOuvrage(ActivitySubType2 activitySubType2, String activityName, String titreOuvrage, String auteurs, String isbn, String depotLegal, String maisonEdition, int annéePublication, MultipartFile file) throws IOException {
        Ouvrage ouvrage = new Ouvrage();
        ouvrage.setActivitySubType2(activitySubType2);
        ouvrage.setActivityName(activityName);
        ouvrage.setTitreOuvrage(titreOuvrage);
        ouvrage.setAuteurs(auteurs);
        ouvrage.setIsbn(isbn);
        ouvrage.setDepotLegal(depotLegal);
        ouvrage.setMaisonEdition(maisonEdition);
        ouvrage.setAnnéePublication(annéePublication);
        ouvrage.setJustification(file.getBytes());

        ouvrageRepository.save(ouvrage);
    }

    @Override
    public Iterable<Ouvrage> getOuvrages() {
        return ouvrageRepository.findAll();
    }
}

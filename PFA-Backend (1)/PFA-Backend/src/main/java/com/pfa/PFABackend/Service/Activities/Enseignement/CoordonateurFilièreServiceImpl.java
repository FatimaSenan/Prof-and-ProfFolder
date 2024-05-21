package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.CoordonateurFilière;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Repository.Activities.Enseignement.CoordonateurFilièreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class CoordonateurFilièreServiceImpl implements CoordonateurFilièreService{

    @Autowired
    private CoordonateurFilièreRepository coordonateurFilièreRepository;


    @Override
    public void saveCoordonateurFilière(ActivitySubType2 activitySubType2, String activityName, String typeFilière,String nomFilière, String établissement, String annéesResponsabilité, MultipartFile file) throws IOException {
        CoordonateurFilière coordonateurFilière = new CoordonateurFilière();
        coordonateurFilière.setActivitySubType2(activitySubType2);
        coordonateurFilière.setActivityName(activityName);
        coordonateurFilière.setTypeFilière(typeFilière);
        coordonateurFilière.setEtablissement(établissement);
        coordonateurFilière.setAnnéesResposabilités(annéesResponsabilité);
        coordonateurFilière.setJustification(file.getBytes());
        coordonateurFilièreRepository.save(coordonateurFilière);
    }

    @Override
    public Iterable<CoordonateurFilière> getCoordonateurFilières() {
        return coordonateurFilièreRepository.findAll();
    }
}

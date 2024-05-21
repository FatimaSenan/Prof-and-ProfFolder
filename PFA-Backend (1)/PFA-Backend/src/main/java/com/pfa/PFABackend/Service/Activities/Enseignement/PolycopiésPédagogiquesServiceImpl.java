package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.PolycopiésPédagogiques;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Repository.Activities.Enseignement.PolycopiésPédagogiquesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PolycopiésPédagogiquesServiceImpl implements PolycopiésPédagogiquesService{
    @Autowired
    private PolycopiésPédagogiquesRepository polycopiésPédagogiquesRepository;


    @Override
    public void savePolycopiésPédagogiques(ActivitySubType2 activitySubType2, String activityName, String module, String filièreNiveau, String annéesUniversitaires, MultipartFile file) throws IOException {
        PolycopiésPédagogiques polycopiésPédagogiques = new PolycopiésPédagogiques();
        polycopiésPédagogiques.setActivitySubType2(activitySubType2);
        polycopiésPédagogiques.setActivityName(activityName);
        polycopiésPédagogiques.setModule(module);
        polycopiésPédagogiques.setFilièreNiveau(filièreNiveau);
        polycopiésPédagogiques.setAnnéesUniversitaires(annéesUniversitaires);
        polycopiésPédagogiques.setJustification(file.getBytes());
    }

    @Override
    public Iterable<PolycopiésPédagogiques> getPolycopiésPédagogiques() {
        return polycopiésPédagogiquesRepository.findAll();
    }
}

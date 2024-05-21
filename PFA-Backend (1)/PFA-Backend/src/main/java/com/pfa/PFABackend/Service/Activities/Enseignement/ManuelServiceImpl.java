package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.Manuel;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Repository.Activities.Enseignement.ManuelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ManuelServiceImpl implements  ManuelService{
    @Autowired
    private ManuelRepository manuelRepository;


    @Override
    public void saveManuel(ActivitySubType2 activitySubType2, String activityName, String module, String filièreNiveau, String annéesUniversitaires, MultipartFile file) throws IOException {
        Manuel manuel = new Manuel();
        manuel.setActivitySubType2(activitySubType2);
        manuel.setActivityName(activityName);
        manuel.setModule(module);
        manuel.setFilièreNiveau(filièreNiveau);
        manuel.setAnnéesUniversitaires(annéesUniversitaires);
        manuel.setJustification(file.getBytes());

        manuelRepository.save(manuel);
    }

    @Override
    public Iterable<Manuel> getManuels() {
        return manuelRepository.findAll();
    }
}

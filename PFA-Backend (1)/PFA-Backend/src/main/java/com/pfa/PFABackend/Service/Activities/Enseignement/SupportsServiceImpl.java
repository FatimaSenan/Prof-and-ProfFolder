package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.pfa.PFABackend.Model.Activities.Enseignement.Supports;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Repository.Activities.Enseignement.SupportsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class SupportsServiceImpl implements SupportsService{
    @Autowired
    private SupportsRepository supportsRepository;


    @Override
    public void saveSpports(ActivitySubType2 activitySubType2, String activityName, String typeSupport, String titre, String type, String module, int année, MultipartFile file) throws IOException {
        Supports supports = new Supports();
        supports.setActivitySubType2(activitySubType2);
        supports.setActivityName(activityName);
        supports.setTypeSupport(typeSupport);
        supports.setTitre(titre);
        supports.setType(type);
        supports.setModule(module);
        supports.setAnnée(année);
        supports.setJustification(file.getBytes());

    }

    @Override
    public Iterable<Supports> getSupports() {
        return supportsRepository.findAll();
    }
}

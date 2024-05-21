package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MOOC;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Repository.Activities.Enseignement.MOOCRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MOOCServiceImpl implements MOOCService{
    @Autowired
    private MOOCRepository moocRepository;


    @Override
    public void saveMOOC(ActivitySubType2 activitySubType2, String activityName, String titreMooc, int datePublication, String lien) throws IOException {
        MOOC mooc = new MOOC();
        mooc.setActivitySubType2(activitySubType2);
        mooc.setActivityName(activityName);
        mooc.setTitreMooc(titreMooc);
        mooc.setDatePublication(datePublication);
        mooc.setLien(lien);

        moocRepository.save(mooc);
    }

    @Override
    public Iterable<MOOC> getMoocs() {
        return moocRepository.findAll();
    }
}

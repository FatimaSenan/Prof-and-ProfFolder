package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.ViceDoyen;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Repository.Activities.Enseignement.ViceDoyenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ViceDoyenServiceImpl implements ViceDoyenService{
    @Autowired
    private ViceDoyenRepository viceDoyenRepository;


    @Override
    public void saveViceDoyen(ActivitySubType2 activitySubType2, String activityName, String nomFonction,String établissement, String annéesResponsabilités, MultipartFile file) throws IOException {
        ViceDoyen viceDoyen = new ViceDoyen();
        viceDoyen.setActivitySubType2(activitySubType2);
        viceDoyen.setActivityName(activityName);
        viceDoyen.setNomFonction(nomFonction);
        viceDoyen.setÉtablissement(établissement);
        viceDoyen.setAnnéesResposabilité(annéesResponsabilités);
        viceDoyen.setJustification(file.getBytes());
        viceDoyenRepository.save(viceDoyen);
    }

    @Override
    public Iterable<ViceDoyen> getVicesDoyens() {
        return viceDoyenRepository.findAll();
    }
}

package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionEtablissement;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Repository.Activities.Enseignement.MembreCommisionEtablissementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class MembreCommissionEtablissementServiceImpl implements MembreCommissionEtablissementService {
    @Autowired
    private MembreCommisionEtablissementRepository membreCommisionEtablissementRepository;


    @Override
    public void saveMembreCommissionEtablissement(ActivitySubType2 activitySubType2, String activityName, String titreCommission, String typeCommission, String période, MultipartFile file) throws IOException {
       MembreCommissionEtablissement membreCommissionEtablissement = new MembreCommissionEtablissement();
       membreCommissionEtablissement.setActivitySubType2(activitySubType2);
       membreCommissionEtablissement.setActivityName(activityName);
       membreCommissionEtablissement.setTitreCommission(titreCommission);
       membreCommissionEtablissement.setTypeCommission(typeCommission);
       membreCommissionEtablissement.setPériode(période);
       membreCommissionEtablissement.setJustification(file.getBytes());
        membreCommisionEtablissementRepository.save(membreCommissionEtablissement);
    }

    @Override
    public Iterable<MembreCommissionEtablissement> getMembreCommissionsEtablisements() {
        return membreCommisionEtablissementRepository.findAll();
    }
}

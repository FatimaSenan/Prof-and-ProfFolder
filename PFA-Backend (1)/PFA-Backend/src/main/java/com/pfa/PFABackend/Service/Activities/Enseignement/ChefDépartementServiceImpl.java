package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.ChefDépartement;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.File;
import com.pfa.PFABackend.Repository.Activities.Enseignement.ChefDépartementRepository;
import com.pfa.PFABackend.Service.FileService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ChefDépartementServiceImpl implements ChefDépartementService{
    @Autowired
    private ChefDépartementRepository chefDépartementRepository;




    @Override
    public void saveChefDépartement(ActivitySubType2 activitySubType2,String activityName, String département, String établissement, String annéesResponsabilité, MultipartFile file) throws IOException {
        ChefDépartement chefDépartement = new ChefDépartement();
        chefDépartement.setActivitySubType2(activitySubType2);
        chefDépartement.setActivityName(activityName);
        chefDépartement.setDépartement(département);
        chefDépartement.setÉtablissement(établissement);
        chefDépartement.setAnnéesResposabilité(annéesResponsabilité);
        chefDépartement.setJustification(file.getBytes());
        chefDépartementRepository.save(chefDépartement);
        /*File savedFile = fileService.store(file);
        chefDépartement.setFile(savedFile);
        chefDépartementRepository.save(chefDépartement);*/
    }

    @Override
    public Iterable<ChefDépartement> getChefDépartements() {
        return chefDépartementRepository.findAll();
    }



}

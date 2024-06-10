package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.ChefDépartement;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.File;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Enseignement.ChefDépartementRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import com.pfa.PFABackend.Service.FileService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ChefDépartementServiceImpl implements ChefDépartementService{
    private static final Logger logger = LoggerFactory.getLogger(ChefDépartementServiceImpl.class);
    @Autowired
    private ChefDépartementRepository chefDépartementRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public void saveChefDépartement(ActivitySubType2 activitySubType2,String activityName, String département, String établissement, String annéesResponsabilité, MultipartFile file) throws IOException {
        ChefDépartement chefDépartement = new ChefDépartement();
        chefDépartement.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        logger.info("Authenticated user email: {}", userEmail);
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        chefDépartement.setActivityName(activityName);
        chefDépartement.setDépartement(département);
        chefDépartement.setÉtablissement(établissement);
        chefDépartement.setAnnéesResposabilité(annéesResponsabilité);
        chefDépartement.setJustification(file.getBytes());
        chefDépartement.setUser(user);
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

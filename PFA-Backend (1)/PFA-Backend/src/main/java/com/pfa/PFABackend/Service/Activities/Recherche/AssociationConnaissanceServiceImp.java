package com.pfa.PFABackend.Service.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.AssociationConnaissance;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Recherche.AssociationConnaissanceRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Service
public class AssociationConnaissanceServiceImp implements AssociationConnaissanceService{
    @Autowired
    private AssociationConnaissanceRepository associationConnaissanceRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public void saveAssociationConnaissance(ActivitySubType2 activitySubType2, String activityName, String responsabilité, String années, MultipartFile file) throws IOException {
    AssociationConnaissance associationConnaissance = new AssociationConnaissance();
    associationConnaissance.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        associationConnaissance.setActivityName(activityName);
        associationConnaissance.setResponsabilité(responsabilité);
        associationConnaissance.setAnnées(années);
        associationConnaissance.setJustification(file.getBytes());
        associationConnaissance.setUser(user);
        associationConnaissanceRepository.save(associationConnaissance);
    }

    @Override
    public Iterable<AssociationConnaissance> getAssociationConnaissances() {
        return associationConnaissanceRepository.findAll();
    }
}

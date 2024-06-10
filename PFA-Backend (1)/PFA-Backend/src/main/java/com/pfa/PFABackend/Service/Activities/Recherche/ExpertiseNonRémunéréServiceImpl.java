package com.pfa.PFABackend.Service.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.ExpertiseNonRémunéré;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Recherche.ExpertiseNonRémunéréRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Service
public class ExpertiseNonRémunéréServiceImpl implements ExpertiseNonRémunéréService{

    @Autowired
    private ExpertiseNonRémunéréRepository expertiseNonRémunéréRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveExpertiseNonRémunéré(ActivitySubType2 activitySubType2, String activityName, String projet, String natureExpetise, int année, MultipartFile file) throws IOException {
        ExpertiseNonRémunéré expertiseNonRémunéré = new ExpertiseNonRémunéré();
        expertiseNonRémunéré.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        expertiseNonRémunéré.setActivityName(activityName);
        expertiseNonRémunéré.setProjet(projet);
        expertiseNonRémunéré.setNatureExpertise(natureExpetise);
        expertiseNonRémunéré.setAnnée(année);
        expertiseNonRémunéré.setJustification(file.getBytes());
        expertiseNonRémunéré.setUser(user);
        expertiseNonRémunéréRepository.save(expertiseNonRémunéré);
    }

    @Override
    public Iterable<ExpertiseNonRémunéré> getExpertiseNonRémunéré() {
        return expertiseNonRémunéréRepository.findAll();
    }
}

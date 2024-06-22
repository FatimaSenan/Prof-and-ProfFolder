package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MOOC;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Enseignement.MOOCRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MOOCServiceImpl implements MOOCService{
    @Autowired
    private MOOCRepository moocRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveMOOC(ActivitySubType2 activitySubType2, String activityName, String titreMooc, String datePublication, String lien) throws IOException {
        MOOC mooc = new MOOC();
        mooc.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        mooc.setActivityName(activityName);
        mooc.setTitreMooc(titreMooc);
        mooc.setDatePublication(datePublication);
        mooc.setLien(lien);
        mooc.setUser(user);
        moocRepository.save(mooc);
    }

    @Override
    public Iterable<MOOC> getMoocs() {
        return moocRepository.findAll();
    }
}

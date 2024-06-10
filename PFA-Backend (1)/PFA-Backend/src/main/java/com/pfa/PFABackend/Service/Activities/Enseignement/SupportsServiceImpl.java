package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.pfa.PFABackend.Model.Activities.Enseignement.Supports;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Enseignement.SupportsRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class SupportsServiceImpl implements SupportsService{
    @Autowired
    private SupportsRepository supportsRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public void saveSpports(ActivitySubType2 activitySubType2, String activityName, String typeSupport, String titre, String type, String module, int année, MultipartFile file) throws IOException {
        Supports supports = new Supports();
        supports.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        supports.setActivityName(activityName);
        supports.setTypeSupport(typeSupport);
        supports.setTitre(titre);
        supports.setType(type);
        supports.setModule(module);
        supports.setAnnée(année);
        supports.setJustification(file.getBytes());
        supports.setUser(user);
        supportsRepository.save(supports);

    }

    @Override
    public Iterable<Supports> getSupports() {
        return supportsRepository.findAll();
    }
}

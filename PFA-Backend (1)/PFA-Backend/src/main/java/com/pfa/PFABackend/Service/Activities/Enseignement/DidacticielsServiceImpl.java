package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.Didacticiels;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Enseignement.DidacticielsRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DidacticielsServiceImpl implements DidacticielsService{

    @Autowired
    private DidacticielsRepository didacticielsRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveDidacticiels(ActivitySubType2 activitySubType2, String activityName, String support, String module, int année, MultipartFile file) throws IOException {
        Didacticiels didacticiels = new Didacticiels();
        didacticiels.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();


        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        didacticiels.setActivityName(activityName);
        didacticiels.setSupport(support);
        didacticiels.setModule(module);
        didacticiels.setAnnée(année);
        didacticiels.setUser(user);
        didacticiels.setJustification(file.getBytes());

        didacticielsRepository.save(didacticiels);
    }

    @Override
    public Iterable<Didacticiels> getDidacticiels() {
        return didacticielsRepository.findAll();
    }
}

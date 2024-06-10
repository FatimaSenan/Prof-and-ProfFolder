package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionAdHoc;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Enseignement.MembreCommissionAdHocRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class MembreCommissionAdHocServiceImpl implements MembreCommissionAdHocService{
    @Autowired
    private MembreCommissionAdHocRepository membreCommissionAdHocRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public void saveMembreCommissionAdHoc(ActivitySubType2 activitySubType2, String activityName, String typeCommissionAdHoc, int année, MultipartFile file) throws IOException {
        MembreCommissionAdHoc membreCommissionAdHoc = new MembreCommissionAdHoc();
        membreCommissionAdHoc.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        membreCommissionAdHoc.setActivityName(activityName);
        membreCommissionAdHoc.setTypeCommissionAdHoc(typeCommissionAdHoc);
        membreCommissionAdHoc.setAnnée(année);
        membreCommissionAdHoc.setJustification(file.getBytes());
        membreCommissionAdHoc.setUser(user);
        membreCommissionAdHocRepository.save(membreCommissionAdHoc);

    }

    @Override
    public Iterable<MembreCommissionAdHoc> getMembreCommissionAdHocs() {
        return membreCommissionAdHocRepository.findAll();
    }
}

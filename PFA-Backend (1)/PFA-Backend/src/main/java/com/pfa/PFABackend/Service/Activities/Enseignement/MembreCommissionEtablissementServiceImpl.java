package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionEtablissement;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Enseignement.MembreCommisionEtablissementRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class MembreCommissionEtablissementServiceImpl implements MembreCommissionEtablissementService {
    @Autowired
    private MembreCommisionEtablissementRepository membreCommisionEtablissementRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveMembreCommissionEtablissement(ActivitySubType2 activitySubType2, String activityName, String titreCommission, String typeCommission, String période, MultipartFile file) throws IOException {
       MembreCommissionEtablissement membreCommissionEtablissement = new MembreCommissionEtablissement();
       membreCommissionEtablissement.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
       membreCommissionEtablissement.setActivityName(activityName);
       membreCommissionEtablissement.setTitreCommission(titreCommission);
       membreCommissionEtablissement.setTypeCommission(typeCommission);
       membreCommissionEtablissement.setPériode(période);
       membreCommissionEtablissement.setJustification(file.getBytes());
       membreCommissionEtablissement.setUser(user);
        membreCommisionEtablissementRepository.save(membreCommissionEtablissement);
    }

    @Override
    public Iterable<MembreCommissionEtablissement> getMembreCommissionsEtablisements() {
        return membreCommisionEtablissementRepository.findAll();
    }
}

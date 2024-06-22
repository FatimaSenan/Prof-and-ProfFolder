package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.CoordonateurModule;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Enseignement.CoordonateurModuleRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class CoordonateurModuleServiceImpl implements CoordonateurModuleService{
    @Autowired
    private CoordonateurModuleRepository coordonateurModuleRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public void saveCoordonateurModule(ActivitySubType2 activitySubType2, String activityName, String nomModule, String filière, String niveau, String departement, String etablissement, String annéesResponsabilités, MultipartFile file) throws IOException {
        CoordonateurModule coordonateurModule = new CoordonateurModule();
        coordonateurModule.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();


        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        coordonateurModule.setActivityName(activityName);
        coordonateurModule.setNomModule(nomModule);
        coordonateurModule.setFilière(filière);
        coordonateurModule.setNiveau(niveau);
        coordonateurModule.setDepartement(departement);
        coordonateurModule.setEtablissement(etablissement);
        coordonateurModule.setAnnéesResposabilités(annéesResponsabilités);
        coordonateurModule.setJustification(file.getBytes());
        coordonateurModule.setUser(user);
        coordonateurModuleRepository.save(coordonateurModule);
    }

    @Override
    public Iterable<CoordonateurModule> getCoordonateurModules() {
        return coordonateurModuleRepository.findAll();
    }
}

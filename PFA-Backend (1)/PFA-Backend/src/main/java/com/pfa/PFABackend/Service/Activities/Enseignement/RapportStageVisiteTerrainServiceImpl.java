package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.RapportStageVisiteTerrain;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Enseignement.RapportStageVisiteTerrainRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class RapportStageVisiteTerrainServiceImpl implements RapportStageVisiteTerrainService{
    @Autowired
    private RapportStageVisiteTerrainRepository rapportStageVisiteTerrainRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public void saveRapportStageVisiteTerrain(ActivitySubType2 activitySubType2, String activityName, String titreStage, String cadre, int année, String société, MultipartFile file) throws IOException {
        RapportStageVisiteTerrain rapportStageVisiteTerrain = new RapportStageVisiteTerrain();
        rapportStageVisiteTerrain.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        rapportStageVisiteTerrain.setActivityName(activityName);
        rapportStageVisiteTerrain.setTitreStage(titreStage);
        rapportStageVisiteTerrain.setCadre(cadre);
        rapportStageVisiteTerrain.setAnnée(année);
        rapportStageVisiteTerrain.setSociété(société);
        rapportStageVisiteTerrain.setJustification(file.getBytes());
        rapportStageVisiteTerrain.setUser(user);
        rapportStageVisiteTerrainRepository.save(rapportStageVisiteTerrain);
    }

    @Override
    public Iterable<RapportStageVisiteTerrain> getRapportsStagesVisitesTerrains() {
        return rapportStageVisiteTerrainRepository.findAll();
    }
}

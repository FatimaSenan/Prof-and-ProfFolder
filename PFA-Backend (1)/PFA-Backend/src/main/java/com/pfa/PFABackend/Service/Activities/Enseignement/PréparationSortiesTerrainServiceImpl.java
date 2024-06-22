package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.PréparationSortiesTerrain;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Enseignement.PréparationSortiesTerrainRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PréparationSortiesTerrainServiceImpl implements PréparationSortiesTerrainService{
    @Autowired
    private PréparationSortiesTerrainRepository préparationSortiesTerrainRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void savePréparationSortiesTerrains(ActivitySubType2 activitySubType2, String activityName, String cadre, String date, String nomSociété, MultipartFile file) throws IOException {
        PréparationSortiesTerrain préparationSortiesTerrain = new PréparationSortiesTerrain();
        préparationSortiesTerrain.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        préparationSortiesTerrain.setActivityName(activityName);
        préparationSortiesTerrain.setCadre(cadre);
        préparationSortiesTerrain.setDate(date);
        préparationSortiesTerrain.setNomSociété(nomSociété);
        préparationSortiesTerrain.setJustification(file.getBytes());
        préparationSortiesTerrain.setUser(user);

        préparationSortiesTerrainRepository.save(préparationSortiesTerrain);
    }

    @Override
    public Iterable<PréparationSortiesTerrain> getPréparationsSortiesTerrain() {
        return préparationSortiesTerrainRepository.findAll();
    }
}

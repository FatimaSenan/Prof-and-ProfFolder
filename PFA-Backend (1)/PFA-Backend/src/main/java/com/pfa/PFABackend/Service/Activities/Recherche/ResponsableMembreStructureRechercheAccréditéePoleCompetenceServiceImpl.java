package com.pfa.PFABackend.Service.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.ResponsableMembreStructureRecherchePole;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Recherche.ResponsableMembreStructureRechercheAccréditéePoleCompetenceRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Service
public class ResponsableMembreStructureRechercheAccréditéePoleCompetenceServiceImpl implements ResponsableMembreStructureRechercheAccréditéePoleCompetenceService{

    @Autowired
    private ResponsableMembreStructureRechercheAccréditéePoleCompetenceRepository responsableMembreStructureRechercheAccréditéePoleCompetenceRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public void saveResponsableMembreStructureRechercheAccréditéePoleCompetence(ActivitySubType2 activitySubType2, String activityName, String responsabilité, String années, MultipartFile file) throws IOException {
    ResponsableMembreStructureRecherchePole responsableMembreStructureRechercheAccréditéePoleCompetence = new ResponsableMembreStructureRecherchePole();
    responsableMembreStructureRechercheAccréditéePoleCompetence.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        responsableMembreStructureRechercheAccréditéePoleCompetence.setActivityName(activityName);
        responsableMembreStructureRechercheAccréditéePoleCompetence.setRésponsabilité(responsabilité);
        responsableMembreStructureRechercheAccréditéePoleCompetence.setAnnées(années);
        responsableMembreStructureRechercheAccréditéePoleCompetence.setJustification(file.getBytes());
        responsableMembreStructureRechercheAccréditéePoleCompetence.setUser(user);
        responsableMembreStructureRechercheAccréditéePoleCompetenceRepository.save(responsableMembreStructureRechercheAccréditéePoleCompetence);
    }

    @Override
    public Iterable<ResponsableMembreStructureRecherchePole> getResponsableMembreStructureRechercheAccréditéePoleCompetences() {
        return responsableMembreStructureRechercheAccréditéePoleCompetenceRepository.findAll();
    }
}

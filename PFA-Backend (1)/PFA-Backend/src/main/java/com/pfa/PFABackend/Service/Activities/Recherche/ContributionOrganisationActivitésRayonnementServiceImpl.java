package com.pfa.PFABackend.Service.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.ContributionOrganisationActivitésRayonnement;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Recherche.ContributionOrganisationActivitésRayonnementRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Service
public class ContributionOrganisationActivitésRayonnementServiceImpl implements ContributionOrganisationActivitésRayonnementService{

    @Autowired
    private ContributionOrganisationActivitésRayonnementRepository contributionOrganisationActivitésRayonnementRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveContributionOrganisationActivitésRayonnement(ActivitySubType2 activitySubType2, String activityName, String nomConférence, String lien, String type, String role, String date, MultipartFile file) throws IOException {
        ContributionOrganisationActivitésRayonnement contributionOrganisationActivitésRayonnement = new ContributionOrganisationActivitésRayonnement();
        contributionOrganisationActivitésRayonnement.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        contributionOrganisationActivitésRayonnement.setActivityName(activityName);
        contributionOrganisationActivitésRayonnement.setNomConférence(nomConférence);
        contributionOrganisationActivitésRayonnement.setLien(lien);
        contributionOrganisationActivitésRayonnement.setType(type);
        contributionOrganisationActivitésRayonnement.setRole(role);
        contributionOrganisationActivitésRayonnement.setDateConférence(date);
        contributionOrganisationActivitésRayonnement.setJustification(file.getBytes());
        contributionOrganisationActivitésRayonnement.setUser(user);
        contributionOrganisationActivitésRayonnementRepository.save(contributionOrganisationActivitésRayonnement);
    }

    @Override
    public Iterable<ContributionOrganisationActivitésRayonnement> getContributionOrganisationActivitésRayonnements() {
        return contributionOrganisationActivitésRayonnementRepository.findAll();
    }
}

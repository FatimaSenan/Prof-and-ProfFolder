package com.pfa.PFABackend.Service.Activities.Recherche;


import com.pfa.PFABackend.Model.Activities.Recherche.ContributionOrganisationActivitésRayonnement;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ContributionOrganisationActivitésRayonnementService {
    public void saveContributionOrganisationActivitésRayonnement(ActivitySubType2 activitySubType2, String activityName,  String nomConférence, String lien, String type, String role, String date , MultipartFile file) throws IOException;

    public Iterable<ContributionOrganisationActivitésRayonnement> getContributionOrganisationActivitésRayonnements();
}

package com.pfa.PFABackend.Repository.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.CongrèsConférencesPubliées;
import com.pfa.PFABackend.Model.Activities.Recherche.ContributionOrganisationActivitésRayonnement;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ContributionOrganisationActivitésRayonnementRepository extends JpaRepository<ContributionOrganisationActivitésRayonnement, Integer> {

}

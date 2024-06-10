package com.pfa.PFABackend.Service.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.ResponsableMembreStructureRecherchePole;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ResponsableMembreStructureRechercheAccréditéePoleCompetenceService {
    public void saveResponsableMembreStructureRechercheAccréditéePoleCompetence(ActivitySubType2 activitySubType2, String activityName, String responsabilité, String années, MultipartFile file) throws IOException;

    public Iterable<ResponsableMembreStructureRecherchePole> getResponsableMembreStructureRechercheAccréditéePoleCompetences();
}

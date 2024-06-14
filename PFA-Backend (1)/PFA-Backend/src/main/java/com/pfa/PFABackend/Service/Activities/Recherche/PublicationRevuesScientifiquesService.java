package com.pfa.PFABackend.Service.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.ProjetsContratsRecherche;
import com.pfa.PFABackend.Model.Activities.Recherche.PublicationRevuesScientifiques;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PublicationRevuesScientifiquesService {
    public void savePublicationRevuesScientifiques(ActivitySubType2 activitySubType2, String activityName, String type,String titre, String auteurs, String lien, String journal, String issn, int annéePublication,MultipartFile file) throws IOException;

    public Iterable<PublicationRevuesScientifiques> getPublicationRevuesScientifiques();
}

package com.pfa.PFABackend.Service.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.PublicationRevuesScientifiques;
import com.pfa.PFABackend.Model.Activities.Recherche.PublicationsRevuesIndexées;
import com.pfa.PFABackend.Model.ActivitySubType2;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PublicationsRevuesIndexéesService {
    public void savePublicationRevuesIndexées(ActivitySubType2 activitySubType2, String activityName,String niveau, String titre, String auteurs, String doi, String lien, String journal,String isbn, int annéePublication, MultipartFile file) throws IOException;

    public Iterable<PublicationsRevuesIndexées> getPublicationRevuesIndexées();
}

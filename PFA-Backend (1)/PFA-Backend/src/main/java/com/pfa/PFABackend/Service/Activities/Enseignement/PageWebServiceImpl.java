package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.PageWeb;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Repository.Activities.Enseignement.PageWebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PageWebServiceImpl implements PageWebService{
    @Autowired
    private PageWebRepository pageWebRepository;


    @Override
    public void savePageWeb(ActivitySubType2 activitySubType2, String activityName, String lien) throws IOException {
        PageWeb pageWeb = new PageWeb();
        pageWeb.setActivitySubType2(activitySubType2);
        pageWeb.setActivityName(activityName);
        pageWeb.setLink(lien);

        pageWebRepository.save(pageWeb);
    }

    @Override
    public Iterable<PageWeb> getPageWebs() {
        return pageWebRepository.findAll();
    }
}

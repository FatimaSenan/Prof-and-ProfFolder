package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.PageWeb;
import com.pfa.PFABackend.Repository.Activities.Enseignement.PageWebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageWebServiceImpl implements PageWebService{
    @Autowired
    private PageWebRepository pageWebRepository;
    @Override
    public void savePageWeb(PageWeb pageWeb) {
        pageWebRepository.save(pageWeb);
    }

    @Override
    public Iterable<PageWeb> getPageWebs() {
        return pageWebRepository.findAll();
    }
}

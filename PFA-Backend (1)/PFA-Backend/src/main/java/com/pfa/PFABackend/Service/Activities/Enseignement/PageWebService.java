package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MOOC;
import com.pfa.PFABackend.Model.Activities.Enseignement.PageWeb;

public interface PageWebService {
    public void savePageWeb(PageWeb pageWeb);

    public Iterable<PageWeb> getPageWebs();
}

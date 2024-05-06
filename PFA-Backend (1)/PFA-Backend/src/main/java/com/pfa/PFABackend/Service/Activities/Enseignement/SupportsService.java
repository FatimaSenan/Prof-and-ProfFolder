package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.Supports;

public interface SupportsService {
    public void saveSpports(Supports supports);

    public Iterable<Supports> getSupports();
}

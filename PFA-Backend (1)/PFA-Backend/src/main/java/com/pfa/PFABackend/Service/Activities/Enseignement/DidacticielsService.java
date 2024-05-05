package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.Didacticiels;

public interface DidacticielsService {

    public void saveDidacticiels(Didacticiels didacticiels);

    public Iterable<Didacticiels> getDidacticiels();
}

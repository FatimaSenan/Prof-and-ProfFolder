package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MOOC;
import com.pfa.PFABackend.Model.Activities.Enseignement.Ouvrage;

public interface OuvrageService {
    public void saveOuvrage(Ouvrage ouvrage);

    public Iterable<Ouvrage> getOuvrages();
}

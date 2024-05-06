package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MOOC;
import com.pfa.PFABackend.Model.Activities.Enseignement.PolycopiésPédagogiques;

public interface PolycopiésPédagogiquesService {

    public void savePolycopiésPédagogiques(PolycopiésPédagogiques polycopiésPédagogiques);

    public Iterable<PolycopiésPédagogiques> getPolycopiésPédagogiques();
}

package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionEtablissement;
import com.pfa.PFABackend.Model.Activities.Enseignement.MontagesExpérimentaux;

public interface MontagesExpérimentauxService {
    public void saveMontagesExpérimentaux(MontagesExpérimentaux montagesExpérimentaux);

    public Iterable<MontagesExpérimentaux> getMontagesExpérimentaux();
}

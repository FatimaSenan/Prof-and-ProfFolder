package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionEtablissement;

public interface MembreCommissionEtablissementService {

    public void saveMembreCommissionEtablissement(MembreCommissionEtablissement membreCommissionEtablissement);

    public Iterable<MembreCommissionEtablissement> getMembreCommissionsEtablisements();
}

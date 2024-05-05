package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;

public interface MembreCommissionConseilService {

    public void saveMembreCommissionConseil(MembreCommissionConseil membreCommissionConseil);

    public Iterable<MembreCommissionConseil> getMembreCommissionConseils();
}

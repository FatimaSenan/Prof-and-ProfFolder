package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionEtablissement;
import com.pfa.PFABackend.Model.Activities.Enseignement.MembreEluConseil;

public interface MembreEluConseilService {
    public void saveMembreEluConseil(MembreEluConseil membreEluConseil);

    public Iterable<MembreEluConseil> getMembreEluConseils();
}

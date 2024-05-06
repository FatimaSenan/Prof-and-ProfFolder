package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionEtablissement;
import com.pfa.PFABackend.Model.Activities.Enseignement.MembreConseilCoordination;

public interface MembreConseilCoordinationService {

    public void saveMembreConseilCoordination(MembreConseilCoordination membreConseilCoordination);

    public Iterable<MembreConseilCoordination> getMembreConseilsCoordinations();

}

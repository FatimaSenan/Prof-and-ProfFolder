package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreConseilCoordination;
import com.pfa.PFABackend.Repository.Activities.Enseignement.MembreConseilCoordinationRepository;
import org.springframework.stereotype.Service;

@Service
public class MembreConseilCoordinationServiceImpl implements MembreConseilCoordinationService{

    private MembreConseilCoordinationRepository membreConseilCoordinationRepository;
    @Override
    public void saveMembreConseilCoordination(MembreConseilCoordination membreConseilCoordination) {
        membreConseilCoordinationRepository.save(membreConseilCoordination);
    }

    @Override
    public Iterable<MembreConseilCoordination> getMembreConseilsCoordinations() {
        return membreConseilCoordinationRepository.findAll();
    }
}

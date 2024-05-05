package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Repository.Activities.Enseignement.MembreCommissionConseilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembreCommissionConseilServiceImpl implements MembreCommissionConseilService{
    @Autowired
    private MembreCommissionConseilRepository membreCommissionConseilRepository;
    @Override
    public void saveMembreCommissionConseil(MembreCommissionConseil membreCommissionConseil) {
        membreCommissionConseilRepository.save(membreCommissionConseil);
    }

    @Override
    public Iterable<MembreCommissionConseil> getMembreCommissionConseils() {
        return membreCommissionConseilRepository.findAll();
    }
}

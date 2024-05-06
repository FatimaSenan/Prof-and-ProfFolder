package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreEluConseil;
import com.pfa.PFABackend.Repository.Activities.Enseignement.MembreEluConseilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembreEluConseilServiceImpl implements MembreEluConseilService{
    @Autowired
    private MembreEluConseilRepository membreEluConseilRepository;
    @Override
    public void saveMembreEluConseil(MembreEluConseil membreEluConseil) {
        membreEluConseilRepository.save(membreEluConseil);
    }

    @Override
    public Iterable<MembreEluConseil> getMembreEluConseils() {
        return membreEluConseilRepository.findAll();
    }
}

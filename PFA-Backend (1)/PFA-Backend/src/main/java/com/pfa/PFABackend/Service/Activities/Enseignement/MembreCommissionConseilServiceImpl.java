package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreCommissionConseil;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Repository.Activities.Enseignement.MembreCommissionConseilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class MembreCommissionConseilServiceImpl implements MembreCommissionConseilService{
    @Autowired
    private MembreCommissionConseilRepository membreCommissionConseilRepository;


    @Override
    public void saveMembreCommissionConseil(ActivitySubType2 activitySubType2, String activityName, String titreConseil, String période, MultipartFile file) throws IOException {
        MembreCommissionConseil membreCommissionConseil = new MembreCommissionConseil();
        membreCommissionConseil.setActivitySubType2(activitySubType2);
        membreCommissionConseil.setActivityName(activityName);
        membreCommissionConseil.setTitreCommission(titreConseil);
        membreCommissionConseil.setPériode(période);
        membreCommissionConseil.setJustification(file.getBytes());
        membreCommissionConseilRepository.save(membreCommissionConseil);
    }

    @Override
    public Iterable<MembreCommissionConseil> getMembreCommissionConseils() {
        return membreCommissionConseilRepository.findAll();
    }
}

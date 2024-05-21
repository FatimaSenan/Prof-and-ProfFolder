package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreConseilCoordination;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Repository.Activities.Enseignement.MembreConseilCoordinationRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class MembreConseilCoordinationServiceImpl implements MembreConseilCoordinationService{

    private MembreConseilCoordinationRepository membreConseilCoordinationRepository;


    @Override
    public void saveMembreConseilCoordination(ActivitySubType2 activitySubType2, String activityName, String titreConseil, String période, MultipartFile file) throws IOException {
        MembreConseilCoordination membreConseilCoordination = new MembreConseilCoordination();
        membreConseilCoordination.setActivitySubType2(activitySubType2);
        membreConseilCoordination.setActivityName(activityName);
        membreConseilCoordination.setTitreConseil(titreConseil);
        membreConseilCoordination.setPériode(période);
        membreConseilCoordination.setJustification(file.getBytes());
        membreConseilCoordinationRepository.save(membreConseilCoordination);
    }

    @Override
    public Iterable<MembreConseilCoordination> getMembreConseilsCoordinations() {
        return membreConseilCoordinationRepository.findAll();
    }
}

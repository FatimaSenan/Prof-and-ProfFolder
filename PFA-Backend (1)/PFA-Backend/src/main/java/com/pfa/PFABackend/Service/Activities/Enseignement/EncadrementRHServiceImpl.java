package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.EncadrementRH;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Repository.Activities.Enseignement.EncadrementRHRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class EncadrementRHServiceImpl implements  EncadrementRHService{
    @Autowired
    private EncadrementRHRepository encadrementRHRepository;


    @Override
    public void saveEncadrementRH(ActivitySubType2 activitySubType2, String activityName, String typeEncadrement, String titre, String membres, int dateDébut, int dateFin, MultipartFile file) throws IOException {

    }

    @Override
    public Iterable<EncadrementRH> getEncadrementRHs() {
        return encadrementRHRepository.findAll();
    }
}

package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MontagesExpérimentaux;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Repository.Activities.Enseignement.MontagesExpérimentauxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class MontagesExpérimentauxServiceImpl implements MontagesExpérimentauxService{
    @Autowired
    private MontagesExpérimentauxRepository montagesExpérimentauxRepository;


    @Override
    public void saveMontagesExpérimentaux(ActivitySubType2 activitySubType2, String activityName, String module, String filière, int nombreManip, MultipartFile file) throws IOException {
        MontagesExpérimentaux montagesExpérimentaux = new MontagesExpérimentaux();
        montagesExpérimentaux.setActivitySubType2(activitySubType2);
        montagesExpérimentaux.setActivityName(activityName);
        montagesExpérimentaux.setModule(module);
        montagesExpérimentaux.setFilière(filière);
        montagesExpérimentaux.setNombreManip(nombreManip);
        montagesExpérimentaux.setJustification(file.getBytes());
        montagesExpérimentauxRepository.save(montagesExpérimentaux);
    }

    @Override
    public Iterable<MontagesExpérimentaux> getMontagesExpérimentaux() {
        return montagesExpérimentauxRepository.findAll();
    }
}

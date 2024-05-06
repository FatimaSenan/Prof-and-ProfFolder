package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MontagesExpérimentaux;
import com.pfa.PFABackend.Repository.Activities.Enseignement.MontagesExpérimentauxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MontagesExpérimentauxServiceImpl implements MontagesExpérimentauxService{
    @Autowired
    private MontagesExpérimentauxRepository montagesExpérimentauxRepository;
    @Override
    public void saveMontagesExpérimentaux(MontagesExpérimentaux montagesExpérimentaux) {
        montagesExpérimentauxRepository.save(montagesExpérimentaux);
    }

    @Override
    public Iterable<MontagesExpérimentaux> getMontagesExpérimentaux() {
        return montagesExpérimentauxRepository.findAll();
    }
}

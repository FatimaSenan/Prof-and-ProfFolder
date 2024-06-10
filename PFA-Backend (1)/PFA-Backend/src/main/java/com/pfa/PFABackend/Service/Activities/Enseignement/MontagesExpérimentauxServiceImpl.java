package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MontagesExpérimentaux;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Enseignement.MontagesExpérimentauxRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class MontagesExpérimentauxServiceImpl implements MontagesExpérimentauxService{
    @Autowired
    private MontagesExpérimentauxRepository montagesExpérimentauxRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveMontagesExpérimentaux(ActivitySubType2 activitySubType2, String activityName, String module, String filière, int nombreManip, MultipartFile file) throws IOException {
        MontagesExpérimentaux montagesExpérimentaux = new MontagesExpérimentaux();
        montagesExpérimentaux.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        montagesExpérimentaux.setActivityName(activityName);
        montagesExpérimentaux.setModule(module);
        montagesExpérimentaux.setFilière(filière);
        montagesExpérimentaux.setNombreManip(nombreManip);
        montagesExpérimentaux.setJustification(file.getBytes());
        montagesExpérimentaux.setUser(user);
        montagesExpérimentauxRepository.save(montagesExpérimentaux);
    }

    @Override
    public Iterable<MontagesExpérimentaux> getMontagesExpérimentaux() {
        return montagesExpérimentauxRepository.findAll();
    }
}

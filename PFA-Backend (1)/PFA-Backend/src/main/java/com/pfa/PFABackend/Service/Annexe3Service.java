package com.pfa.PFABackend.Service;

import com.pfa.PFABackend.Model.Annexe3;
import com.pfa.PFABackend.Model.ProfessorFolder;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Annexe3Repository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class Annexe3Service {

    @Autowired
    private Annexe3Repository annexe3Repository;

    @Autowired
    private UserRepository userRepository;

    public String addAnnexe3(Annexe3 annexe3) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        annexe3.setUser(user);
        annexe3Repository.save(annexe3);

        return "Annexe3 added successfully";
    }


    public byte[] getAnnexe3PdfForSelectedUser(String userEmail) {
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        Annexe3 annexe3 = annexe3Repository.findByUserEmail(userEmail)
                .orElseThrow(() -> new IllegalArgumentException("Professor folder not found"));
        return annexe3.getTeachingTable();
    }

}

package com.pfa.PFABackend.Service;

import com.pfa.PFABackend.Model.Annexe2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Annexe2Repository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class Annexe2Service {

    @Autowired
    private Annexe2Repository annexe2Repository;

    @Autowired
    private UserRepository userRepository;

    public String addAnnexe2(Annexe2 annexe2) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("User not found"));

        annexe2.setUser(user);
        user.setAnnexe2(annexe2); // Important to maintain the bidirectional relationship
        annexe2Repository.save(annexe2);

        return "Annexe2 added successfully";
    }

    public Annexe2 getAnnexe2ByUser(String userEmail) {
       

        return annexe2Repository.findByUserEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("Annexe2 not found"));
    }


}

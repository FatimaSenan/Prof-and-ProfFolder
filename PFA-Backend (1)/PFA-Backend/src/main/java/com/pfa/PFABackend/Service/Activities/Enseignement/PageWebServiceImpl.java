package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.PageWeb;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Enseignement.PageWebRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PageWebServiceImpl implements PageWebService{
    @Autowired
    private PageWebRepository pageWebRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public void savePageWeb(ActivitySubType2 activitySubType2, String activityName, String lien) throws IOException {
        PageWeb pageWeb = new PageWeb();
        pageWeb.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        pageWeb.setActivityName(activityName);
        pageWeb.setLink(lien);
        pageWeb.setUser(user);
        pageWebRepository.save(pageWeb);
    }

    @Override
    public Iterable<PageWeb> getPageWebs() {
        return pageWebRepository.findAll();
    }
}

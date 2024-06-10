package com.pfa.PFABackend.Service.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.Enseignement.MembreEluConseil;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Enseignement.MembreEluConseilRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class MembreEluConseilServiceImpl implements MembreEluConseilService{
    @Autowired
    private MembreEluConseilRepository membreEluConseilRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveMembreEluConseil(ActivitySubType2 activitySubType2, String activityName, String membreConseil, String période, MultipartFile file) throws IOException {
        MembreEluConseil membreEluConseil = new MembreEluConseil();
        membreEluConseil.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        membreEluConseil.setActivityName(activityName);
        membreEluConseil.setMembreConseil(membreConseil);
        membreEluConseil.setPériode(période);
        membreEluConseil.setJustification(file.getBytes());
        membreEluConseil.setUser(user);
        membreEluConseilRepository.save(membreEluConseil);
    }

    @Override
    public Iterable<MembreEluConseil> getMembreEluConseils() {
        return membreEluConseilRepository.findAll();
    }
}

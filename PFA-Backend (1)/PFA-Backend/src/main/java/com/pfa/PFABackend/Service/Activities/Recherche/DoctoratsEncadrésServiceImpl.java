package com.pfa.PFABackend.Service.Activities.Recherche;

import com.pfa.PFABackend.Model.Activities.Recherche.DoctoratsEncadrés;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import com.pfa.PFABackend.Repository.Activities.Recherche.DoctoratsEncadrésRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Service
public class DoctoratsEncadrésServiceImpl implements DoctoratsEncadrésService{

    @Autowired
    private DoctoratsEncadrésRepository doctoratsEncadrésRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public void saveDoctoratsEncadrés(ActivitySubType2 activitySubType2, String activityName, String inscription, String sujet, String formationDOctorale, String laboratoire, String doctorant, String directeurThèse, String dateSoutenance, MultipartFile file) throws IOException {
        DoctoratsEncadrés doctoratsEncadrés = new DoctoratsEncadrés();
        doctoratsEncadrés.setActivitySubType2(activitySubType2);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        doctoratsEncadrés.setActivityName(activityName);
        doctoratsEncadrés.setDatePremièreInscription(inscription);
        doctoratsEncadrés.setSujet(sujet);
        doctoratsEncadrés.setFormationDoctorale(formationDOctorale);
        doctoratsEncadrés.setLaboratoire(laboratoire);
        doctoratsEncadrés.setDoctorant(doctorant);
        doctoratsEncadrés.setDirecteurThèse(directeurThèse);
        doctoratsEncadrés.setDateSoutenance(dateSoutenance);
        doctoratsEncadrés.setJustification(file.getBytes());
        doctoratsEncadrés.setUser(user);
        doctoratsEncadrésRepository.save(doctoratsEncadrés);
    }

    @Override
    public Iterable<DoctoratsEncadrés> getDoctoratsEncadrés() {
        return doctoratsEncadrésRepository.findAll();
    }
}

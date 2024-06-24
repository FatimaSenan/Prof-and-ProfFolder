package com.pfa.PFABackend.Service;

import com.pfa.PFABackend.Model.Activities.Enseignement.Ouvrage;
import com.pfa.PFABackend.Model.User;
import  com.pfa.PFABackend.ProfessorNotFoundException;
import com.pfa.PFABackend.Model.Professor;
import com.pfa.PFABackend.Model.ProfessorFolder;
import com.pfa.PFABackend.Repository.ProfessorFolderRepository;
import com.pfa.PFABackend.Repository.ProfessorRepository;
import com.pfa.PFABackend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;

@Service
public class ProfessorFolderServiceImp implements ProfessorFolderService {

    /*@Autowired
    private ProfessorRepository professorRepository;*/

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProfessorFolderRepository professorFolderRepository;

    @Override
    public String addProfessorFolder(ProfessorFolder professorFolder) {



            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String userEmail = authentication.getName();

            User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));


          professorFolder.setUser(user);
          professorFolderRepository.save(professorFolder);
            return "A new professor folder is added";
    }

    @Override
    public ProfessorFolder getProfessorFolderByUser(String userEmail) {
        return professorFolderRepository.findByUserEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("Professor Folder not found"));
    }

    @Override
    public byte[] getEquivalencePdfForSelectedUser(int professorFolderId, String userEmail) {
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        ProfessorFolder professorFolder = professorFolderRepository.findById(professorFolderId)
                .orElseThrow(() -> new IllegalArgumentException("Professor folder not found"));
        return professorFolder.getEquivalence();
    }
    @Override
    public byte[] getCVPdfForSelectedUser(int professorFolderId, String userEmail) {
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        ProfessorFolder professorFolder = professorFolderRepository.findById(professorFolderId)
                .orElseThrow(() -> new IllegalArgumentException("Professor folder not found"));
        return professorFolder.getCv();
    }

    @Override
    public byte[] getApplicationDemandePdfForSelectedUser(int professorFolderId, String userEmail) {
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        ProfessorFolder professorFolder = professorFolderRepository.findById(professorFolderId)
                .orElseThrow(() -> new IllegalArgumentException("Professor folder not found"));
        return professorFolder.getApplicationDemande();
    }

    @Override
    public byte[] getPhdDiplomePdfForSelectedUser(int professorFolderId, String userEmail) {
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        ProfessorFolder professorFolder = professorFolderRepository.findById(professorFolderId)
                .orElseThrow(() -> new IllegalArgumentException("Professor folder not found"));
        return professorFolder.getPhdDiplome();
    }

    @Override
    public byte[] getHabilitationDiplomePdfForSelectedUser(int professorFolderId, String userEmail) {
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        ProfessorFolder professorFolder = professorFolderRepository.findById(professorFolderId)
                .orElseThrow(() -> new IllegalArgumentException("Professor folder not found"));
        return professorFolder.getHabilitationDiplome();
    }

    @Override
    public byte[] getArretNominationPdfForSelectedUser(int professorFolderId, String userEmail) {
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        ProfessorFolder professorFolder = professorFolderRepository.findById(professorFolderId)
                .orElseThrow(() -> new IllegalArgumentException("Professor folder not found"));
        return professorFolder.getArretNomination();
    }

    @Override
    public byte[] getAttestationPdfForSelectedUser(int professorFolderId, String userEmail) {
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));
        ProfessorFolder professorFolder = professorFolderRepository.findById(professorFolderId)
                .orElseThrow(() -> new IllegalArgumentException("Professor folder not found"));
        return professorFolder.getAttestation();
    }
}

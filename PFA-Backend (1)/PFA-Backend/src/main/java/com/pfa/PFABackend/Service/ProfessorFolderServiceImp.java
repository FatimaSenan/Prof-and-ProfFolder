package com.pfa.PFABackend.Service;

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

          /* // Récupérer le professeur à partir de l'ID
            Professor professor = professorRepository.findById(professorId)
                    .orElseThrow(() -> new ProfessorNotFoundException("Professor not found with ID: " + professorId));

            // Associer le dossier du professeur au professeur
            professorFolder.setProfessor(professor);

            // Enregistrer le dossier du professeur
            professorFolderRepository.save(professorFolder);*/

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String userEmail = authentication.getName();

            User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new RuntimeException("User not found"));


          professorFolder.setUser(user);
          professorFolderRepository.save(professorFolder);
            return "A new professor folder is added";
    }
}

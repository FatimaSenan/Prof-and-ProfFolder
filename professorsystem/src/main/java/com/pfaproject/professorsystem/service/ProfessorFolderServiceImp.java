package com.pfaproject.professorsystem.service;

import com.pfaproject.professorsystem.ProfessorNotFoundException;
import com.pfaproject.professorsystem.model.Professor;
import com.pfaproject.professorsystem.model.ProfessorFolder;
import com.pfaproject.professorsystem.repository.ProfessorFolderRepository;
import com.pfaproject.professorsystem.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorFolderServiceImp implements ProfessorFolderService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private ProfessorFolderRepository professorFolderRepository;

    @Override
    public void addProfessorFolder(int professorId, ProfessorFolder professorFolder) {
        try {
            // Récupérer le professeur à partir de l'ID
            Professor professor = professorRepository.findById(professorId)
                    .orElseThrow(() -> new ProfessorNotFoundException("Professor not found with ID: " + professorId));

            // Associer le dossier du professeur au professeur
            professorFolder.setProfessor(professor);

            // Enregistrer le dossier du professeur
            professorFolderRepository.save(professorFolder);
        } catch (ProfessorNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.pfaproject.professorsystem.service;

import com.pfaproject.professorsystem.model.Professor;
import com.pfaproject.professorsystem.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessorServiceImp implements ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public Professor saveProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }
}

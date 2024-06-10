package com.pfa.PFABackend.Service;

import com.pfa.PFABackend.Model.Professor;
import com.pfa.PFABackend.Repository.ProfessorRepository;
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
    @Override
    public Professor getProfessorById(int professorId) {
        return professorRepository.findById(professorId).orElse(null);
    }
}

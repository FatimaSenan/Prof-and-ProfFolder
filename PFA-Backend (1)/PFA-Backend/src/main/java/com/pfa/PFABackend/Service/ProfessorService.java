package com.pfa.PFABackend.Service;

import com.pfa.PFABackend.Model.Professor;

import java.util.List;

public interface  ProfessorService {
    Professor saveProfessor(Professor professor);
    List<Professor> getAllProfessors();

    Professor getProfessorById(int professorId);
}

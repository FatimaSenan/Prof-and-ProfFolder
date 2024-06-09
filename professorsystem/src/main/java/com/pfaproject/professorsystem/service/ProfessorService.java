package com.pfaproject.professorsystem.service;

import com.pfaproject.professorsystem.model.Professor;

import java.util.List;

public interface ProfessorService {
    Professor saveProfessor(Professor professor);
    List<Professor> getAllProfessors();

    Professor getProfessorById(int professorId);
}

package com.pfaproject.professorsystem.repository;

import com.pfaproject.professorsystem.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Integer> {
}
package com.pfaproject.professorsystem.repository;

import com.pfaproject.professorsystem.model.ProfessorFolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorFolderRepository extends JpaRepository<ProfessorFolder, Integer> {
}

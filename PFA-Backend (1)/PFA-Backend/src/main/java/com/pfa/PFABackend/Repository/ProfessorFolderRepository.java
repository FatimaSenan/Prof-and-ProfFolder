package com.pfa.PFABackend.Repository;

import com.pfa.PFABackend.Model.ProfessorFolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorFolderRepository extends JpaRepository<ProfessorFolder, Integer> {
}

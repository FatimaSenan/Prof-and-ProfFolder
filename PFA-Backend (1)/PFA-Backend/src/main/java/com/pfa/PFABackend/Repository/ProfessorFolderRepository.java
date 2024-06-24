package com.pfa.PFABackend.Repository;

import com.pfa.PFABackend.Model.Professor;
import com.pfa.PFABackend.Model.ProfessorFolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorFolderRepository extends JpaRepository<ProfessorFolder, Integer> {

    public Optional<ProfessorFolder> findByUserEmail(String userEmail);
}

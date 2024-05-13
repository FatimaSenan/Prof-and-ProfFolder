package com.pfaproject.professorsystem.controller;

import com.pfaproject.professorsystem.model.ProfessorFolder;
import com.pfaproject.professorsystem.service.ProfessorFolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/folder")
@CrossOrigin
public class ProfessorFolderController {

    @Autowired
    private ProfessorFolderService professorService;

    @PostMapping("/add")
    public String addProfessorFolder(@RequestParam int professorId, @RequestBody ProfessorFolder professorFolder) {
        professorService.addProfessorFolder(professorId, professorFolder);
        return "Professor folder added successfully";
    }
}

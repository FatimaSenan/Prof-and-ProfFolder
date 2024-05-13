package com.pfaproject.professorsystem.controller;

import com.pfaproject.professorsystem.model.Professor;
import com.pfaproject.professorsystem.service.ProfessorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professor")
@CrossOrigin
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @PostMapping("/add")
    public String add(@RequestBody Professor professor){
        professorService.saveProfessor(professor);
        return "New professor is added";
    }

    @GetMapping("/getAll")
    public List<Professor> list(){
        return professorService.getAllProfessors();
    }


}
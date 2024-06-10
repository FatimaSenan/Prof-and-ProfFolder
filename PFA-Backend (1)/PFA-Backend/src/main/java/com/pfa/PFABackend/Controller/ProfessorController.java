package com.pfa.PFABackend.Controller;

import  com.pfa.PFABackend.Model.Professor;
import  com.pfa.PFABackend.Service.ProfessorService;

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
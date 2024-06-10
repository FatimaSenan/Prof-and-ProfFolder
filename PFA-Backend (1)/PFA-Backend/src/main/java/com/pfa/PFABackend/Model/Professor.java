package com.pfa.PFABackend.Model;

import jakarta.persistence.*;


import java.util.Date;
@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_prof;
   /* @OneToOne(mappedBy = "professor", cascade = CascadeType.ALL)
    private ProfessorFolder professorFolder;*/
    private String firstName;
    private String lastName;
    private String role;
    private String CNE;
    private String email;

    private String DRPP;

    //Getters

    public int getId_prof() {
        return id_prof;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole() {
        return role;
    }

    public String getCNE() {
        return CNE;
    }


    public String getEmail() {
        return email;
    }


    public String getDRPP() {
        return DRPP;
    }


    //Setters

    public void setId_prof(int id_prof) {
        this.id_prof = id_prof;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setCNE(String CNE) {
        this.CNE = CNE;
    }


    public void setDRPP(String DRPP) {
        this.DRPP = DRPP;
    }

    public void setEmail(String email) {
        this.email = email;
    }

  /*  public ProfessorFolder getFolder() {
        return professorFolder;
    }
    public void setProfessorFolder(ProfessorFolder professorFolder) {
        this.professorFolder = professorFolder;
    }*/
}



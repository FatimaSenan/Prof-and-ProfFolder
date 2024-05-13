package com.pfaproject.professorsystem.model;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class ProfessorFolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int folder_id;
    // référence au professeur
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prof")
    private Professor professor;
    private String civility;
    private Date birthDate;

    private int phone;
    private String grade;
    private String profile;
    private String speciality;
    private String establishment;
    private String phd_type;
    /*@Lob
    private byte[] cv;
    @Lob
    private byte[] application_demande;

    @Lob
    private byte[] PHD_diplome;
    @Lob
    private byte[] habilition_diplome;
    @Lob
    private byte[] arret_nomination;
    @Lob
    private byte[] attestation;*/

    private String evaluation_status;


    public String getCivility() {
        return civility;
    }

    public void setCivility(String civility) {
        this.civility = civility;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getEstablishment() {
        return establishment;
    }

    public void setEstablishment(String establishment) {
        this.establishment = establishment;
    }

    /*public byte[] getCv() {
        return cv;
    }

    public void setCv(byte[] cv) {
        this.cv = cv;
    }

    public byte[] getApplication_demande() {
        return application_demande;
    }

    public void setApplication_demande(byte[] application_demande) {
        this.application_demande = application_demande;
    }*/

    public String getPhd_type() {
        return phd_type;
    }

    public void setPhd_type(String Phd_type) {
        this.phd_type = Phd_type;
    }

    /*public byte[] getPHD_diplome() {
        return PHD_diplome;
    }

    public void setPHD_diplome(byte[] PHD_diplome) {
        this.PHD_diplome = PHD_diplome;
    }

    public byte[] getHabilition_diplome() {
        return habilition_diplome;
    }

    public void setHabilition_diplome(byte[] habilition_diplome) {
        this.habilition_diplome = habilition_diplome;
    }

    public byte[] getArret_nomination() {
        return arret_nomination;
    }

    public void setArret_nomination(byte[] arret_nomination) {
        this.arret_nomination = arret_nomination;
    }

    public byte[] getAttestation() {
        return attestation;
    }

    public void setAttestation(byte[] attestation) {
        this.attestation = attestation;
    }*/

    public String getEvaluation_status() {
        return evaluation_status;
    }

    public void setEvaluation_status(String evaluation_status) {
        this.evaluation_status = evaluation_status;
    }

    // Getter pour professor
    public Professor getProfessor() {
        return professor;
    }

    // Setter pour professor
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}

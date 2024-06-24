package com.pfa.PFABackend.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class ProfessorFolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int folder_id;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    private String civility;

    public int getFolder_id() {
        return folder_id;
    }

    public void setFolder_id(int folder_id) {
        this.folder_id = folder_id;
    }

    private String nom;

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }
    private String drpp;
    private String cne;


    public String getDrpp() {
        return drpp;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public void setDrpp(String drpp) {
        this.drpp = drpp;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String email;

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    private String prenom;
    private String birthDate;

    private String phone;
    private String grade;
    private String profile;
    private String speciality;
    private String establishment;
    private String phdType;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] equivalence;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] cv;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] applicationDemande;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] phdDiplome;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] habilitationDiplome;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] arretNomination;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] attestation;

   // private String evaluationStatus;


    public String getCivility() {
        return civility;
    }

    public void setCivility(String civility) {
        this.civility = civility;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
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

    public byte[] getEquivalence() {
        return this.equivalence;
    }

    public void setEquivalence(byte[] equivalence){
        this.equivalence = equivalence;
    }

   public byte[] getCv() {
        return cv;
    }

    public void setCv(byte[] cv) {
        this.cv = cv;
    }

    public byte[] getApplicationDemande() {
        return applicationDemande;
    }

    public void setApplicationDemande(byte[] applicationDemande) {
        this.applicationDemande = applicationDemande;
    }

    public String getPhdType() {
        return phdType;
    }

    public void setPhdType(String PhdType) {
        this.phdType = PhdType;
    }

    public byte[] getPhdDiplome() {
        return phdDiplome;
    }

    public void setPhdDiplome(byte[] phdDiplome) {
        this.phdDiplome = phdDiplome;
    }

    public byte[] getHabilitationDiplome() {
        return habilitationDiplome;
    }

    public void setHabilitationDiplome(byte[] habilitationDiplome) {
        this.habilitationDiplome = habilitationDiplome;
    }

    public byte[] getArretNomination() {
        return arretNomination;
    }

    public void setArretNomination(byte[] arretNomination) {
        this.arretNomination = arretNomination;
    }

    public byte[] getAttestation() {
        return attestation;
    }

    public void setAttestation(byte[] attestation) {
        this.attestation = attestation;
    }

    /*public String getEvaluationStatus() {
        return evaluationStatus;
    }

    public void setEvaluationStatus(String evaluationStatus) {
        this.evaluationStatus = evaluationStatus;
    }*/

    // Getter pour professor
    public User getUser() {
        return user;
    }

    // Setter pour professor
    public void setUser(User user) {
        this.user = user;
    }
}

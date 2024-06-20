package com.pfa.PFABackend.dto;

public class ProfessorDTO {

        private String firstname;
        private String lastname;
        private String email;
        private String phone;
        private String profile;
        private String establishment;
        private String evaluationStatus;

        // Getters and Setters

        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getProfile() {
            return profile;
        }

        public void setProfile(String profile) {
            this.profile = profile;
        }

        public String getEstablishment() {
            return establishment;
        }

        public void setEstablishment(String establishment) {
            this.establishment = establishment;
        }

        public String getEvaluationStatus() {
            return evaluationStatus;
        }

        public void setEvaluationStatus(String evaluationStatus) {
            this.evaluationStatus = evaluationStatus;
        }
    }


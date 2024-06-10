package com.pfa.PFABackend;

public class ProfessorNotFoundException extends Exception {

    public ProfessorNotFoundException() {
        super("Professor not found.");
    }

    public ProfessorNotFoundException(String message) {
        super(message);
    }

    // Ajoutez d'autres constructeurs ou méthodes si nécessaire
}
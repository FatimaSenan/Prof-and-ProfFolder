package com.pfa.PFABackend.Service;

import com.pfa.PFABackend.Model.ProfessorFolder;

public interface ProfessorFolderService {
    public String addProfessorFolder(ProfessorFolder professorFolder);

    public ProfessorFolder getProfessorFolderByUser(String userEmail);

    public byte[] getEquivalencePdfForSelectedUser(int professorFolderId, String userEmail);
    public byte[] getCVPdfForSelectedUser(int professorFolderId, String userEmail);

    public byte[] getApplicationDemandePdfForSelectedUser(int professorFolderId, String userEmail);

    public byte[] getPhdDiplomePdfForSelectedUser(int professorFolderId, String userEmail);

    public byte[] getHabilitationDiplomePdfForSelectedUser(int professorFolderId, String userEmail);

    public byte[] getArretNominationPdfForSelectedUser(int professorFolderId, String userEmail);

    public byte[] getAttestationPdfForSelectedUser(int professorFolderId, String userEmail);
}

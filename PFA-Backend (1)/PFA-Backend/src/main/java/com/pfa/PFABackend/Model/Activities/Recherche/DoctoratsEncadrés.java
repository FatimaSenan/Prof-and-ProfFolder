package com.pfa.PFABackend.Model.Activities.Recherche;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class DoctoratsEncadrés {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "activity_name")
    private String activityName;

    @Column(name = "activity_points")
    private double activityPoints;

    private String status;

    @Column(name = "date_inscription")
    private String datePremièreInscription;

    private String sujet;

    @Column(name = "formation_doctorale")
    private String formationDoctorale;

    private String laboratoire;

    private String doctorant;

    @Column(name = "directeur_these")
    private String directeurThèse;

    @Column(name = "date_soutenance")
    private String dateSoutenance;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] justification;

    @ManyToOne
    @JoinColumn(name="activity_subtype2_id")
    @JsonBackReference
    private ActivitySubType2 activitySubType2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
   // @JsonBackReference
    private User user;
}

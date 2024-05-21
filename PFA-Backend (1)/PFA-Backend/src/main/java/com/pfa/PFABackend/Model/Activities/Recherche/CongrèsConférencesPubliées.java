package com.pfa.PFABackend.Model.Activities.Recherche;

import com.pfa.PFABackend.Model.ActivitySubType2;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CongrèsConférencesPubliées {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "activity_name")
    private String activityName;

    @Column(name = "activity_points")
    private double activityPoints;

    private String type;

    @Column(name = "nom_conference")
    private String nomConference;

    @Column(name = "année_conference")
    private int annéeConference;

    private String lien;

    @Column(name = "titre_communication")
    private String titreCommunication;

    private String auteurs;

    private byte[] justification;

    @OneToOne
    @JoinColumn(name="activity_subtype2_id")
    private ActivitySubType2 activitySubType2;
}

package com.pfa.PFABackend.Model.Activities.Recherche;

import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CongrèsConférencesNonPubliées {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "activity_name")
    private String activityName;

    @Column(name = "activity_points")
    private double activityPoints;

    @Column(name = "nom_conference")
    private String nomConference;

    @Column(name = "année_conference")
    private int annéeConference;

    private String lien;

    @Column(name = "titre_communication")
    private String titreCommunication;

    private String auteurs;

    private byte[] justification;

    @ManyToOne
    @JoinColumn(name="activity_subtype2_id")
    private ActivitySubType2 activitySubType2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}

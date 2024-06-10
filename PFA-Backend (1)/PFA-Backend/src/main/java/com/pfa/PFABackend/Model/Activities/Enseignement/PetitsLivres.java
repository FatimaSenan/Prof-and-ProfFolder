package com.pfa.PFABackend.Model.Activities.Enseignement;

import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PetitsLivres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_livre")
    private int idLivre;

    @Column(name="activity_name")
    private String activityName;

    @Column(name="activity_points")
    private double activityPoints = 1;

    @Column(name = "titre_livre")
    private String titreLivre;

    private String auteurs;

    @Column(name="année_publication")
    private  int annéePublication;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] justification;

    @OneToOne
    @JoinColumn(name="activity_subtype2_id")
    private ActivitySubType2 activitySubType2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}

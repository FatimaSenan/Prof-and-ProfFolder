package com.pfa.PFABackend.Model.Activities.Enseignement;

import com.pfa.PFABackend.Model.Activities.EnumTypes.TypeCommissionAdHoc;
import com.pfa.PFABackend.Model.ActivitySubType2;
import com.pfa.PFABackend.Model.User;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class MembreCommissionAdHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "activity_name")
    private String activityName;
    @Column(name = "activity_points")
    private double activityPoints = 0.75;

    private String typeCommissionAdHoc;

    private int année;

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

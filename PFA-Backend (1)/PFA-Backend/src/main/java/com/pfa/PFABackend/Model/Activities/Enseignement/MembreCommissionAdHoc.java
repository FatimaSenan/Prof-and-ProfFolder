
package com.pfa.PFABackend.Model.Activities.Enseignement;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @Column(name = "points_attribués")
    private double pointsAttribués = 0;

    private String typeCommissionAdHoc;

    private int année;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] justification;

    @ManyToOne
    @JoinColumn(name="activity_subtype2_id")
    @JsonBackReference
    private ActivitySubType2 activitySubType2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;
}

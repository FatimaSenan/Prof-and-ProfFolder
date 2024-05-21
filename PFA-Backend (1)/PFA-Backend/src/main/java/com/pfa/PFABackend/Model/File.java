package com.pfa.PFABackend.Model;

import com.pfa.PFABackend.Model.Activities.Enseignement.ChefDépartement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "files")
@NoArgsConstructor
@AllArgsConstructor
//@RequiredArgsConstructor
@Data
public class File {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    private String name;

    private String type;

    @Lob
    private byte[] data;

   /* @OneToOne(mappedBy = "file")
    private ChefDépartement chefDépartement;

    */
}

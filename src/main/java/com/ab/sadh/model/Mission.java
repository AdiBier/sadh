package com.ab.sadh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
import java.util.List;
=======
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
>>>>>>> c4b6c9a2f9b76a194a3e0f08791818bb414f9e09

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Mission {

    @Id
<<<<<<< HEAD
    @Column(name = "Name", nullable = false, unique = true, length = 32)
    private String name;

    @NotEmpty
    @Column(name = "ImageType")
    private String imageType;

    @Column(name = "StartDate")
    private Timestamp startDate;

    @Column(name = "FinishDate")
    private Timestamp finishDate;

    @OneToMany(mappedBy = "mission")
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "UserId")
    private Users user;

=======
    @Column(nullable = false, unique = true, length = 32)
    private String name;

    @NotEmpty
    private String imageType;

    private Timestamp startDate;

    private Timestamp finishDate;

>>>>>>> c4b6c9a2f9b76a194a3e0f08791818bb414f9e09
}

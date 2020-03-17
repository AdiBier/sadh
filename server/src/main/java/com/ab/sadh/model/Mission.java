package com.ab.sadh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Missions", uniqueConstraints = @UniqueConstraint(columnNames = {"Name"}))
public class Mission {

    @Id
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

}

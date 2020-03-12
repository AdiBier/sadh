package com.ab.sadh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Mission {

    @Id
    @Column(nullable = false, unique = true, length = 32)
    private String name;

    @NotEmpty
    private String imageType;

    private Timestamp startDate;

    private Timestamp finishDate;

}

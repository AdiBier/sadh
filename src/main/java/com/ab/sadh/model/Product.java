package com.ab.sadh.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;

@Entity
@Data
<<<<<<< HEAD
@NoArgsConstructor
@AllArgsConstructor
=======
@AllArgsConstructor
@NoArgsConstructor
>>>>>>> c4b6c9a2f9b76a194a3e0f08791818bb414f9e09
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    @Column(name = "ProductId", updatable = false, nullable = false, unique = true)
    private Long productId;

    @NotEmpty
    @Column(name = "ProductAcquisitionDate")
    private Timestamp productAcquisitionDate;

    @NotEmpty
    @Column(name = "Coords")
    private Point coords;

    @NotEmpty
    @Column(name = "Price")
    private Double price;

    @Column(name = "ProductUrl")
    private String productUrl;

    @ManyToOne
    @JoinColumn(name = "MissionName")
    private Mission mission;

    @ManyToOne
    @JoinColumn(name = "UserId")
    private Users user;
=======
    @Column(updatable = false, nullable = false, unique = true)
    private Long productId;

    @NotEmpty
    private Timestamp productAcquisitionDate;

    @NotEmpty
    private Point coords;

    @NotEmpty
    private Double price;

    private String productUrl;
>>>>>>> c4b6c9a2f9b76a194a3e0f08791818bb414f9e09
}

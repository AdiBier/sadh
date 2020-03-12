package com.ab.sadh.repository;

import com.ab.sadh.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {

    Product findByProductId(Long id);

    Optional<Product> findOptionalByProductId(Long id);

    Product findByProductAcquisitionDateIsBefore(Timestamp productAcquisitionDateIsBefore);

    Product findByProductAcquisitionDateIsAfter(Timestamp productAcquisitionIsAfter);

    List<Product> findByProductAcquisitionDateIsBetween(Timestamp productAcquisitionDateFrom, Timestamp productAcquisitionDateTo);
}

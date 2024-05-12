package com.nps.repository;

import com.nps.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);
    List<Product> findByTitle(String title);
    List<Product> findByTitleContains(String str);
    List<Product> findByTitleAndDescription(String title, String description);
    Optional<Product> findByImage(String url);
    void delete(Product product);

    @Override
    List<Product> findAll();

    @Query("select p from Product p where p.id=:id")
    Product myQuery(@Param("id") Long id);
}

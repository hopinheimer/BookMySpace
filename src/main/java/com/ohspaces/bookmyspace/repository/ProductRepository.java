package com.ohspaces.bookmyspace.repository;

import com.ohspaces.bookmyspace.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    @Query(nativeQuery = true, value = "select * from product where is_active =true")
    List<ProductEntity> findAllByActive();
}

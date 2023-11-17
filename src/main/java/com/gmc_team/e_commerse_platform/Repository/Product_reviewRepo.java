package com.gmc_team.e_commerse_platform.Repository;

import com.gmc_team.e_commerse_platform.models.Product;
import com.gmc_team.e_commerse_platform.models.Product_review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Product_reviewRepo extends JpaRepository<Product_review ,Long> {
    List<Product_review> findAllByRating(Integer rating);
    Product_review findByProduct(Product rating);
    Product_review findByCustomerid(Long rating);
    Product_review findByCustomeridAndProduct(Long rating ,Long product);
}

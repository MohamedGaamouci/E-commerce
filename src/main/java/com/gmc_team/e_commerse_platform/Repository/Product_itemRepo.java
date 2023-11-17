package com.gmc_team.e_commerse_platform.Repository;

import com.gmc_team.e_commerse_platform.models.Product;
import com.gmc_team.e_commerse_platform.models.Product_item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Product_itemRepo extends JpaRepository<Product_item ,Long> {
    List<Product_item> findAllByProduct(Product product);
}

package com.gmc_team.e_commerse_platform.Repository;

import com.gmc_team.e_commerse_platform.models.Category;
import com.gmc_team.e_commerse_platform.models.Product;
import com.gmc_team.e_commerse_platform.models.Product_item;
import com.gmc_team.e_commerse_platform.models.SKU;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product ,Long> {
    List<Product> findByName(String Name);
    List<Product> findAllBySku(SKU sku);
    List<Product> findAllByCategory(Category category);
    Product findByProductitemsContaining(Product_item dto);
    void deleteAllByOnlineshop(Long Id);

}

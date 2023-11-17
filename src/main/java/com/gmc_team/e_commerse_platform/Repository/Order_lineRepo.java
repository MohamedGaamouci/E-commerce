package com.gmc_team.e_commerse_platform.Repository;

import com.gmc_team.e_commerse_platform.models.Order_line;
import com.gmc_team.e_commerse_platform.models.Product_item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Order_lineRepo extends JpaRepository<Order_line ,Long> {
    List<Order_line> findAllByProductitem(Product_item item);
    List<Order_line> findByProductitem(Product_item item);
}

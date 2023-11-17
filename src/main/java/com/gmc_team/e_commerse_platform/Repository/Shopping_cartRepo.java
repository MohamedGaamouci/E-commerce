package com.gmc_team.e_commerse_platform.Repository;

import com.gmc_team.e_commerse_platform.models.Customers;
import com.gmc_team.e_commerse_platform.models.Shopping_cart;
import com.gmc_team.e_commerse_platform.models.Shopping_cart_item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Shopping_cartRepo extends JpaRepository<Shopping_cart,Long> {
    List<Shopping_cart> findAllByCustomers(Customers customers);
    Shopping_cart findByShoppinglistContaining(Shopping_cart_item item);

}

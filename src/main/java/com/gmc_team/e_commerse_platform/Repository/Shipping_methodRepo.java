package com.gmc_team.e_commerse_platform.Repository;

import com.gmc_team.e_commerse_platform.models.Shipping_method;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface Shipping_methodRepo extends JpaRepository<Shipping_method ,Long> {
    Shipping_method findAllByName(String Name);
    Shipping_method findAllByCustomerorder(Long Id);
    Shipping_method findByName(String name);
}

package com.gmc_team.e_commerse_platform.Repository;

import com.gmc_team.e_commerse_platform.models.Customers;
import com.gmc_team.e_commerse_platform.models.Online_shop_review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Online_shop_reviewRepo extends JpaRepository<Online_shop_review ,Long> {
    Online_shop_review findByCustomersid(Customers Id);
    List<Online_shop_review> findAllByOnlineshop(Long Id);
    Online_shop_review findByCustomersidAndOnlineshop(Customers customers ,Long onlineShop);

}

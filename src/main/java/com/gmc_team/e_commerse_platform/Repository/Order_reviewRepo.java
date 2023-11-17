package com.gmc_team.e_commerse_platform.Repository;

import com.gmc_team.e_commerse_platform.models.Order;
import com.gmc_team.e_commerse_platform.models.Order_review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Order_reviewRepo extends JpaRepository<Order_review ,Long> {
    Order_review findByCustomerid(Long Id);
    List<Order_review> findByRating(Integer rating);
    Order_review findByCustomerorder(Order order);
}

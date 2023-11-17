package com.gmc_team.e_commerse_platform.Repository.Promotion_types;

import com.gmc_team.e_commerse_platform.models.promotion_types.Order_discount_promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Order_discount_promotionRepo extends JpaRepository<Order_discount_promotion ,Long> {
}

package com.gmc_team.e_commerse_platform.Repository.Promotion_types;

import com.gmc_team.e_commerse_platform.models.promotion_types.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepo extends JpaRepository<Promotion ,Long> {
}

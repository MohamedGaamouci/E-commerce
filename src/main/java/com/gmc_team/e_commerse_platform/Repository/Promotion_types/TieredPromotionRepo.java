package com.gmc_team.e_commerse_platform.Repository.Promotion_types;

import com.gmc_team.e_commerse_platform.models.promotion_types.TieredPromotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TieredPromotionRepo extends JpaRepository<TieredPromotion ,Long> {
}

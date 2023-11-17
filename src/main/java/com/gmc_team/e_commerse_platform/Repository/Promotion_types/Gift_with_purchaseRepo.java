package com.gmc_team.e_commerse_platform.Repository.Promotion_types;

import com.gmc_team.e_commerse_platform.models.promotion_types.Gift_with_purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Gift_with_purchaseRepo extends JpaRepository<Gift_with_purchase,Long> {
}

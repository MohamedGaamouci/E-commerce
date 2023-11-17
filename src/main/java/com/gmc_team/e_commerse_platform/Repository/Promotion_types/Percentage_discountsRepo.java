package com.gmc_team.e_commerse_platform.Repository.Promotion_types;

import com.gmc_team.e_commerse_platform.models.promotion_types.Percentage_discounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Percentage_discountsRepo extends JpaRepository<Percentage_discounts,Long> {
}

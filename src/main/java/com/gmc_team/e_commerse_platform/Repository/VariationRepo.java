package com.gmc_team.e_commerse_platform.Repository;

import com.gmc_team.e_commerse_platform.models.Variation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VariationRepo extends JpaRepository<Variation ,Long> {
    Variation findByName(String name);
}

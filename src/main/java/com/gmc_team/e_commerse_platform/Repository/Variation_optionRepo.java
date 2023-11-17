package com.gmc_team.e_commerse_platform.Repository;

import com.gmc_team.e_commerse_platform.models.Variation;
import com.gmc_team.e_commerse_platform.models.Variation_option;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Variation_optionRepo extends JpaRepository<Variation_option,Long> {
    List<Variation_option>findAllByVariation(Variation variation);
    Variation_option findByOptionvalueAndVariation(String option ,Variation variation);
}

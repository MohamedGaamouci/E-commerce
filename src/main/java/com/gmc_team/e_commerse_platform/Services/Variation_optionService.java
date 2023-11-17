package com.gmc_team.e_commerse_platform.Services;

import com.gmc_team.e_commerse_platform.Dto.Variation_optionDto;

import java.util.List;

public interface Variation_optionService {
    Variation_optionDto findById(Long Id);
    Variation_optionDto save(Variation_optionDto dto);
    List<Variation_optionDto> findByVariationId(Long Id);
    Variation_optionDto findByOption_value(String option_value ,Long VariationOptionId);
    void delete(Long varId);

}

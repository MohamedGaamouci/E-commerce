package com.gmc_team.e_commerse_platform.Controllers;

import com.gmc_team.e_commerse_platform.Controllers.Api.Variation_optionApi;
import com.gmc_team.e_commerse_platform.Dto.Variation_optionDto;
import com.gmc_team.e_commerse_platform.Services.ServiceImpl.Variation_optionServiceImpl;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Variation_optionController implements Variation_optionApi {
    private final Variation_optionServiceImpl variation_optionServiceImpl;

    public Variation_optionController(Variation_optionServiceImpl variation_optionServiceImpl) {
        this.variation_optionServiceImpl = variation_optionServiceImpl;
    }

    @Override
    public Variation_optionDto findById(Long Id) {
        return variation_optionServiceImpl.findById(Id);
    }

    @Override
    public Variation_optionDto save(Variation_optionDto dto) {
        return variation_optionServiceImpl.save(dto);
    }

    @Override
    public List<Variation_optionDto> findByVariationId(Long Id) {
        return variation_optionServiceImpl.findByVariationId(Id);
    }

    @Override
    public Variation_optionDto findByOption_value(String option_value ,Long VariationId) {
        return variation_optionServiceImpl.findByOption_value(option_value ,VariationId);
    }

    @Override
    public void delete(Long Var_Id) {
        variation_optionServiceImpl.delete(Var_Id);
    }
}

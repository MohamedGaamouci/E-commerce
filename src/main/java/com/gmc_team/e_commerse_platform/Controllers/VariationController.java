package com.gmc_team.e_commerse_platform.Controllers;

import com.gmc_team.e_commerse_platform.Controllers.Api.VariationApi;
import com.gmc_team.e_commerse_platform.Dto.VariationDto;
import com.gmc_team.e_commerse_platform.Services.ServiceImpl.VariationServiceImpl;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VariationController implements VariationApi {
    private final VariationServiceImpl variationServiceImpl;

    public VariationController(VariationServiceImpl variationServiceImpl) {
        this.variationServiceImpl = variationServiceImpl;
    }

    @Override
    public VariationDto findById(Long Id) {
        return variationServiceImpl.findById(Id);
    }

    @Override
    public VariationDto save(VariationDto dto) {
        return variationServiceImpl.save(dto);
    }

    @Override
    public VariationDto findByName(String Name) {
        return variationServiceImpl.findByName(Name);
    }

    @Override
    public List<VariationDto> findByAll() {
        return variationServiceImpl.findAll();
    }

    @Override
    public void delete(Long Var_Id) {
        variationServiceImpl.delete(Var_Id);
    }
}

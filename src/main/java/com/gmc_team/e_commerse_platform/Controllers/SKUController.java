package com.gmc_team.e_commerse_platform.Controllers;

import com.gmc_team.e_commerse_platform.Controllers.Api.SKUApi;
import com.gmc_team.e_commerse_platform.Dto.SKUDto;
import com.gmc_team.e_commerse_platform.Services.ServiceImpl.SKUServiceImpl;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SKUController implements SKUApi {
    private final com.gmc_team.e_commerse_platform.Services.ServiceImpl.SKUServiceImpl SKUServiceImpl;

    public SKUController(SKUServiceImpl SKUServiceImpl) {
        this.SKUServiceImpl = SKUServiceImpl;
    }

    @Override
    public SKUDto findById(Long Id) {
        return SKUServiceImpl.findById(Id);
    }

    @Override
    public SKUDto save(SKUDto dto) {
        return SKUServiceImpl.save(dto);
    }

    @Override
    public SKUDto findByName(String Name) {
        return SKUServiceImpl.findByName(Name);
    }

    @Override
    public List<SKUDto> findByNameStartwith(String Name) {
        return SKUServiceImpl.findByNameStartwith(Name);
    }

    @Override
    public List<SKUDto> findByNameContaining(String Name) {
        return SKUServiceImpl.findByNameContaining(Name);
    }

    @Override
    public List<SKUDto> findAll() {
        return SKUServiceImpl.findAll();
    }

    @Override
    public void delete(Long SKU_Id) {
        SKUServiceImpl.delete(SKU_Id);
    }

}

package com.gmc_team.e_commerse_platform.Controllers;

import com.gmc_team.e_commerse_platform.Controllers.Api.DescriptionApi;
import com.gmc_team.e_commerse_platform.Dto.DescriptionsDto;
import com.gmc_team.e_commerse_platform.Services.ServiceImpl.DescriptionServiceImpl;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DescriptionController implements DescriptionApi {
    private final DescriptionServiceImpl descriptionServiceImpl;

    public DescriptionController(DescriptionServiceImpl descriptionServiceImpl) {
        this.descriptionServiceImpl = descriptionServiceImpl;
    }

    @Override
    public DescriptionsDto findById(Long Id) {
        return descriptionServiceImpl.findById(Id);
    }

    @Override
    public DescriptionsDto save(DescriptionsDto dto) {
        return descriptionServiceImpl.save(dto);
    }

    @Override
    public List<DescriptionsDto> findAll() {
        return descriptionServiceImpl.findAll();
    }

    @Override
    public List<DescriptionsDto> findByOnline_shopId(Long Id) {
        return descriptionServiceImpl.findByOnline_shopId(Id);
    }

    @Override
    public List<DescriptionsDto> findByTitle(String title) {
        return descriptionServiceImpl.findByTitle(title);
    }

}

package com.gmc_team.e_commerse_platform.Services;

import com.gmc_team.e_commerse_platform.Dto.DescriptionsDto;

import java.util.List;

public interface DescriptionService {
    DescriptionsDto findById(Long Id);
    DescriptionsDto save(DescriptionsDto dto);

    List<DescriptionsDto> findAll();
    List<DescriptionsDto> findByOnline_shopId(Long Id);
    List<DescriptionsDto> findByTitle(String title);
    void delete(Long descriptionId);

}

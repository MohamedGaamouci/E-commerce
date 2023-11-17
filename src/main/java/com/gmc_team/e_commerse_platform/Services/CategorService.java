package com.gmc_team.e_commerse_platform.Services;

import com.gmc_team.e_commerse_platform.Dto.CategoryDto;

import java.util.List;

public interface CategorService {
    CategoryDto save(CategoryDto dto);

    CategoryDto findById(Long Id);

    CategoryDto findByName(String Name);

    List<CategoryDto> findAll();
    List<CategoryDto> findByParent_Category(Long Paret_CatId);

    void delete(Long id);
    List<CategoryDto> findAllByOnlineStore(Long Id);
}

package com.gmc_team.e_commerse_platform.Controllers;

import com.gmc_team.e_commerse_platform.Controllers.Api.CategoryApi;
import com.gmc_team.e_commerse_platform.Dto.CategoryDto;
import com.gmc_team.e_commerse_platform.Services.ServiceImpl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController implements CategoryApi {
    private CategoryServiceImpl categoryService;

    @Autowired
    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public CategoryDto save(CategoryDto dto) {
        return categoryService.save(dto);
    }

    @Override
    public CategoryDto findById(Long Id) {
        return categoryService.findById(Id);
    }

    @Override
    public CategoryDto findByName(String Name) {
        return categoryService.findByName(Name);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @Override
    public List<CategoryDto> findByParent_Category(Long Id) {
        return categoryService.findByParent_Category(Id);
    }

    @Override
    public void delete(Long Id) {
        categoryService.delete(Id);
    }
}

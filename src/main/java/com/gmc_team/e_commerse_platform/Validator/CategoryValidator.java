package com.gmc_team.e_commerse_platform.Validator;

import com.gmc_team.e_commerse_platform.Dto.CategoryDto;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {
    public static List<String> Validate(CategoryDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Please fill the Name");
            errors.add("Please fill the Categoty Description");
            errors.add("Please fill the Online store Id");
        }else{
            if (dto.getOnlineshop()== null){
                errors.add("Please fill the Online store Id");
            }
        if(dto.getName() == null|| dto.getName().isBlank()){
            errors.add("Please fill the Category Name");
        }
        if(dto.getDescription() == null ||dto.getDescription().isBlank()){
            errors.add("Please fill the Categoty Description");
        }if(dto.getParent_category() != null && dto.getParent_category().getId() == null ){
            errors.addAll(CategoryValidator.Validate(dto.getParent_category()));
            }

        }

        return errors;
    }
}

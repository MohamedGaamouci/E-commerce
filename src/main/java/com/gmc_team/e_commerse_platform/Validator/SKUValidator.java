package com.gmc_team.e_commerse_platform.Validator;

import com.gmc_team.e_commerse_platform.Dto.SKUDto;

import java.util.ArrayList;
import java.util.List;

public class SKUValidator {
    public static List<String> validate(SKUDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Please fill the SKU Name ");
            errors.add("Please fill the Online store Id");

        }else {
            if (dto.getOnlineshop()== null){
                errors.add("Please fill the Online store Id");
            }
            if(dto.getName()==null || dto.getName().isBlank()){
                errors.add("Please fill the SKU Name ");
            }

        }
        return errors;
    }
}

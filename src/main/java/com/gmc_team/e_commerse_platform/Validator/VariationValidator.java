package com.gmc_team.e_commerse_platform.Validator;

import com.gmc_team.e_commerse_platform.Dto.VariationDto;

import java.util.ArrayList;
import java.util.List;

public class VariationValidator {
    public static List<String> Validate(VariationDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Please fill the variation Name ");
            errors.add("Please fill the Online store Id");

        }else {
            if (dto.getOnline_shop()== null){
                errors.add("Please fill the Online store Id");
            }
            if(dto.getName() == null ||dto.getName().isBlank()){
                errors.add("Please fill the variation Name ");
            }

        }
        return errors;
    }
}

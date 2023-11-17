package com.gmc_team.e_commerse_platform.Validator;

import com.gmc_team.e_commerse_platform.Dto.PlatformDto;

import java.util.ArrayList;
import java.util.List;

public class PlatformValidator {
    public static List<String> Validate(PlatformDto dto) {
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("The platfomr owner is missing");
            errors.add("The platfomr brand_name is missing");
        }else{
            if(dto.getOwner() == null){
                errors.add("The platfomr owner is missing");
            }
            if(dto.getBrand_name().isBlank()){
                errors.add("The platfomr brand_name is missing");
            }
        }

        return errors;
    }
}

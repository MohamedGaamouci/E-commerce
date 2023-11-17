package com.gmc_team.e_commerse_platform.Validator;

import com.gmc_team.e_commerse_platform.Dto.DescriptionsDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DescriptionsValidator {
    public static List<String> Validate(DescriptionsDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Please fill the title");
            errors.add("Please fill the description");

        }else {

            if(!(StringUtils.hasLength(dto.getTitle()))){
                errors.add("Please fill the title");
            }
            if(!(StringUtils.hasLength(dto.getDescription()))){
                errors.add("Please fill the description");
            }
        }
        return errors;
    }
}

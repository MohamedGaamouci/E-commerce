package com.gmc_team.e_commerse_platform.Validator;

import com.gmc_team.e_commerse_platform.Dto.Variation_optionDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Variation_optionValidator {
    public static List<String> Validate(Variation_optionDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Please sellect the variation ");
            errors.add("Please fill the variation option ");
            errors.add("Please fill the Online store Id");

        }else {
            if (dto.getOnline_shop()== null){
                errors.add("Please fill the Online store Id");
            }
            if(dto.getVariation() == null||dto.getVariation().getId() == null){
                errors.add("Please sellect the variation ");
            }
            if(!(StringUtils.hasLength(dto.getOption_value()))){
                errors.add("Please fill the variation option ");
            }

        }
        return errors;
    }
}

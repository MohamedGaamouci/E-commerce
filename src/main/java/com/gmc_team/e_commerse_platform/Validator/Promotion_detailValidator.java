package com.gmc_team.e_commerse_platform.Validator;

import com.gmc_team.e_commerse_platform.Dto.Promotion_detailDto;

import java.util.ArrayList;
import java.util.List;

public class Promotion_detailValidator {
    public static List<String> Validate(Promotion_detailDto dto) {
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Please fill the promotion Type");
            errors.add("Please fill the promotion id");

        }else {
            if (dto.getType() == null){
                errors.add("Please fill the promotion Type");
            }
            if (dto.getPromotion() == null){
                errors.add("Please fill the promotion id");
            }

        }
        return errors;
    }
}

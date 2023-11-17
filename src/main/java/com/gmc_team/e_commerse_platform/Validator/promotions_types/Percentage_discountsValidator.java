package com.gmc_team.e_commerse_platform.Validator.promotions_types;

import com.gmc_team.e_commerse_platform.Dto.promotion_types.Percentage_discountsDto;

import java.util.ArrayList;
import java.util.List;

public class Percentage_discountsValidator {
    public static List<String> validate(Percentage_discountsDto dto){
        List<String> errors = new ArrayList<>();

        if (dto == null){
            errors.add("please enter the minimum item number should bye");
            errors.add("please enter the discount percentage");
        }else{
            if (dto.getTargetproductsid() == null){
                errors.add("please select the target product");
            }
            if (dto.getDiscountPercentage() == null){
                errors.add("please enter the discount percentage");
            }
        }
        return errors;
    }
}

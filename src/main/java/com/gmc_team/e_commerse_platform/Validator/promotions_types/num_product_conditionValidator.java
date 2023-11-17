package com.gmc_team.e_commerse_platform.Validator.promotions_types;

import com.gmc_team.e_commerse_platform.Dto.promotion_types.num_product_conditionDto;

import java.util.ArrayList;
import java.util.List;

public class num_product_conditionValidator {
    public static List<String> validate(num_product_conditionDto dto){
        List<String> errors = new ArrayList<>();

        if (dto == null){
            errors.add("please choose the product");
            errors.add("please fill the Qte");
        }else{
            if (dto.getProductid() == null){
                errors.add("please choose the product");
            }
            if (dto.getQte() == null){
                errors.add("please fill the Qte");
            }
        }
        return errors;
    }
}

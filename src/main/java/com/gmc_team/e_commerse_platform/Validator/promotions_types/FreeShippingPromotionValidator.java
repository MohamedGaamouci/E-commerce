package com.gmc_team.e_commerse_platform.Validator.promotions_types;

import com.gmc_team.e_commerse_platform.Dto.promotion_types.FreeShippingPromotionDto;

import java.util.ArrayList;
import java.util.List;

public class FreeShippingPromotionValidator {
    public static List<String> validate(FreeShippingPromotionDto dto){
        List<String> errors = new ArrayList<>();

        if (dto == null){
            errors.addAll(PromotionValidator.validate(null));
            errors.add("please enter the minimum order amount");
        }else{
            errors.addAll(PromotionValidator.validate(dto.getPromotion(dto)));
            if (dto.getMinimumorderamount() == null){
                errors.add("please enter the minimum order amount");
            }
        }
        return errors;
    }
}

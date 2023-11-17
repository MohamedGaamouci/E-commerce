package com.gmc_team.e_commerse_platform.Validator.promotions_types;

import com.gmc_team.e_commerse_platform.Dto.promotion_types.Order_discount_promotionDto;

import java.util.ArrayList;
import java.util.List;

public class Order_discount_promotionValidator {
    public static List<String> validate(Order_discount_promotionDto dto){
        List<String> errors = new ArrayList<>();

        if (dto == null){
            errors.add("please sellect the minimum item number should bye");
            errors.add("please enter the discount percentage");
        }else{
            if (dto.getMinimumitem() == null){
                errors.add("please sellect the minimum item number should bye");
            }
            if (dto.getDiscountpercentage() == null){
                errors.add("please enter the discount percentage");
            }
            errors.addAll(PromotionValidator.validate(dto.getPromotion(dto)));
        }
        return errors;
    }
}

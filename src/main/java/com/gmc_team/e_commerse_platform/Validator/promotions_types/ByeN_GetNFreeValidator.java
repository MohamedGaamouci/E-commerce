package com.gmc_team.e_commerse_platform.Validator.promotions_types;

import com.gmc_team.e_commerse_platform.Dto.promotion_types.ByeN_GetNFreeDto;

import java.util.ArrayList;
import java.util.List;

public class ByeN_GetNFreeValidator {
    public static List<String> validate(ByeN_GetNFreeDto dto){
        List<String> errors = new ArrayList<>();

        if (dto == null){
            errors.addAll(PromotionValidator.validate(null));
            errors.add("please choose the number of the product should bye");
            errors.add("please choose the number of the product will gifted");
        }else{
            if (dto.getProductshouldbye() == null||dto.getProductshouldbye().equals(0)){
                errors.add("please choose the number of the product should bye");
            }
            if (dto.getFreeproductwillget() == null||dto.getProductshouldbye().equals(0)){
                errors.add("please choose the number of the product will gifted");
            }
            if (dto.getTargetproduct().isEmpty()){
                errors.add("please choose the taret product");
            }
            errors.addAll(PromotionValidator.validate(dto.getPromotion(dto)));
        }
        return errors;
    }
}

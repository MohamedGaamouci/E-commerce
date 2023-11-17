package com.gmc_team.e_commerse_platform.Validator.promotions_types;

import com.gmc_team.e_commerse_platform.Dto.promotion_types.TieredPromotionItemDto;

import java.util.ArrayList;
import java.util.List;

public class TieredPromotionItemValidator {
    public static List<String> validate(TieredPromotionItemDto dto){
        List<String> errors = new ArrayList<>();
        if (dto == null){
            errors.add("You should enter the price");
            errors.add("You should sellect the promotion");
        }else{
            if (dto.getConditionnal_price() == null){
                errors.add("You should enter the price");
            }
            if (dto.getPromotionid() == null){
                errors.add("You should sellect the promotion");
            }
        }
        return errors;
    }
}

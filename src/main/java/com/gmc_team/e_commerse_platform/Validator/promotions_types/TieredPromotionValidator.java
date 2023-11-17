package com.gmc_team.e_commerse_platform.Validator.promotions_types;

import com.gmc_team.e_commerse_platform.Dto.promotion_types.TieredPromotionDto;

import java.util.ArrayList;
import java.util.List;

public class TieredPromotionValidator {
    public static List<String> validate(TieredPromotionDto dto){
        List<String> errors = new ArrayList<>();
        if (dto == null){
            errors.add("You should fill the Tiers");
        }else{
            if (dto.getTiers() == null||dto.getTiers().isEmpty()){
                errors.add("You should fill the Tiers");
            }else{
                dto.getTiers().stream()
                        .map(t->errors.addAll(TieredPromotionItemValidator.validate(t)));
            }
        }
        return errors;
    }
}

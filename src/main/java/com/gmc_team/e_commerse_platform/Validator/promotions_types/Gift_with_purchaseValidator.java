package com.gmc_team.e_commerse_platform.Validator.promotions_types;

import com.gmc_team.e_commerse_platform.Dto.promotion_types.Gift_with_purchaseDto;

import java.util.ArrayList;
import java.util.List;

public class Gift_with_purchaseValidator {
    public static List<String> validate(Gift_with_purchaseDto dto){
        List<String> errors = new ArrayList<>();

        if (dto == null){
            errors.add("please fill the conditionnal information");
            errors.add("please fill the gift information");
        }else{
            if (dto.getConditionallproduct() == null||dto.getConditionallproduct().isEmpty()){
                errors.add("please fill the conditionnal information");
            }else{
                dto.getConditionallproduct().stream()
                        .map(g->errors.addAll(num_product_conditionValidator.validate(g)));
            }
            if (dto.getGift() == null || dto.getGift().isEmpty()){
                errors.add("please fill the gift information");
            }else {
                dto.getGift().stream().map(g->errors.addAll(GiftValidator.validate(g)));
            }
        }
        return errors;
    }
}

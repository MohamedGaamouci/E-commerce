package com.gmc_team.e_commerse_platform.Validator.promotions_types;

import com.gmc_team.e_commerse_platform.Dto.promotion_types.PromotionDto;

import java.util.ArrayList;
import java.util.List;

public class PromotionValidator {
    public static List<String> validate(PromotionDto dto){
        List<String> errors = new ArrayList<>();
        if (dto == null){
            errors.add("You should choose the promotion type");
            errors.add("You should enter the promotion name");
            errors.add("You should choose the start date");
            errors.add("You should choose the end date");
            errors.add("You should the online store id");
        }else{
            if (dto.getPromotiontype() == null){
                errors.add("You should choose the promotion type");
            }
            if (dto.getName() == null || dto.getName().isBlank()){
                errors.add("You should enter the promotion name");
            }
            if (dto.getStartdate() == null){
                errors.add("You should choose the start date");
            }
            if (dto.getEnddate() == null){
                errors.add("You should choose the end date");
            }
            if (dto.getOnlineshopid() == null){
                errors.add("You should the online store id");
            }
        }
        return errors;
    }
}

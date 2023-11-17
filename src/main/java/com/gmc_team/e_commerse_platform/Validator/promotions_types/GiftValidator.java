package com.gmc_team.e_commerse_platform.Validator.promotions_types;

import com.gmc_team.e_commerse_platform.Dto.promotion_types.GiftDto;

import java.util.ArrayList;
import java.util.List;

public class GiftValidator {
    public static List<String> validate(GiftDto dto){
        List<String> errors = new ArrayList<>();

        if (dto == null){
            errors.add("please fill the gift name");
            errors.add("please fill the description");
        }else{
            if (dto.getGiftname() == null){
                errors.add("please fill the gift name");
            }

        }
        return errors;
    }
}

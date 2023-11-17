package com.gmc_team.e_commerse_platform.Validator;

import com.gmc_team.e_commerse_platform.Dto.Online_shop_reviewDto;

import java.util.ArrayList;
import java.util.List;

public class Online_shop_reviewValidator {
    public static List<String> Validate(Online_shop_reviewDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Please sellect the customer id ");
            errors.add("Please enter rating ");
            errors.add("Please fill the Online store Id");
        }else {
            if (dto.getOnline_shop_idDto()== null){
                errors.add("Please fill the Online store Id");
            }
            if(dto.getStore_rating() == null){
                errors.add("Please enter the store rating");
            }
            if(dto.getCustomers_idDto() == null ){
                errors.add("Please select an customer");
            }
        }
        return errors;
    }
}

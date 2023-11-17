package com.gmc_team.e_commerse_platform.Validator;

import com.gmc_team.e_commerse_platform.Dto.Order_reviewDto;

import java.util.ArrayList;
import java.util.List;

public class Order_reviewValidator {
    public static List<String> Validate(Order_reviewDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Please sellect the customer id ");
            errors.add("Please sellect the Order ");
            errors.add("Please enter a rating ");
            errors.add("Please fill the Online store Id");
        }else {
            if (dto.getOnline_shop()== null){
                errors.add("Please fill the Online store Id");
            }
            if(dto.getCustomer_id() == null){
                errors.add("Please sellect the customer id ");
            }
            if(dto.getCustomer_orderDto() == null){
                errors.add("Please sellect the customer order ");
            }
            if(dto.getRating() == null){
                errors.add("Please enter a rating ");
            }
        }
        return errors;
    }
}

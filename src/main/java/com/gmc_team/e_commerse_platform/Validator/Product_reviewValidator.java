package com.gmc_team.e_commerse_platform.Validator;

import com.gmc_team.e_commerse_platform.Dto.Product_reviewDto;
import java.util.ArrayList;
import java.util.List;

public class Product_reviewValidator {
    public static List<String> Validate(Product_reviewDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Please sellect a Product ");
            errors.add("Please sellect a customer ");
            errors.add("Please enter the rating ");
            errors.add("Please fill the Online store Id");

        }else {
            if (dto.getOnline_shop()== null){
                errors.add("Please fill the Online store Id");
            }
            if(dto.getProductDto() == null){
                errors.add("Please sellect a Product ");
            }
            if(dto.getCustomer_id() == null){
                errors.add("Please sellect a customer ");
            }
            if(dto.getRating() == null){
                errors.add("Please enter the rating ");
            }

        }
        return errors;
    }
}

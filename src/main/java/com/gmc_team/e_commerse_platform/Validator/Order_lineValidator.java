package com.gmc_team.e_commerse_platform.Validator;

import com.gmc_team.e_commerse_platform.Dto.Order_lineDto;

import java.util.ArrayList;
import java.util.List;

public class Order_lineValidator {
    public static List<String> Validate(Order_lineDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Please fill the Qte");
            errors.add("Please fill the price ");
            errors.add("Please sellect a Product ");
            errors.add("Please fill the Online store Id");


        }else {
            if (dto.getOnline_shop()== null){
                errors.add("Please fill the Online store Id");
            }
            if(dto.getQte() == null){
                errors.add("Please fill the Qte");
            }
            if(dto.getPrice()== null){
                errors.add("Please fill the price ");
            }
            if(dto.getProduct_itemDto() == null || dto.getProduct_itemDto().getId() ==null){
                errors.add("Please sellect a Product ");
            }
        }
        return errors;
    }
}

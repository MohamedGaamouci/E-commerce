package com.gmc_team.e_commerse_platform.Validator;

import com.gmc_team.e_commerse_platform.Dto.Shipping_methodDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Shipping_methodValidator {

    public static List<String> Validate(Shipping_methodDto dto) {
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Please fill the name");
            errors.add("Please fill the price");
            errors.add("Please sellect the customer order");
            errors.add("Please fill the Online store Id");
        }else {
            if (dto.getOnline_shop()== null){
                errors.add("Please fill the Online store Id");
            }
            if (dto.getCustomer_order() == null){
                errors.add("Please sellect the customer order");
            }
            if(!(StringUtils.hasLength(dto.getName()))){
                errors.add("Please fill the name");
            }
            if(dto.getPrice() == null){
                errors.add("Please fill the price");
            }

        }
        return errors;
    }
}

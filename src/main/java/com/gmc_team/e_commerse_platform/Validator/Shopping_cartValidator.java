package com.gmc_team.e_commerse_platform.Validator;

import com.gmc_team.e_commerse_platform.Dto.Shopping_cartDto;


import java.util.ArrayList;
import java.util.List;

public class Shopping_cartValidator {
    public static List<String> Validate(Shopping_cartDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Please sellect the customer ");
            errors.add("Please fill the card with shoping list ");
            errors.add("Please fill the Online store Id");

        }else {
            if (dto.getOnline_shop()== null){
                errors.add("Please fill the Online store Id");
            }
            if(dto.getCustomersId() == null||dto.getCustomersId().getId() == null){
                errors.add("Please sellect the customer ");
            }
            if(dto.getShopping_listDto() != null ){
                if (dto.getShopping_listDto().isEmpty()){
                errors.add("Please fill the card with shoping list ");
                }else {
                    dto.getShopping_listDto().stream()
                            .map((item)->errors.addAll(Shopping_cart_itemValidator.Validate(item)));
                }
            }

        }
        return errors;
    }
}

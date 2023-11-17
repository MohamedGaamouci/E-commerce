package com.gmc_team.e_commerse_platform.Validator;


import com.gmc_team.e_commerse_platform.Dto.Shopping_cart_itemDto;


import java.util.ArrayList;
import java.util.List;

public class Shopping_cart_itemValidator {
    public static List<String> Validate(Shopping_cart_itemDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Please sellect the Product ");
            errors.add("Please fill the Qte item ");
//            errors.add("Please fill the Online store Id");

        }else {
//            if (dto.getOnline_shop()== null){
//                errors.add("Please fill the Online store Id");
//            }
            if(dto.getProduct_item() == null||dto.getProduct_item().getId() == null){
                errors.add("Please sellect the Product ");
            }
            if(dto.getQte() == null){
                errors.add("Please fill the Qte item ");
            }

        }
        return errors;
    }
}

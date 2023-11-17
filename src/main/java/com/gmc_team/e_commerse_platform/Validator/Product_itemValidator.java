package com.gmc_team.e_commerse_platform.Validator;

import com.gmc_team.e_commerse_platform.Dto.Product_itemDto;

import java.util.ArrayList;
import java.util.List;

public class Product_itemValidator {
    public static List<String> Validate(Product_itemDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Please fill the Qte item ");
            errors.add("Please choose for the product at least one image ");
            errors.add("Please fill the Online store Id");
        }else {
            if (dto.getOnline_shop()== null){
                errors.add("Please fill the Online store Id");
            }

            if(dto.getQte() == null){
                errors.add("Please fill the Qte item ");
            }

            if(dto.getImagesDtos() == null ||dto.getImagesDtos().isEmpty()){
                errors.add("Please choose for the product at least one image ");
            }else{
                dto.getImagesDtos().forEach(img->errors.addAll(ImagesValidator.Validate(img)));
            }
        }
        return errors;
    }
}

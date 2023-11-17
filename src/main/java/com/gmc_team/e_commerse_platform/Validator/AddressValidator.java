package com.gmc_team.e_commerse_platform.Validator;

import com.gmc_team.e_commerse_platform.Dto.AddressDto;

import java.util.ArrayList;
import java.util.List;

public class AddressValidator {
    public static List<String> Validate(AddressDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Please fill the Country Item");
            errors.add("Please fill one Address at least");
            errors.add("Please fill the Postal Code");
            errors.add("Please fill the State Item");
            errors.add("Please fill the Phone Number");
//            errors.add("Please fill the Online store Id");
        }else{
        if(dto.getCountry() == null||dto.getCountry().isBlank()){
            errors.add("Please fill the Country Item");
        }
        if(dto.getAdd1() == null||dto.getAdd1().isBlank()){
            errors.add("Please fill Address 1");
        }
        if(dto.getPostal_code() == null){
            errors.add("Please fill the Postal Code");
        }
        if(dto.getState() == null||dto.getState().isBlank()){
            errors.add("Please fill the State Item");
        }
        if(dto.getPhone() == null){
            errors.add("Please fill the Phone Number");
        }

        }
        return errors;
    }
}

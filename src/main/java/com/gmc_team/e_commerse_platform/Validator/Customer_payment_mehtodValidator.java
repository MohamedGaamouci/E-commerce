package com.gmc_team.e_commerse_platform.Validator;

import com.gmc_team.e_commerse_platform.Dto.Customer_payment_mehtodDto;

import java.util.ArrayList;
import java.util.List;

public class Customer_payment_mehtodValidator {
    public static List<String> Validate(Customer_payment_mehtodDto dto) {
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Please sellect Payment Type");
            errors.add("Please fill the Provider");
            errors.add("Please select if is default or not ");
        }else {

            if(dto.getPayment_type() == null ||dto.getPayment_type().toString().isBlank()){
                errors.add("Please sellect Payment Type");
            }
            if(dto.getProvider() == null ||dto.getProvider().isBlank()){
                errors.add("Please fill the Provider");
            }

            if(dto.getIs_default() == null){
                errors.add("Please select if is default or not ");
            }
            }
        return errors;
    }
}

package com.gmc_team.e_commerse_platform.Validator;

import com.gmc_team.e_commerse_platform.Dto.CustomersDto;

import java.util.ArrayList;
import java.util.List;

public class CustomerValidator {
    public static List<String> Validate(CustomersDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Please fill the Name");
            errors.add("Please fill the second Name");
            errors.add("Please fill one User Name");
            errors.add("Please fill the email address");
            errors.add("Please fill the the gender");
            errors.add("Please fill the Address Information");
            errors.add("Please fill the Role");
            errors.add("Please fill the birth day");
        }else {

            if(dto.getName()==null||dto.getName().isBlank()){
                errors.add("Please fill the Name");
            }
            if(dto.getSecond_Name()==null||dto.getSecond_Name().isBlank()){
                errors.add("Please fill the second Name");
            }
            if(dto.getUser_Name()==null||dto.getUser_Name().isBlank()){
                errors.add("Please fill one User Name");
            }
            if(dto.getEmail()==null||dto.getEmail().isBlank()){
                errors.add("Please fill the email address");
            }
            if(dto.getGender()==null||dto.getGender().name().isBlank()){
                errors.add("Please fill the the gender");
            }
            if(dto.getAddress() == null ){
                errors.add("Please fill the Address Information");
            }else if(dto.getAddress().get(0).getId() == null){
                dto.getAddress().forEach(add -> errors.addAll(AddressValidator.Validate(add)));
            }
            if(dto.getRoles().isEmpty()){
                errors.add("Please fill the Role");
            }
            if(dto.getBirth_day().toString().isEmpty()){
                errors.add("Please fill the birth day");
            }
        }
        return errors;
    }
}

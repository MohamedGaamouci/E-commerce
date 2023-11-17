package com.gmc_team.e_commerse_platform.Validator;


import com.gmc_team.e_commerse_platform.Dto.SellersDto;

import java.util.ArrayList;
import java.util.List;

public class SellersValidator {
    public static List<String> Validate(SellersDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Please fill the Name");
            errors.add("Please fill the second Name");
            errors.add("Please fill one User Name");
            errors.add("Please fill the email address");
            errors.add("Please fill the Address Information");
            errors.add("Please fill the Rolle");
            errors.add("Please fill the Seller status");
//            errors.add("Please fill the Online store Id");
        }else {

            if(dto.getFirst_Name() == null || dto.getFirst_Name().isBlank()){
                errors.add("Please fill the first Name");
            }
            if(dto.getSecond_Name() == null || dto.getSecond_Name().isBlank()){
                errors.add("Please fill the second Name");
            }
            if(dto.getUser_Name() == null || dto.getUser_Name().isBlank()){
                errors.add("Please fill one User Name");
            }
            if(dto.getEmail() == null || dto.getEmail().isBlank()){
                errors.add("Please fill the email address");
            }
            if(dto.getAddress() == null ){
                errors.add("Please fill the Address Information");
            }else if(dto.getAddress().getId()==null){
                errors.addAll(AddressValidator.Validate(dto.getAddress()));
            }
            if (dto.getGender() == null || dto.getGender().name().isBlank()) {
                errors.add("Please fill the gender");
            }
            if(dto.getRoles() == null){
                errors.add("Please fill the Rolle");
            }
            if(dto.getStatus()== null){
                errors.add("Please fill the Seller status");
            }
        }
        return errors;
    }
}

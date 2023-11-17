package com.gmc_team.e_commerse_platform.Validator;

import com.gmc_team.e_commerse_platform.Dto.DescriptionsDto;
import com.gmc_team.e_commerse_platform.Dto.Online_shopDto;
import com.gmc_team.e_commerse_platform.Dto.SellersDto;

import java.util.ArrayList;
import java.util.List;

public class Online_shopValidator {
    public static List<String> Validate(Online_shopDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Please fill the Store Name");
            errors.add("Please fill the store owner information ");
            errors.add("Please fill the store speciality ");
            errors.add("Please fill the store Description ");


        }else {
            if(dto.getStore_Name() == null ||dto.getStore_Name().isBlank()){
                errors.add("Please fill the Store Name");
            }
            if(dto.getStore_owner() == null || dto.getStore_owner().getId() == null){
                errors.add("Please fill the store owner information ");
            }
            if(dto.getEmployeesDtos()!= null ){
                for (SellersDto emp :dto.getEmployeesDtos()){
                    if (emp.getId() == null){
                        errors.add("Please fill the store Employees information ");
                        break;
                    }
                }
            }
            List<String> err = new ArrayList<>();
            if(dto.getStore_descriptionsDtos()== null ){
                errors.add("Please fill the store Description ");
            }else{
                for (DescriptionsDto des :dto.getStore_descriptionsDtos()){
                    if (des.getId() == null){
                        err.addAll(DescriptionsValidator.Validate(des));
                        if(!err.isEmpty()){
                        break;}
                        errors.addAll(err);
                    }
                }
            }
            if(dto.getSpeciality() == null ||dto.getSpeciality().toString().isBlank()){
                if(dto.getAnother_specialty() == null||dto.getAnother_specialty().isBlank()){
                    errors.add("Please fill the store speciality ");
                }
            }
        }
        return errors;
    }
}

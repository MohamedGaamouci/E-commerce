package com.gmc_team.e_commerse_platform.Validator;

import com.gmc_team.e_commerse_platform.Dto.Delevery_time_detailDto;

import java.util.ArrayList;
import java.util.List;

public class Delevery_time_detailValidator {

    public static List<String> validate(Delevery_time_detailDto dto){
        List<String> errors = new ArrayList<>();
        if (dto == null){
            errors.add("Please fill the title");
            errors.add("Please fill the time delevery");
        }else {
        if(dto.getTitle().isBlank()){
            errors.add("Please fill the title");
        }
        if(dto.getTime() == null){
            errors.add("Please fill the time delevery");
        }}
        return errors;
    }

}

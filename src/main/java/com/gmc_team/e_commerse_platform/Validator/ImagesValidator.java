package com.gmc_team.e_commerse_platform.Validator;

import com.gmc_team.e_commerse_platform.Dto.ImagesDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ImagesValidator {
    public static List<String> Validate(ImagesDto dto){
        List<String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Please fill the title");
            errors.add("Please fill the description");
            errors.add("Please fill the Online store Id");

        }else {
            if (dto.getOnline_shop()== null){
                errors.add("Please fill the Online store Id");
            }
            if(!(StringUtils.hasLength(dto.getTitle()))){
                errors.add("Please fill the title");
            }
            if(!(StringUtils.hasLength(dto.getURL()))){
                errors.add("Please sellect an image");
            }
        }
        return errors;
    }
}

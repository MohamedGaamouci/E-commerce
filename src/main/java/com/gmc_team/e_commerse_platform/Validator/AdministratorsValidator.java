package com.gmc_team.e_commerse_platform.Validator;

import com.gmc_team.e_commerse_platform.Dto.AdministratorsDto;

import java.util.ArrayList;
import java.util.List;

public class AdministratorsValidator {
    public static List<String> Validate(AdministratorsDto dto) {
        List<String> errors = new ArrayList<>();
        if (dto == null) {
            errors.add("Please fill the First Name");
            errors.add("Please fill one Second Name");
            errors.add("Please fill one User Name");
            errors.add("Please fill the Address Information");
            errors.add("Please fill the Email");
            errors.add("Please fill the Birth Day");
            errors.add("Please fill the gender");
            errors.add("Please fill the Roles");
        } else {
            if (dto.getFirst_Name() == null ||dto.getFirst_Name().isBlank()) {
                errors.add("Please fill the Country Item");
            }
            if (dto.getSecond_Name() == null ||dto.getSecond_Name().isBlank()) {
                errors.add("Please fill one Address at least");
            }
            if (dto.getUsername() == null ||dto.getUsername().isBlank()) {
                errors.add("Please fill one User Name");
            }
            if (dto.getAddress() == null) {
                errors.add("Please fill the Address Information");
            } else if (dto.getAddress().getId()==null){
                errors.addAll(AddressValidator.Validate(dto.getAddress()));
            }
            if (dto.getBirth_day() == null) {
                errors.add("Please fill the Birth Day");
            }
            if (dto.getRoles() == null) {
                errors.add("Please fill the Roles");

            }if (dto.getGender() == null ||dto.getGender().name().isBlank()) {
                errors.add("Please fill the gender");
            }
            if (dto.getEmail() == null ||dto.getEmail().isBlank()) {
                errors.add("Please fill the Email");
            }}
            return errors;

    }
}

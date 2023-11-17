package com.gmc_team.e_commerse_platform.handlers;

import java.util.ArrayList;
import java.util.List;

import com.gmc_team.e_commerse_platform.exceptions.Errorcode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {

    private Integer httpCode;

    private Errorcode code;


    private String message;

    private List<String> errors = new ArrayList<>();

}

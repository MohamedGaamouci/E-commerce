package com.gmc_team.e_commerse_platform.Dto;

import com.gmc_team.e_commerse_platform.models.Administrators;
import com.gmc_team.e_commerse_platform.models.Gender;
import com.gmc_team.e_commerse_platform.models.Roles;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class AdministratorsDto {
    private Long Id;
    private String first_Name;
    private String second_Name;
    private String username;
    private String Email;
    private AddressDto address;
    private Instant birth_day;
    private Gender gender;
    private List<Roles> roles;

    public static AdministratorsDto fromEntity(Administrators administrators){
        if(administrators == null) return null;
        else{
            return AdministratorsDto.builder()
                    .Id(administrators.getId())
                    .first_Name(administrators.getFirstName())
                    .second_Name(administrators.getSecondName())
                    .username(administrators.getUsername())
                    .address(AddressDto.fromEntity(administrators.getAddress()))
                    .birth_day(administrators.getBirth_day())
                    .gender(administrators.getGender())
                    .Email(administrators.getEmail())
                    .roles(administrators.getRoles())
                    .build();
        }
    }
    public static Administrators toEntity(AdministratorsDto dto){
        if(dto == null)return null;
        else{
            Administrators administrators = new Administrators();
            administrators.setId(dto.getId());
            administrators.setFirstName(dto.getFirst_Name().trim());
            administrators.setSecondName(dto.getSecond_Name().trim());
            administrators.setUsername(dto.getUsername().trim());
            administrators.setAddress(AddressDto.toEntity(dto.getAddress()));
            administrators.setBirth_day(dto.getBirth_day());
            administrators.setGender(dto.getGender());
            administrators.setRoles(dto.getRoles());
            administrators.setEmail(dto.getEmail().trim());

            return administrators;
        }
    }
}

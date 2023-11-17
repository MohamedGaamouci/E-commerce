package com.gmc_team.e_commerse_platform.Dto;

import com.gmc_team.e_commerse_platform.models.Gender;
import com.gmc_team.e_commerse_platform.models.Roles;
import com.gmc_team.e_commerse_platform.models.SellerStatus;
import com.gmc_team.e_commerse_platform.models.Sellers;
import lombok.Builder;
import lombok.Data;
import java.time.Instant;
import java.util.List;

@Data
@Builder
public class SellersDto {
    private Long Id;
    private String first_Name;
    private String second_Name;
    private String User_Name;
    private AddressDto address;
    private String Email;
    private Instant birth_day;
    private Gender gender;
    private List<Roles> roles;
    private Long onlineshop;
    private SellerStatus status;
    public static Sellers toEntity(SellersDto dto){
        if(dto == null)return null;
        else{
            Sellers sellers = new Sellers();
            sellers.setId(dto.getId());
            sellers.setFirstname(dto.getFirst_Name().trim());
            sellers.setSecondname(dto.getSecond_Name().trim());
            sellers.setUsername(dto.getUser_Name().trim());
            sellers.setAddress(AddressDto.toEntity(dto.getAddress()));
            sellers.setEmail(dto.getEmail().trim());
            sellers.setBirthday(dto.getBirth_day());
            sellers.setGender(dto.getGender());
            sellers.setRoles(dto.getRoles());
            sellers.setOnlineshop(dto.getOnlineshop());
            sellers.setStatus(dto.getStatus());
            return sellers;
        }
    }
    public static SellersDto fromEntity(Sellers sellers){
        if(sellers == null )return null;
        else return SellersDto.builder()
                .Id(sellers.getId())
                .first_Name(sellers.getFirstname())
                .second_Name(sellers.getSecondname())
                .User_Name(sellers.getUsername())
                .address(AddressDto.fromEntity(sellers.getAddress()))
                .Email(sellers.getEmail())
                .birth_day(sellers.getBirthday())
                .gender(sellers.getGender())
                .roles(sellers.getRoles())
                .onlineshop(sellers.getOnlineshop())
                .status(sellers.getStatus())
                .build();
    }
}

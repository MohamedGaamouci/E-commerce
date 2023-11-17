package com.gmc_team.e_commerse_platform.Dto;

import com.gmc_team.e_commerse_platform.models.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {
    private Long Id ;
    private String country;
    private String add1;
    private String add2;
    private Integer postal_code;
    private String state;
    private String city;
    private Long phone;

//    @JsonIgnore
    private Long online_shop;

    public static AddressDto fromEntity(Address entity){
        if(entity ==null )return null;
        else {
            return AddressDto.builder()
                    .Id(entity.getId())
                    .country(entity.getCountry())
                    .add1(entity.getAdd1())
                    .add2(entity.getAdd2())
                    .postal_code(entity.getPostal_code())
                    .state(entity.getState())
                    .city(entity.getCity())
                    .phone(entity.getPhone())
                    .online_shop(entity.getOnlineshop())
                    .build();
        }
    }
    public static Address toEntity(AddressDto dto){
        if(dto == null)return null;
        else{
            Address address = new Address();
            address.setId(dto.getId());
            address.setCountry(dto.getCountry().trim());
            address.setAdd1(dto.getAdd1().trim());
            address.setAdd2(dto.getAdd2().trim());
            address.setPostal_code(dto.getPostal_code());
            address.setState(dto.getState().trim());
            address.setCity(dto.getCity().trim());
            address.setPhone(dto.getPhone());
            address.setOnlineshop(dto.getOnline_shop());

            return address;
        }

    }
}

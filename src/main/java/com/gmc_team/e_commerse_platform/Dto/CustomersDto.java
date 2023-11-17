package com.gmc_team.e_commerse_platform.Dto;

import com.gmc_team.e_commerse_platform.models.*;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
@Builder
public class CustomersDto {
    private Long Id;
    private String Name;
    private String Second_Name;
    private String User_Name;
    private String Email;
    private List<AddressDto> address;
    private Gender gender;
    private Instant birth_day;
    private List<Roles> roles;
    private List<Online_shopDto> registerstores;
    private List<ProductDto> favoriteproduct;
    private HashMap<Long ,Integer> loyaltypoints;


    public static Customers toEntity(CustomersDto dto){
        if(dto == null) return null;
        else {
            Customers customers = new Customers();
            customers.setId(dto.getId());
            customers.setName(dto.getName().trim());
            customers.setSecondname(dto.getSecond_Name().trim());
            customers.setUsername(dto.getUser_Name().trim());
            customers.setEmail(dto.getEmail().trim());
                if(dto.getAddress() !=null){
                List<Address> list = new ArrayList<>();
                dto.getAddress().forEach(add ->list.add(AddressDto.toEntity(add)));
                customers.setAddress(list);
                }
            customers.setRoles(dto.getRoles());
            customers.setGender(dto.getGender());
            customers.setBirthday(dto.getBirth_day());
                if(dto.getRegisterstores() != null){
                    List<Online_shop> list = new ArrayList<>();
                    dto.getRegisterstores().forEach(reg->list.add(Online_shopDto.toEntity(reg)));
                    customers.setRegisterstores(list);
                }
                if(dto.getFavoriteproduct() != null){
                    List<Product> list = new ArrayList<>();
                    dto.getFavoriteproduct().forEach(f->list.add(ProductDto.toEntity(f)));
                    customers.setFavoriteproduct(list);
                }
//            customers.setLoyaltypoints(dto.getLoyaltypoints());

            return customers;
        }
    }
    public static CustomersDto fromEntity(Customers customers ,boolean go_with_register_stores){
        if(customers ==null )return null;
        else{
            if(go_with_register_stores){
                List<AddressDto> list = new ArrayList<>();
                if(customers.getAddress() !=null) {
                    customers.getAddress().forEach(add -> list.add(AddressDto.fromEntity(add)));
                }
                List<Online_shopDto> register_stores = new ArrayList<>();
                if(customers.getRegisterstores() != null){
                    customers.getRegisterstores().forEach(reg->register_stores.add(Online_shopDto.fromEntity(reg ,false)));
                }
                List<ProductDto> favorite_product = new ArrayList<>();
                if(customers.getFavoriteproduct() !=null){
                    customers.getFavoriteproduct().forEach(f->favorite_product.add(ProductDto.fromEntity(f,false)));
                }
                return CustomersDto.builder()
                        .Id(customers.getId())
                        .Name(customers.getName())
                        .Second_Name(customers.getSecondname())
                        .User_Name(customers.getUsername())
                        .Email(customers.getEmail())
                        .address(list)
                        .roles(customers.getRoles())
                        .gender(customers.getGender())
                        .birth_day(customers.getBirthday())
                        .registerstores(register_stores)
                        .favoriteproduct(favorite_product)
//                        .loyaltypoints(customers.getLoyaltypoints())
                        .build();
            }else {
                List<AddressDto> list = new ArrayList<>();
                if(customers.getAddress() !=null) {
                    customers.getAddress().forEach(add -> list.add(AddressDto.fromEntity(add)));
                }
                List<ProductDto> favorite_product = new ArrayList<>();
                if(customers.getFavoriteproduct() !=null){
                    customers.getFavoriteproduct().forEach(f->favorite_product.add(ProductDto.fromEntity(f,false)));
                }

                return CustomersDto.builder()
                        .Id(customers.getId())
                        .Name(customers.getName())
                        .Second_Name(customers.getSecondname())
                        .User_Name(customers.getUsername())
                        .Email(customers.getEmail())
                        .address(list)
                        .roles(customers.getRoles())
                        .gender(customers.getGender())
                        .birth_day(customers.getBirthday())
                        .favoriteproduct(favorite_product)
//                        .loyaltypoints(customers.getLoyaltypoints())
                        .build();
            }
        }
    }

}

package com.gmc_team.e_commerse_platform.Dto;

import com.gmc_team.e_commerse_platform.models.*;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Online_shopDto {
    private Long Id;
    private String store_Name;
    private SellersDto store_owner;

    private List<SellersDto> employeesDtos;
//    private List<CategoryDto> categoriesDtos;
    private Store_status store_status;
    private List<DescriptionsDto> store_descriptionsDtos;
    private List<Online_shop_reviewDto> online_shop_reviewsDtos;
    private String another_specialty;
    private Float rating;
    private Specialities speciality;
    private List<Customer_payment_mehtodDto> paymentMehtods;

    private List<CustomersDto> storecustomers;


    public static Online_shop toEntity(Online_shopDto dto) {
        if(dto == null )return null;
        else{
            Online_shop shop =new Online_shop();
            shop.setId(dto.getId());
            shop.setStorename(dto.getStore_Name().trim());
            shop.setStoreowner(SellersDto.toEntity(dto.getStore_owner()));
                if(dto.getEmployeesDtos() !=null){
                    List<Sellers> sellers = new ArrayList<>();
                    dto.getEmployeesDtos().forEach(seller -> sellers.add(SellersDto.toEntity(seller)));
                    shop.setEmployees(sellers);
                }
//                if(dto.getCategoriesDtos() !=null){
//                    List<Category> categoryList = new ArrayList<>();
//                    dto.getCategoriesDtos().forEach(cat-> categoryList.add(CategoryDto.toEntity(cat)));
////                    shop.setCategories(categoryList);
//                }
            shop.setStorestatus(dto.getStore_status());
                if(dto.getStore_descriptionsDtos() !=null){
                    List<Descriptions> Descriptions_list = new ArrayList<>();
                    dto.getStore_descriptionsDtos().forEach(Description -> Descriptions_list.add(DescriptionsDto.toEntity(Description)));
                    shop.setStoredescriptions(Descriptions_list);
                }
                if(dto.getOnline_shop_reviewsDtos() !=null){
                    List<Online_shop_review> reviews =new ArrayList<>();
                    dto.getOnline_shop_reviewsDtos().forEach(rev -> reviews.add(Online_shop_reviewDto.toEntity(rev)));
                    shop.setOnlineshopreviews(reviews);
                }
            shop.setAnotherspecialty(dto.getAnother_specialty());
            shop.setSpeciality(dto.getSpeciality());
            shop.setRating(dto.getRating());
                if(dto.getPaymentMehtods() != null){
                    List<Payment_method> payment = new ArrayList<>();
                    dto.getPaymentMehtods().forEach(l->payment.add(
                            Customer_payment_mehtodDto.toEntity(l)));
                shop.setPaymentMehtods(payment);
                }
            if(dto.getStorecustomers() != null){
                List<Customers> list = new ArrayList<>();
                dto.getStorecustomers().forEach(reg->list.add(CustomersDto.toEntity(reg)));
                shop.setStorecustomers(list);
            }
            return shop;
        }
    }

    public static Online_shopDto fromEntity(Online_shop shop ,boolean go_with_store_customer) {
        if(shop == null )return null;
        else {
            if(go_with_store_customer){
                List<SellersDto> sellers = new ArrayList<>();
                if(shop.getEmployees() !=null){
                    shop.getEmployees().forEach(seller -> sellers.add(SellersDto.fromEntity(seller)));
                }
//                List<CategoryDto> categoryList = new ArrayList<>();
//                if(shop.getCategories() !=null){
//                    shop.getCategories().forEach(cat-> categoryList.add(CategoryDto.fromEntity(cat)));
//                }
                List<DescriptionsDto> Descriptions_list = new ArrayList<>();
                if(shop.getStoredescriptions() !=null){
                    shop.getStoredescriptions().forEach(Description ->
                            Descriptions_list.add(DescriptionsDto.fromEntity(Description)));
                }
                List<Online_shop_reviewDto> reviews =new ArrayList<>();
                if(shop.getOnlineshopreviews() !=null){
                    shop.getOnlineshopreviews().forEach(rev -> reviews.add(Online_shop_reviewDto.fromEntity(rev)));
                }
                List<Customer_payment_mehtodDto> payment = new ArrayList<>();
                if(shop.getPaymentMehtods() != null){
                    shop.getPaymentMehtods().forEach(l->payment.add(
                            Customer_payment_mehtodDto.fromEntity(l)));
                }
                List<CustomersDto> cutomers_store = new ArrayList<>();
                if(shop.getStorecustomers() != null){
                    shop.getStorecustomers().forEach(reg->cutomers_store.add(CustomersDto.fromEntity(reg,false)));
                }

                return Online_shopDto.builder()
                        .Id(shop.getId())
                        .store_Name(shop.getStorename())
                        .store_owner(SellersDto.fromEntity(shop.getStoreowner()))
                        .employeesDtos(sellers)
//                        .categoriesDtos(categoryList)
                        .store_status(shop.getStorestatus())
                        .store_descriptionsDtos(Descriptions_list)
                        .online_shop_reviewsDtos(reviews)
                        .another_specialty(shop.getAnotherspecialty())
                        .speciality(shop.getSpeciality())
                        .rating(shop.getRating())
                        .paymentMehtods(payment)
                        .storecustomers(cutomers_store)
                        .build();
            }else{
                List<SellersDto> sellers = new ArrayList<>();
                if(shop.getEmployees() !=null){
                    shop.getEmployees().forEach(seller -> sellers.add(SellersDto.fromEntity(seller)));
                }
//                List<CategoryDto> categoryList = new ArrayList<>();
//                if(shop.getCategories() !=null){
//                    shop.getCategories().forEach(cat-> categoryList.add(CategoryDto.fromEntity(cat)));
//                }
                List<DescriptionsDto> Descriptions_list = new ArrayList<>();
                if(shop.getStoredescriptions() !=null){
                    shop.getStoredescriptions().forEach(Description ->
                            Descriptions_list.add(DescriptionsDto.fromEntity(Description)));
                }
                List<Online_shop_reviewDto> reviews =new ArrayList<>();
                if(shop.getOnlineshopreviews() !=null){
                    shop.getOnlineshopreviews().forEach(rev -> reviews.add(Online_shop_reviewDto.fromEntity(rev)));
                }
                List<Customer_payment_mehtodDto> payment = new ArrayList<>();
                if(shop.getPaymentMehtods() != null){
                    shop.getPaymentMehtods().forEach(l->payment.add(
                            Customer_payment_mehtodDto.fromEntity(l)));
                }
                return Online_shopDto.builder()
                        .Id(shop.getId())
                        .store_Name(shop.getStorename())
                        .store_owner(SellersDto.fromEntity(shop.getStoreowner()))
                        .employeesDtos(sellers)
//                        .categoriesDtos(categoryList)
                        .store_status(shop.getStorestatus())
                        .store_descriptionsDtos(Descriptions_list)
                        .online_shop_reviewsDtos(reviews)
                        .another_specialty(shop.getAnotherspecialty())
                        .speciality(shop.getSpeciality())
                        .rating(shop.getRating())
                        .paymentMehtods(payment)
                        .build();
            }
        }
    }
}

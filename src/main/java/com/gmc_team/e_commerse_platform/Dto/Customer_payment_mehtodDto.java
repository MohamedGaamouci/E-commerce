package com.gmc_team.e_commerse_platform.Dto;


import com.gmc_team.e_commerse_platform.models.Payment_method;
import com.gmc_team.e_commerse_platform.models.Payment_type;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer_payment_mehtodDto {
    private Long Id;
    private Payment_type payment_type;
    private String provider;

    private Boolean is_default;


    public static Payment_method toEntity(Customer_payment_mehtodDto dto){
        if(dto == null ) return null ;
        else {
            Payment_method payment_mehtod = new Payment_method();
            payment_mehtod.setId(dto.getId());
            payment_mehtod.setPaymenttype(dto.getPayment_type());
            payment_mehtod.setProvider(dto.getProvider().trim());
            payment_mehtod.setIsdefault(dto.getIs_default());

            return payment_mehtod;
        }
    }
    public static Customer_payment_mehtodDto fromEntity(Payment_method customerPaymentMehtod){
        if(customerPaymentMehtod == null) return null;
        else{

            return Customer_payment_mehtodDto.builder()
                    .Id(customerPaymentMehtod.getId())
                    .payment_type(customerPaymentMehtod.getPaymenttype())
                    .provider(customerPaymentMehtod.getProvider())
                    .is_default(customerPaymentMehtod.getIsdefault())
                    .build();
        }
    }
}

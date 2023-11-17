package com.gmc_team.e_commerse_platform.Services;

import com.gmc_team.e_commerse_platform.Dto.Online_shopDto;
import com.gmc_team.e_commerse_platform.Dto.SellersDto;
import com.gmc_team.e_commerse_platform.models.Specialities;
import com.gmc_team.e_commerse_platform.models.Store_status;

import java.util.List;

public interface Online_shopService {
    Online_shopDto findById(Long Id);
    Online_shopDto save(Online_shopDto dto);
    List<Online_shopDto> findByName(String Id);
    Online_shopDto findByOwnerId(Long Id);
    List<Online_shopDto> findAll();
    List<Online_shopDto> findByStore_status(Store_status status);
    List<Online_shopDto> findByRating(Float Haut ,Float base);
    List<Online_shopDto> findBySpeciality(Specialities Speciality);
    List<Online_shopDto> findByOtherSpeciality(String Speciality);
    Online_shopDto AddNewEmployee(SellersDto dto );
    Online_shopDto AddNewCustomer(Long CustomerId ,Long StoreId);
    void disactivate(Long storeId);
    void activate(Long storeId);
    Store_status getstatus(Long storeId);
    void delete_review(Long review ,Long store);
    void delete_description(Long description,Long store);

    Online_shopDto addPaymentMethod(Long PaymentId ,Long store);
    void  deletePaymentMethod(Long PaymentId ,Long store);

    void deleteEmployee(Long employeeId ,Long store);

    void deletecustomer(Long customerId ,Long store);



}

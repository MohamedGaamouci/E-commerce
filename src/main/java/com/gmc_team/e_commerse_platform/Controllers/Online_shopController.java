package com.gmc_team.e_commerse_platform.Controllers;

import com.gmc_team.e_commerse_platform.Controllers.Api.Online_shopApi;
import com.gmc_team.e_commerse_platform.Dto.Online_shopDto;
import com.gmc_team.e_commerse_platform.Dto.SellersDto;
import com.gmc_team.e_commerse_platform.Services.ServiceImpl.Online_shopServiceImpl;
import com.gmc_team.e_commerse_platform.models.Specialities;
import com.gmc_team.e_commerse_platform.models.Store_status;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Online_shopController implements Online_shopApi {
    private final Online_shopServiceImpl online_shopServiceImpl;

    public Online_shopController(Online_shopServiceImpl online_shopServiceImpl) {
        this.online_shopServiceImpl = online_shopServiceImpl;
    }

    @Override
    public Online_shopDto findById(Long Id) {
        return online_shopServiceImpl.findById(Id);
    }

    @Override
    public Online_shopDto save(Online_shopDto dto) {
        dto.setStore_status(null);
        return online_shopServiceImpl.save(dto);
    }

    @Override
    public List<Online_shopDto> findByName(String Id) {
        return online_shopServiceImpl.findByName(Id);
    }


    @Override
    public Online_shopDto findByOwnerId(Long Id) {
        return online_shopServiceImpl.findByOwnerId(Id);
    }

    @Override
    public List<Online_shopDto> findAll() {
        return online_shopServiceImpl.findAll();
    }

    @Override
    public List<Online_shopDto> findByStore_status(Store_status status) {
        return online_shopServiceImpl.findByStore_status(status);
    }

    @Override
    public List<Online_shopDto> findByRating(Float Haut, Float Base) {
        return online_shopServiceImpl.findByRating(Haut ,Base);
    }

    @Override
    public List<Online_shopDto> findBySpeciality(Specialities Speciality) {
        return online_shopServiceImpl.findBySpeciality(Speciality);
    }

    @Override
    public List<Online_shopDto> findByOtherSpeciality(String Speciality) {
        return online_shopServiceImpl.findByOtherSpeciality(Speciality);
    }
    @Override
    public Online_shopDto AddNewEmployee(SellersDto dto ){
        return  online_shopServiceImpl.AddNewEmployee(dto );
    }

    @Override
    public Online_shopDto AddNewCustomer(Long customerid, Long storeid) {
        return online_shopServiceImpl.AddNewCustomer(customerid ,storeid);
    }

    @Override
    public void disactivate(Long storeId) {
        online_shopServiceImpl.disactivate(storeId);
    }

    @Override
    public void activate(Long storeId) {
        online_shopServiceImpl.activate(storeId);
    }

    @Override
    public Store_status getstatus(Long storeId) {
        return online_shopServiceImpl.getstatus(storeId);
    }

    @Override
    public void delete_review(Long reviewId, Long storeid) {
         online_shopServiceImpl.delete_review(reviewId ,storeid);
    }

    @Override
    public void delete_description(Long descriptionid, Long storeid) {
        online_shopServiceImpl.delete_description(descriptionid,storeid);
    }

    @Override
    public Online_shopDto addPaymentMethod(Long paymentid, Long storeid) {
        return online_shopServiceImpl.addPaymentMethod(paymentid,storeid);
    }

    @Override
    public void deletePaymentMethod(Long paymentid, Long storeid) {
        online_shopServiceImpl.deletePaymentMethod(paymentid,storeid);
    }

    @Override
    public void deleteEmployee(Long employeeid, Long storeid) {
        online_shopServiceImpl.deleteEmployee(employeeid,storeid);
    }

    @Override
    public void dissubscribeCustomer(Long customerid, Long storeid) {
        online_shopServiceImpl.deletecustomer(customerid,storeid);
    }


}

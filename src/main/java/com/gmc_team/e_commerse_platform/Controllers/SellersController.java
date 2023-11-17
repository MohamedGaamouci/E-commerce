package com.gmc_team.e_commerse_platform.Controllers;

import com.gmc_team.e_commerse_platform.Controllers.Api.SellerApi;
import com.gmc_team.e_commerse_platform.Dto.SellersDto;
import com.gmc_team.e_commerse_platform.Services.ServiceImpl.SellerServiceImpl;
import com.gmc_team.e_commerse_platform.models.Roles;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SellersController implements SellerApi {
    private final SellerServiceImpl sellerServiceImpl;

    public SellersController(SellerServiceImpl sellerServiceImpl) {
        this.sellerServiceImpl = sellerServiceImpl;
    }

    @Override
    public SellersDto findById(Long Id) {
        return sellerServiceImpl.findById(Id);
    }

    @Override
    public SellersDto save(SellersDto dto) {
        return sellerServiceImpl.save(dto);
    }

    @Override
    public List<SellersDto> findAll() {
        return sellerServiceImpl.findAll();
    }

    @Override
    public List<SellersDto> findByfirstNameAndSecondName(String firstName, String secondName) {
        return sellerServiceImpl.findByfirstNameAndSecondName(firstName,secondName);
    }

    @Override
    public SellersDto findByUserName(String username) {
        return sellerServiceImpl.findByUserName(username);
    }

    @Override
    public SellersDto findByEmail(String Email) {
        return sellerServiceImpl.findByEmail(Email);
    }

    @Override
    public List<SellersDto> findByGender(String gender) {
        return sellerServiceImpl.findByGender(gender);
    }

    @Override
    public List<SellersDto> findByRole(List<Roles> rolesName) {
        return sellerServiceImpl.findByRole(rolesName);
    }

    @Override
    public void delete(Long Id) {
        sellerServiceImpl.delete(Id);
    }

    @Override
    public void activate(Long Id) {
        sellerServiceImpl.activate(Id);
    }

    @Override
    public void disactivate(Long Id) {
        sellerServiceImpl.disactivate(Id);
    }
}

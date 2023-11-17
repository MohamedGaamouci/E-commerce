package com.gmc_team.e_commerse_platform.Controllers;

import com.gmc_team.e_commerse_platform.Controllers.Api.Product_reviewApi;
import com.gmc_team.e_commerse_platform.Dto.Product_reviewDto;
import com.gmc_team.e_commerse_platform.Services.ServiceImpl.Product_reviewServiceImpl;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Product_reviewController implements Product_reviewApi {

    private final Product_reviewServiceImpl product_reviewServiceImpl;

    public Product_reviewController(Product_reviewServiceImpl product_reviewServiceImpl) {
        this.product_reviewServiceImpl = product_reviewServiceImpl;
    }

    @Override
    public Product_reviewDto findById(Long Id) {
        return product_reviewServiceImpl.findById(Id);
    }

    @Override
    public Product_reviewDto save(Product_reviewDto Id) {
        return product_reviewServiceImpl.save(Id);
    }

    @Override
    public List<Product_reviewDto> findAllByRating(Integer rating) {
        return product_reviewServiceImpl.findAllByRating(rating);
    }

    @Override
    public List<Product_reviewDto> findByProductId(Long Id) {
        return product_reviewServiceImpl.findByProductId(Id);
    }

    @Override
    public Product_reviewDto findByCustomerId(Long Id) {
        return product_reviewServiceImpl.findByCustomerId(Id);
    }

    @Override
    public void delete(Long Product_reviewId) {
        product_reviewServiceImpl.delete(Product_reviewId);
    }
}

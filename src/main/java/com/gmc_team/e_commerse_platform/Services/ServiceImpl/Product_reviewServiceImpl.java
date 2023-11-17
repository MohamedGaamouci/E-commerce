package com.gmc_team.e_commerse_platform.Services.ServiceImpl;

import com.gmc_team.e_commerse_platform.Dto.*;
import com.gmc_team.e_commerse_platform.Repository.Product_reviewRepo;
import com.gmc_team.e_commerse_platform.Services.Product_reviewService;
import com.gmc_team.e_commerse_platform.Validator.Product_reviewValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import com.gmc_team.e_commerse_platform.models.Product_review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class Product_reviewServiceImpl implements Product_reviewService {
    private final Product_reviewRepo product_reviewRepo;
    private final ProductServiceImpl productServiceImpl;
    private final CustomerServiceImpl customerServiceImpl;
    private final Online_shopServiceImpl online_shopServiceImpl;

    @Autowired
    public Product_reviewServiceImpl(Product_reviewRepo product_reviewRepo, ProductServiceImpl productServiceImpl, CustomerServiceImpl customerServiceImpl, Online_shopServiceImpl online_shopServiceImpl) {
        this.product_reviewRepo = product_reviewRepo;
        this.productServiceImpl = productServiceImpl;
        this.customerServiceImpl = customerServiceImpl;
        this.online_shopServiceImpl = online_shopServiceImpl;
    }

    @Override
    public Product_reviewDto findById(Long Id) {
        return product_reviewRepo.findById(Id)
                .map(Product_reviewDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("No review with the following Id :"+Id,
                        Errorcode.REVIEW_NOT_FOUND));
    }

    @Override
    public Product_reviewDto save(Product_reviewDto dto) {
        List<String> errors = Product_reviewValidator.Validate(dto);
        if(!errors.isEmpty()){
            throw new InvalidEntityException("the review Not valid {}",
                    Errorcode.PRODUCT_REVIEW_NOT_VALID,errors);
        }
        ProductDto productDto = productServiceImpl.findById(dto.getProductDto());

         Product_review review=product_reviewRepo
                .findByCustomeridAndProduct(dto.getCustomer_id() ,dto.getProductDto());
        if (review !=null&&dto.getId() == null){
            throw new InvalidOperationException("The review has been sent by customer Id: '"+
                    dto.getCustomer_id()+" 'already?",Errorcode.PRODUCT_REVIEW_NOT_VALID);
        }

        List<Product_reviewDto> productReviewDtos= new ArrayList<>
                (productDto.getProduct_reviewDtos());


        dto.setCustomer_id(customerServiceImpl.findById(dto.getCustomer_id()).getId());

        online_shopServiceImpl.findById(dto.getOnline_shop());

        Product_reviewDto productReviewDto =
                Product_reviewDto.fromEntity(product_reviewRepo
                        .save(Product_reviewDto.toEntity(dto)));

        productReviewDtos.add(productReviewDto);
        productDto.setProduct_reviewDtos(productReviewDtos);

        try {
            productServiceImpl.save(productDto);
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }

        return productReviewDto;
    }

    @Override
    public List<Product_reviewDto> findAllByRating(Integer rating) {
        return product_reviewRepo.findAllByRating(rating)
                .stream().map(Product_reviewDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product_reviewDto> findByProductId(Long Id) {
        ProductDto dto = productServiceImpl.findById(Id);
        return dto.getProduct_reviewDtos();
    }

    @Override
    public Product_reviewDto findByCustomerId(Long Id) {
        CustomersDto dto = customerServiceImpl.findById(Id);
        if(dto == null){
            throw new EntityNotFoundException("No Customer with the following Id :"+Id
                    ,Errorcode.CUSTOMER_NOT_FOUND);
        }
        return Product_reviewDto.fromEntity(product_reviewRepo
                .findByCustomerid(Id));
    }

    @Override
    public void delete(Long productReviewId) {
        try{
            Product_reviewDto dto = findById(productReviewId);
            ProductDto productDto = productServiceImpl.findById(dto.getProductDto());
            productDto.setProduct_reviewDtos(
                    productDto.getProduct_reviewDtos().stream()
                            .filter(r-> !Objects.equals(dto.getId() ,r.getId()))
                            .collect(Collectors.toList())
            );
            product_reviewRepo.deleteById(dto.getId());
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() ,Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }
}

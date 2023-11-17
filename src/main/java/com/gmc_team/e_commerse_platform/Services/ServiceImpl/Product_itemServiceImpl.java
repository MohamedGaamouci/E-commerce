package com.gmc_team.e_commerse_platform.Services.ServiceImpl;

import com.gmc_team.e_commerse_platform.Dto.ImagesDto;
import com.gmc_team.e_commerse_platform.Dto.Product_itemDto;
import com.gmc_team.e_commerse_platform.Repository.ProductRepo;
import com.gmc_team.e_commerse_platform.Repository.Product_itemRepo;
import com.gmc_team.e_commerse_platform.Services.Product_itemService;
import com.gmc_team.e_commerse_platform.Validator.ImagesValidator;
import com.gmc_team.e_commerse_platform.Validator.Product_itemValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import com.gmc_team.e_commerse_platform.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.gmc_team.e_commerse_platform.exceptions.Errorcode.PRODCUT_NOT_FOUND_EXCEPTION;

@Service
@Transactional
public class Product_itemServiceImpl implements Product_itemService {


    private final Product_itemRepo product_itemRepo;
    private final VariationServiceImpl variationServiceImpl;
    private final Variation_optionServiceImpl variation_optionServiceImpl;
    private final ImagesServiceImpl imagesServiceImpl;
    private final ProductRepo productRepo;

    @Autowired
    public Product_itemServiceImpl(Product_itemRepo product_itemRepo,
                                   VariationServiceImpl variationServiceImpl,
                                   Variation_optionServiceImpl variation_optionServiceImpl, ImagesServiceImpl imagesServiceImpl, ProductRepo productRepo) {
        this.product_itemRepo = product_itemRepo;
        this.variationServiceImpl = variationServiceImpl;
        this.variation_optionServiceImpl = variation_optionServiceImpl;
        this.imagesServiceImpl = imagesServiceImpl;
        this.productRepo = productRepo;
    }

    @Override
    public Product_itemDto findById(Long Id) {
        return product_itemRepo.findById(Id).map(Product_itemDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("No Product found with ID:"
                        +Id ,PRODCUT_NOT_FOUND_EXCEPTION));
    }

    @Override
    public Product_itemDto save(Product_itemDto Dto) {
        List<String> errors = Product_itemValidator.Validate(Dto);
        if(!errors.isEmpty()){
            throw new InvalidEntityException("The Product Item is not Valid{}",
                    Errorcode.PRODUCT_NOT_VALID ,errors);
        }
        if (!Dto.getVariations().isEmpty()){
            Dto.getVariations().forEach(var->{
                if (var.getId()!=null){
                    variationServiceImpl.findById(var.getId());
                }else {
                    throw new InvalidEntityException("you should sellect a Variation Id");
                }
            });
        }
        if (!Dto.getVariation_optionDtos().isEmpty()){
            Dto.getVariation_optionDtos().forEach(var->{
                if (var.getId()!=null){
                    variation_optionServiceImpl.findById(var.getId());
                }else {
                    throw new InvalidEntityException("you should sellect a Variation option Id");
                }
            });
        }

        if(Dto.getQte().compareTo(BigDecimal.ZERO) <= 0){
            throw new InvalidOperationException("the Qte can't be null or negative");
        }
        if(!Dto.getImagesDtos().isEmpty()){
            List<ImagesDto>images=new ArrayList<>();
            List<String> err = new ArrayList<>();
            Dto.getImagesDtos().forEach(img->{
                err.addAll(ImagesValidator.Validate(img));
                if(!err.isEmpty()){
                    throw new InvalidEntityException("Image Not Valid {}",
                            Errorcode.IMAGE_NOT_VALID_EXCEPTION ,err);
                }
                images.add(imagesServiceImpl.save(img));
            });
            Dto.setImagesDtos(images);
        }

        try {
            return Product_itemDto.fromEntity(product_itemRepo.save(Product_itemDto.toEntity(Dto)));

        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }


    @Override
    public Product_itemDto UpdateQteProduct_item(Long IdProduct, BigDecimal qte) {
        if(qte.compareTo(BigDecimal.ZERO) <= 0){
            throw new InvalidOperationException("the Qte can't be null or negative");
        }
        Product_itemDto dto = findById(IdProduct);
        dto.setQte(qte);
        return save(dto);
    }

    @Override
    public void deleteProduct_itemById(Long Id) {
        Product_itemDto itemDto = findById(Id);
        Product product = productRepo.findByProductitemsContaining(Product_itemDto.toEntity(itemDto));
        product.setProductitems(
                product.getProductitems().stream()
                        .filter(item->itemDto.getId()!=item.getId())
                        .collect(Collectors.toList())
        );
        productRepo.save(product);
        itemDto.setVariation_optionDtos(null);
        itemDto.setVariation_optionDtos(null);
        product_itemRepo.delete(Product_itemDto.toEntity(itemDto));
    }
}

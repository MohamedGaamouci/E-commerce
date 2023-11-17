package com.gmc_team.e_commerse_platform.Services.ServiceImpl;

import com.gmc_team.e_commerse_platform.Dto.*;
import com.gmc_team.e_commerse_platform.Repository.ProductRepo;
import com.gmc_team.e_commerse_platform.Services.ProductService;
import com.gmc_team.e_commerse_platform.Validator.DescriptionsValidator;
import com.gmc_team.e_commerse_platform.Validator.ImagesValidator;
import com.gmc_team.e_commerse_platform.Validator.ProductValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.gmc_team.e_commerse_platform.exceptions.Errorcode.PRODCUT_NOT_FOUND_EXCEPTION;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final Product_itemServiceImpl product_itemServiceImpl;
    private final com.gmc_team.e_commerse_platform.Services.ServiceImpl.SKUServiceImpl SKUServiceImpl;
    private final CategoryServiceImpl categoryServiceImpl;
    private final DescriptionServiceImpl descriptionServiceImpl;
    private final ImagesServiceImpl imagesServiceImpl;
    private final Promotion_detailServiceImpl promotion_detailServiceImpl;

    @Autowired
    public ProductServiceImpl(ProductRepo productRepo, Product_itemServiceImpl product_itemServiceImpl,
                              SKUServiceImpl SKUServiceImpl, CategoryServiceImpl categoryServiceImpl,
                              DescriptionServiceImpl descriptionServiceImpl, ImagesServiceImpl imagesServiceImpl, Promotion_detailServiceImpl promotion_detailServiceImpl) {
        this.productRepo = productRepo;
        this.product_itemServiceImpl = product_itemServiceImpl;
        this.SKUServiceImpl = SKUServiceImpl;
        this.categoryServiceImpl = categoryServiceImpl;
        this.descriptionServiceImpl = descriptionServiceImpl;
        this.imagesServiceImpl = imagesServiceImpl;
        this.promotion_detailServiceImpl = promotion_detailServiceImpl;
    }

    @Override
    public ProductDto findById(Long Id) {
        return productRepo.findById(Id).map(val->ProductDto.fromEntity(val ,true))
                .orElseThrow(()->new EntityNotFoundException("No Product found with ID:"
                        +Id ,PRODCUT_NOT_FOUND_EXCEPTION));
    }

    @Override
    public ProductDto save(ProductDto dto) {
        List<String> errors = ProductValidator.Validate(dto);
        if (!errors.isEmpty()) {
            throw new InvalidEntityException("The product is not valid.",
                    Errorcode.PRODUCT_NOT_VALID, errors);
        }
        if(dto.getId()!=null){
            findById(dto.getId());
        }
        if(findByName(dto.getName()).size()!=0 && dto.getId()==null) {
            throw new InvalidOperationException("The Product Name is Alrady exist",
                    Errorcode.PRODUCT_NOT_VALID );
        }

        dto.setCategoryDto(categoryServiceImpl.findById(dto.getCategoryDto().getId()));
        dto.setSKU(SKUServiceImpl.findById(dto.getSKU().getId()));

        List<Product_itemDto> savedItems = new ArrayList<>();

        for (Product_itemDto item : dto.getProductitems()) {
            if (item.getPrice()==null){
                item.setPrice(dto.getPrice());
            }
                savedItems.add(product_itemServiceImpl.save(item));

        }

        dto.setProductitems(savedItems);

        if(dto.getDescriptionsDtos()!=null){
            List<DescriptionsDto> desc= new ArrayList<>() ;
            List<String> err =new ArrayList<>();
            List<String> err2 =new ArrayList<>();
            for (DescriptionsDto descriptionsDto:dto.getDescriptionsDtos()){
                if(descriptionsDto.getId()==null) {
                    err.addAll(DescriptionsValidator.Validate(descriptionsDto));
                    if (!err.isEmpty()) {
                        throw new InvalidEntityException("Description Entity Not Valid {}", Errorcode.DESCRIPTION_NOT_VALID_EXCEPTION, err);
                    }
                    desc.add(descriptionServiceImpl.save(descriptionsDto));
                }else {
                    err2.addAll(DescriptionsValidator.Validate(descriptionsDto));
                    if(!err2.isEmpty()){
                        desc.add(descriptionServiceImpl.findById(descriptionsDto.getId()));
                    }else desc.add(descriptionServiceImpl.save(descriptionsDto));

                }
            }
            dto.setDescriptionsDtos(desc);
        }
        if(dto.getImagesDtos()!=null){
            List<ImagesDto> img =new ArrayList<>();
            List<String> err = new ArrayList<>();
            List<String> err2 = new ArrayList<>();
            for (ImagesDto imagesDto :dto.getImagesDtos()){
                if(imagesDto.getId()==null) {
                    err.addAll(ImagesValidator.Validate(imagesDto));
                    if(!err.isEmpty()){
                        throw new InvalidEntityException("Images Entity Not Valid {}" ,Errorcode.IMAGE_NOT_VALID_EXCEPTION,err);
                    }
                    img.add(imagesServiceImpl.save(imagesDto));
                }else{
                    err2.addAll(ImagesValidator.Validate(imagesDto));
                    if(!err2.isEmpty()){
                        img.add(imagesServiceImpl.findById(imagesDto.getId()));
                    }else img.add(imagesServiceImpl.save(imagesDto));
                }
            }
            dto.setImagesDtos(img);
        }

        if (dto.getPromotion()!=null){
            dto.setPromotion(dto.getPromotion());
        }

        try {
            return ProductDto.fromEntity(productRepo.save(ProductDto.toEntity(dto )),true);

        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public List<ProductDto> findAll() {
        return productRepo.findAll()
                .stream()
                .map(val->ProductDto.fromEntity(val ,true))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findByName(String Name) {
        return  productRepo.findByName(Name).stream()
                .map(val->ProductDto.fromEntity(val ,true))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findAllProductBySKUId(Long skuDto) {
        SKUDto dto = SKUServiceImpl.findById(skuDto);
        return productRepo.findAllBySku(SKUDto.toEntity(dto)).stream()
                .map(val->ProductDto.fromEntity(val ,true))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findAllProductBySKUName(String skuDto) {
        SKUDto dto = SKUServiceImpl.findByName(skuDto);
        return productRepo.findAllBySku(SKUDto.toEntity(dto)).stream()
                .map(val->ProductDto.fromEntity(val ,true))
                .collect(Collectors.toList());
    }


    @Override
    public void deleteProduct(Long Id) {
        ProductDto product = findById(Id);

        try {
            product.setCategoryDto(null);
            product.getProductitems().forEach(p->{
                p.setVariation_optionDtos(null);
                p.setVariation_optionDtos(null);
                product_itemServiceImpl.deleteProduct_itemById(p.getId());
            });
            product.setProductitems(null);
            productRepo.delete(ProductDto.toEntity(product));
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public List<DescriptionsDto> findAllDescriptionByProductId(Long Id) {
        ProductDto productDto = findById(Id);
        return productDto.getDescriptionsDtos();
    }

    @Override
    public List<ProductDto> findProductByCategory(Long CategoryId) {
        CategoryDto dto = categoryServiceImpl.findById(CategoryId);
        return productRepo.findAllByCategory(CategoryDto.toEntity(dto)).stream()
                .map(val->ProductDto.fromEntity(val ,true))
                .collect(Collectors.toList());
    }

    @Override
    public List<ImagesDto> findAllImagesByProductId(Long Id) {
        ProductDto productDto = findById(Id);
        return productDto.getImagesDtos();
    }

    @Override
    public List<Product_reviewDto> findAllProduct_reviewByProductId(Long Id) {
        ProductDto productDto = findById(Id);
        return productDto.getProduct_reviewDtos();
    }

    @Override
    public List<Product_itemDto> findAllVariationProductByProductId(Long Id) {
        ProductDto dto = findById(Id);
        return dto.getProductitems();
    }

    @Override
    public ProductDto update_promotion_on_product(Promotion_detailDto dto, Long productid) {
        ProductDto productDto = findById(productid);
        productDto.setPromotion(promotion_detailServiceImpl.save(dto));

        return save(productDto);
    }
}

package com.gmc_team.e_commerse_platform.Services.ServiceImpl;

import com.gmc_team.e_commerse_platform.Dto.CategoryDto;
import com.gmc_team.e_commerse_platform.Dto.ProductDto;
import com.gmc_team.e_commerse_platform.Repository.CategoryRepo;
import com.gmc_team.e_commerse_platform.Services.CategorService;
import com.gmc_team.e_commerse_platform.Validator.CategoryValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.gmc_team.e_commerse_platform.exceptions.Errorcode.*;

@Service
@Transactional
public class CategoryServiceImpl implements CategorService {
    private final CategoryRepo Cat_repo;
    private final Product_service_Helper productservicehelper;

    @Autowired
    public CategoryServiceImpl(CategoryRepo cat_repo, Product_service_Helper productservicehelper) {
        Cat_repo = cat_repo;
        this.productservicehelper = productservicehelper;
    }

    @Override
    public CategoryDto save(CategoryDto dto) {
        List<String> errors = CategoryValidator.Validate(dto);
        if (!errors.isEmpty()){
            throw new InvalidEntityException("the Category is Not Valid " , CATEGORY_NOT_VALID ,errors);
        }
        if(Cat_repo.findByName(dto.getName())!=null && dto.getId()== null){
            throw new InvalidOperationException("the Category Name is Already in Use " ,CATEGORY_NOT_VALID);
        }
            CategoryDto paretDto;
        if(dto.getParent_category()!= null && dto.getParent_category().getId() != null){
            paretDto = findById(dto.getParent_category().getId());
            dto.setParent_category(paretDto);
            List<CategoryDto>childList=new ArrayList<>(paretDto.getChildcats());
            childList.add(dto);
            paretDto.setChildcats(childList);
        }else if (dto.getParent_category() != null){
            if(dto.getParent_category().getName().equals(dto.getName()))
                throw new InvalidOperationException("the Category Name is Already in Use " ,CATEGORY_NOT_VALID);
            paretDto= save(dto.getParent_category());
            dto.setParent_category(paretDto);
        }


        try {
            return CategoryDto.fromEntity(Cat_repo.save(CategoryDto.toEntity(dto)));

        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public CategoryDto findById(Long Id) {
        if(Id ==null||Id <=0){
            throw new InvalidEntityException("The ID cannot be null or negative", ID_CAN_NOT_BE_NULL_OR_NEGATIVE );
        }
        return Cat_repo.findById(Id).map(CategoryDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("No Category found with ID:"
                        +Id ,CATEGORY_NOT_FOUND));
    }

    @Override
    public CategoryDto findByName(String Name) {
        if(Name.isBlank()){
            throw new InvalidOperationException("The Name can not be Empty", CATEGORY_NAME_CAN_NOT_BE_EMPTY);
        }
        CategoryDto dto = CategoryDto.fromEntity(Cat_repo.findByName(Name));
        if(dto == null){
            throw new EntityNotFoundException("No Category found with Name :: "+Name ,CATEGORY_NOT_FOUND);
        }
        return dto;
    }

    @Override
    public List<CategoryDto> findAll() {
        return Cat_repo.findAll().stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoryDto> findByParent_Category(Long Paret_CatId) {
        CategoryDto dto = findById(Paret_CatId);
        return Cat_repo.findCategoriesByParentcategory(CategoryDto.toEntity(dto)).stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        CategoryDto dto = findById(id);
        List<ProductDto> product_Will_delete= productservicehelper.findProductByCategory(dto);
        try {
            product_Will_delete.forEach(p-> productservicehelper.deleteProduct(p.getId()));
            Cat_repo.deleteById(id);
            List<CategoryDto> list = findByParent_Category(id);
            list.forEach(c->{
                c.setParent_category(null);
                save(c);
            });
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage(),Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }
    }

    @Override
    public List<CategoryDto> findAllByOnlineStore(Long Id) {
        return Cat_repo.findAllByOnlineshop(Id).stream()
                .map(CategoryDto::fromEntity)
                .collect(Collectors.toList());
    }


}

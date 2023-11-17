package com.gmc_team.e_commerse_platform.Services.ServiceImpl;

import com.gmc_team.e_commerse_platform.Dto.Shopping_cartDto;
import com.gmc_team.e_commerse_platform.Dto.Shopping_cart_itemDto;
import com.gmc_team.e_commerse_platform.Repository.Shopping_cartRepo;
import com.gmc_team.e_commerse_platform.Repository.Shopping_cart_itemRepo;
import com.gmc_team.e_commerse_platform.Services.Shopping_cart_itemService;
import com.gmc_team.e_commerse_platform.Validator.Shopping_cart_itemValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import com.gmc_team.e_commerse_platform.models.Shopping_cart;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Transactional
public class Shopping_cart_itemServiceImpl implements Shopping_cart_itemService {
    private final Shopping_cart_itemRepo shopping_cart_itemRepo;
    private final Product_itemServiceImpl product_itemServiceImpl;
    private final Shopping_cartRepo shopping_cartRepo;

    public Shopping_cart_itemServiceImpl(Shopping_cart_itemRepo shopping_cart_itemRepo, Product_itemServiceImpl product_itemServiceImpl, Shopping_cartRepo shopping_cartRepo) {
        this.shopping_cart_itemRepo = shopping_cart_itemRepo;
        this.product_itemServiceImpl = product_itemServiceImpl;
        this.shopping_cartRepo = shopping_cartRepo;
    }

    @Override
    public Shopping_cart_itemDto findById(Long Id) {
        return shopping_cart_itemRepo.findById(Id).map(Shopping_cart_itemDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("No shopping cart item found with ID:"
                        +Id , Errorcode.SHOPPING_CART_ITEM_NOT_FOUND));
    }

    @Override
    public Shopping_cart_itemDto save(Shopping_cart_itemDto dto) {
        List<String> errors = Shopping_cart_itemValidator.Validate(dto);
        if(!errors.isEmpty()){
            throw new InvalidEntityException("The shopping Cart item not Valid {}",
                    Errorcode.SHOPPING_CART_ITEM_NOT_VALID,errors );
        }
        if(dto.getProduct_item().getId() !=null){
            dto.setProduct_item(product_itemServiceImpl.findById(dto.getProduct_item().getId()));
        }else {
            dto.setProduct_item(product_itemServiceImpl.save(dto.getProduct_item()));
        }
        try {
            return Shopping_cart_itemDto.fromEntity(shopping_cart_itemRepo.save(Shopping_cart_itemDto.toEntity(dto)));

        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    public void delete(Long shoppingCartItemId) {
        try {
            Shopping_cart_itemDto dto= findById(shoppingCartItemId);
            Shopping_cart shoppingCart = shopping_cartRepo
                    .findByShoppinglistContaining(
                    Shopping_cart_itemDto.toEntity(dto)
            );
            shoppingCart.setShoppinglist(
                    shoppingCart.getShoppinglist().stream()
                    .filter(l-> !Objects.equals(dto.getId(), l.getId()))
                    .collect(Collectors.toList())
            );
            shopping_cartRepo.save(shoppingCart);
            shopping_cart_itemRepo.delete(Shopping_cart_itemDto.toEntity(dto));
        }catch(DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage(),Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }

    }
    private Shopping_cartDto findshoppingcart(Long Id){
        return shopping_cartRepo.findById(Id).map(Shopping_cartDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("No shopping cart found with ID:"
                        +Id , Errorcode.SHOPPING_CART_NOT_FOUND));
    }
}

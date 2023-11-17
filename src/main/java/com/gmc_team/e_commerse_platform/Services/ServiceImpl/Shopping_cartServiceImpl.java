package com.gmc_team.e_commerse_platform.Services.ServiceImpl;

import com.gmc_team.e_commerse_platform.Dto.*;
import com.gmc_team.e_commerse_platform.Repository.Shopping_cartRepo;
import com.gmc_team.e_commerse_platform.Services.Shopping_cartService;
import com.gmc_team.e_commerse_platform.Validator.Shopping_cartValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class Shopping_cartServiceImpl implements Shopping_cartService {
    private final Shopping_cartRepo shopping_cartRepo;
    private final CustomerServiceImpl customerServiceImpl;
    private final Shopping_cart_itemServiceImpl shopping_cart_itemServiceImpl;

    public Shopping_cartServiceImpl(Shopping_cartRepo shopping_cartRepo, CustomerServiceImpl customerServiceImpl, Shopping_cart_itemServiceImpl shopping_cart_itemServiceImpl) {
        this.shopping_cartRepo = shopping_cartRepo;
        this.customerServiceImpl = customerServiceImpl;
        this.shopping_cart_itemServiceImpl = shopping_cart_itemServiceImpl;
    }

    @Override
    public Shopping_cartDto save(Shopping_cartDto dto) {
        List<String> errors = Shopping_cartValidator.Validate(dto);
        if(!errors.isEmpty()){
            throw new InvalidEntityException("The Shopping Cart not Valid {}",
                    Errorcode.SHOPPING_CART_NOT_VALID ,errors);
        }
        dto.setShopping_listDto(
                dto.getShopping_listDto().stream().map(shopping_cart_itemServiceImpl::save).collect(Collectors.toList())
        );

        try {
            return Shopping_cartDto.fromEntity(shopping_cartRepo.save(
                Shopping_cartDto.toEntity(dto)
        ));

        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public Shopping_cartDto findById(Long Id) {
        return shopping_cartRepo.findById(Id).map(Shopping_cartDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("No shopping cart found with ID:"
                        +Id , Errorcode.SHOPPING_CART_NOT_FOUND));
    }

    @Override
    public List<Shopping_cartDto> findByCustomerId(Long Id) {
        CustomersDto dto= customerServiceImpl.findById(Id);

        return shopping_cartRepo.findAllByCustomers(CustomersDto.toEntity(dto))
                .stream()
                .map(Shopping_cartDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long shoppingCartId) {
        try {
            Shopping_cartDto dto = findById(shoppingCartId);
            dto.setCustomersId(null);
            dto.getShopping_listDto().forEach(i -> {
                i.setProduct_item(null);
                shopping_cart_itemServiceImpl.save(i);
            });
            dto.setShopping_listDto(null);
            save(dto);
            shopping_cartRepo.delete(Shopping_cartDto.toEntity(dto));
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() ,Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception ex){
            throw new InvalidOperationException(ex.getMessage());
        }
    }

    @Override
    public OrderDto convert_shoppingcart_into_order(Shopping_cartDto dto) {
        List<Order_lineDto> orderlines = new ArrayList<>();
        BigDecimal fullprice = new BigDecimal(0);

        for (Shopping_cart_itemDto item : dto.getShopping_listDto()) {
            orderlines.add(convertCartlineToOrderline(item));
            fullprice = fullprice.add(item.getQte().multiply(item.getProduct_item().getPrice()));
        }


        return OrderDto.builder()
                .customer_id(dto.getCustomersId().getId())
                .onlineshop(dto.getOnline_shop())
                .orderLines(orderlines)
                .full_price(fullprice)
                .build();
    }

    @Override
    public OrderDto convert_shoppingcart_into_order(Long id) {
        Shopping_cartDto dto = findById(id);
        List<Order_lineDto> orderlines = new ArrayList<>();
        BigDecimal fullprice = new BigDecimal(0);

        for (Shopping_cart_itemDto item : dto.getShopping_listDto()) {
            orderlines.add(convertCartlineToOrderline(item));
            fullprice = fullprice.add(item.getQte().multiply(item.getProduct_item().getPrice()));
        }


        return OrderDto.builder()
                .customer_id(dto.getCustomersId().getId())
                .onlineshop(dto.getOnline_shop())
                .orderLines(orderlines)
                .full_price(fullprice)
                .build();
    }

    private Order_lineDto convertCartlineToOrderline(Shopping_cart_itemDto dto){
        return Order_lineDto.builder()
                .online_shop(dto.getOnline_shop())
                .product_itemDto(dto.getProduct_item())
                .qte(dto.getQte())
                .price(dto.getProduct_item().getPrice().multiply(dto.getQte()))
                .build();
    }
}

package com.gmc_team.e_commerse_platform.Services.ServiceImpl;

import com.gmc_team.e_commerse_platform.Dto.Order_lineDto;
import com.gmc_team.e_commerse_platform.Dto.Product_itemDto;
import com.gmc_team.e_commerse_platform.Repository.Order_lineRepo;
import com.gmc_team.e_commerse_platform.Services.Order_lineService;
import com.gmc_team.e_commerse_platform.Validator.Order_lineValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class Order_lineServiceImpl implements Order_lineService {


    private final Order_lineRepo order_lineRepo;
    private final Product_itemServiceImpl product_itemServiceImpl;

    @Autowired
    public Order_lineServiceImpl(Order_lineRepo order_lineRepo, Product_itemServiceImpl product_itemServiceImpl) {
        this.order_lineRepo = order_lineRepo;
        this.product_itemServiceImpl = product_itemServiceImpl;
    }

    @Override
    public Order_lineDto findById(Long Id) {
        return order_lineRepo.findById(Id)
                .map(Order_lineDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("No Order line with the following Id :"+Id
                , Errorcode.ORDER_LINE_NOT_FOUND));
    }

    @Override
    public Order_lineDto save(Order_lineDto dto) {
        List<String> errors = Order_lineValidator.Validate(dto);
        if(!errors.isEmpty()){
            throw new InvalidEntityException("Order Line not valid {}" ,Errorcode.ORDER_LINE_NOT_VALID
            ,errors);
        }
        if (dto.getProduct_itemDto().getQte().compareTo(BigDecimal.ZERO)<=0){
            throw new InvalidOperationException("the Product with id :' "+dto.getProduct_itemDto().getId()+" 'is unavailable ");
        }
        BigDecimal rest = dto.getProduct_itemDto().getQte().subtract(dto.getQte());
        if (rest.compareTo(BigDecimal.ZERO) <=0){
            throw new InvalidOperationException("The quantity you ordered is less than the quantity" +
                    " available in stock in the product id: "+dto.getProduct_itemDto().getId());
        }
        dto.getProduct_itemDto().setQte(rest);
        product_itemServiceImpl.save(dto.getProduct_itemDto());
        try {
            return Order_lineDto.fromEntity(order_lineRepo.save(Order_lineDto.toEntity(dto)));
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public List<Order_lineDto> findByProduct(Long productId) {
        Product_itemDto item = product_itemServiceImpl.findById(productId);
        if(item == null){
            throw new EntityNotFoundException("No product with the following id :"+productId
            ,Errorcode.PRODUCT_NOT_FOUND);
        }

        return order_lineRepo.findByProductitem(Product_itemDto.toEntity(item))
                .stream().map(Order_lineDto::fromEntity)
                .collect(Collectors.toList());

    }

    @Override
    public Order_lineDto cancelOrderLines(Order_lineDto line) {
        BigDecimal q = line.getQte().add(line.getProduct_itemDto().getQte());
        Product_itemDto itemDto=line.getProduct_itemDto();
        itemDto.setQte(q);
        line.setProduct_itemDto(
                itemDto
        );
        product_itemServiceImpl.save(itemDto);
        return line;
    }
}

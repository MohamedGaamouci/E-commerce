package com.gmc_team.e_commerse_platform.Services.ServiceImpl;
import com.gmc_team.e_commerse_platform.Dto.OrderDto;
import com.gmc_team.e_commerse_platform.Dto.Order_reviewDto;
import com.gmc_team.e_commerse_platform.Repository.OrderRepo;
import com.gmc_team.e_commerse_platform.Repository.Order_reviewRepo;
import com.gmc_team.e_commerse_platform.Services.Order_reviewService;
import com.gmc_team.e_commerse_platform.Validator.Order_reviewValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.gmc_team.e_commerse_platform.exceptions.Errorcode.ORDER_NOT_FOUND;

@Service
@Transactional
public class Order_reviewServiceImpl implements Order_reviewService {
    private final Order_reviewRepo repo;
    private final OrderRepo Orderrepo;

    @Autowired
    public Order_reviewServiceImpl(Order_reviewRepo repo,
                                   OrderRepo orderrepo) {
        this.repo = repo;
        Orderrepo = orderrepo;
    }

    @Override
    public Order_reviewDto save(Order_reviewDto Id) {
        List<String> errors = Order_reviewValidator.Validate(Id);
        if(!errors.isEmpty()){
            throw new InvalidEntityException("Order Review is not Valid {}"
            ,Errorcode.ORDER_REVIEW_NOT_VALID,errors);
        }

        try {
            return Order_reviewDto.fromEntity(repo.save(Order_reviewDto.toEntity(Id)));

        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public Order_reviewDto findById(Long Id) {
        return repo.findById(Id)
                .map(Order_reviewDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("No review with the Id ::"+Id , Errorcode.REVIEW_NOT_FOUND));
    }

    @Override
    public Order_reviewDto findByCustomer_id(Long Id) {
        return Order_reviewDto.fromEntity(repo.findByCustomerid(Id));
    }

    @Override
    public List<Order_reviewDto> findByRating(Integer rating) {
        return repo.findByRating(rating)
                .stream().map(Order_reviewDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Order_reviewDto findByCustomer_orderId(Long Id) {
        OrderDto dto = Orderrepo.findById(Id).map(OrderDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("No Order with this Id ::"+Id, ORDER_NOT_FOUND));
        return Order_reviewDto.fromEntity(repo.findByCustomerorder(OrderDto.toEntity(dto)));
    }



}

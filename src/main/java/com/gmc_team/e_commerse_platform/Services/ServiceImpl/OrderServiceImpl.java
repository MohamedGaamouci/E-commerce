package com.gmc_team.e_commerse_platform.Services.ServiceImpl;

import com.gmc_team.e_commerse_platform.Dto.*;
import com.gmc_team.e_commerse_platform.Repository.OrderRepo;
import com.gmc_team.e_commerse_platform.Services.OrderService;
import com.gmc_team.e_commerse_platform.Validator.OrderValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import com.gmc_team.e_commerse_platform.models.Order_status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.gmc_team.e_commerse_platform.exceptions.Errorcode.CUSTOMER_ORDER_NOT_VALID;
import static com.gmc_team.e_commerse_platform.exceptions.Errorcode.ORDER_NOT_FOUND;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepo customerOrderRepo;
    private final Shipping_methodServiceImpl methodService;
    private final Customer_payment_mehtodServiceImpl paymentMehtodService;
    private final AddressServiceImpl addressService;
    private final Order_reviewServiceImpl review;
    private final Order_lineServiceImpl order_lineServiceImpl;
    private final CustomerServiceImpl customerServiceImpl;


    @Autowired
    public OrderServiceImpl(OrderRepo customerOrderRepo,
                            Shipping_methodServiceImpl methodService,
                            Customer_payment_mehtodServiceImpl paymentMehtodService,
                            AddressServiceImpl addressService,
                            Order_reviewServiceImpl review, Order_lineServiceImpl order_lineServiceImpl, CustomerServiceImpl customerServiceImpl) {
        this.customerOrderRepo = customerOrderRepo;
        this.methodService = methodService;
        this.paymentMehtodService=paymentMehtodService;
        this.addressService = addressService;
        this.review = review;
        this.order_lineServiceImpl = order_lineServiceImpl;
        this.customerServiceImpl = customerServiceImpl;
    }

    @Override
    public OrderDto save(OrderDto dto) {
        List<String> errors = OrderValidator.Validate(dto);
        if(!errors.isEmpty()){
            throw new InvalidEntityException("The Order Is Not Valid {}",
                    CUSTOMER_ORDER_NOT_VALID,
                    errors);
        }
        customerServiceImpl.findById(dto.getCustomer_id());

        if(dto.getShippingMethodDto().getId()!=null){
            Shipping_methodDto shipping_methodDto = methodService.findById(dto.getShippingMethodDto().getId());
            dto.setShippingMethodDto(shipping_methodDto);
        }
        else{
            throw new InvalidEntityException("You should sellect Shipping method {}",CUSTOMER_ORDER_NOT_VALID);
        }
        if(dto.getPaymentMethodDto().getId()!=null){
            Customer_payment_mehtodDto paymentMehtodDto = paymentMehtodService
                    .findById(dto.getPaymentMethodDto().getId());
            dto.setPaymentMethodDto(paymentMehtodDto);
        }
        else{
            throw new InvalidEntityException("You should sellect Payment method {}",CUSTOMER_ORDER_NOT_VALID);
        }
        AddressDto addressDto;

        if(dto.getShipping_addressDto().getId()!=null){
            addressDto = addressService
                    .findById(dto.getShipping_addressDto().getId());
        }
        else{
            addressDto = addressService.save(dto.getShipping_addressDto());
        }

        dto.setShipping_addressDto(addressDto);
        dto.getOrderLines().forEach(line ->{
            if (line.getId()==null){
                order_lineServiceImpl.save(line);
            }
        });

        dto.setOrder_status(Order_status.processing);


        try {
            return OrderDto
                .fromEntity(customerOrderRepo.save(OrderDto.toEntity(dto)));

        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public OrderDto findById(Long Id) {
        if(Id == null||Id <=0){
            throw new InvalidOperationException("the Id can not be Null or Negative ", Errorcode.ID_CAN_NOT_BE_NULL_OR_NEGATIVE);
        }
        return customerOrderRepo.findById(Id).map(OrderDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("No Order with this Id ::"+Id, ORDER_NOT_FOUND));
    }

    @Override
    public List<OrderDto> findAll() {
        return customerOrderRepo.findAll().stream()
                .map(OrderDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> findByOrder_status(Order_status status) {
        return customerOrderRepo.findCustomer_ordersByOrderstatus(status)
                .stream().map(OrderDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> findByShippingMethodDto(Long Id) {
        Shipping_methodDto dto = methodService.findById(Id);

        return customerOrderRepo.findAllByShippingMethod(Shipping_methodDto.toEntity(dto))
                .stream().map(OrderDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> findBycustomer_id(Long Id) {
        return customerOrderRepo.findAllByCustomerid(Id)
                .stream().map(OrderDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> findByPaymentMethodDtoId(Long Id) {
        Customer_payment_mehtodDto dto = paymentMehtodService.findById(Id);

        return customerOrderRepo.findAllByPaymentmethod(Customer_payment_mehtodDto.toEntity(dto))
                .stream().map(OrderDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> findByShipping_addressDtoId(Long Id) {
        AddressDto dto = addressService.findById(Id);

        return customerOrderRepo.findAllByShippingaddress(AddressDto.toEntity(dto))
                .stream().map(OrderDto::fromEntity)
                .collect(Collectors.toList());
    }
    @Override
    public OrderDto findByreviewDtoId(Long Id) {

        Order_reviewDto dto = review.findById(Id);

        return OrderDto.fromEntity(customerOrderRepo.findByReview(Order_reviewDto.toEntity(dto)));
    }

    @Override
    public OrderDto updateStatus(Order_status status,Long orderid) {
        OrderDto dto = findById(orderid);
        dto.setOrder_status(status);
        return OrderDto.fromEntity(customerOrderRepo.save(OrderDto.toEntity(dto)));
    }

    @Override
    public OrderDto cancel_or_return_Order(Long orderid, Order_status status) {
        if (!(status.equals(Order_status.canceled) ||status.equals(Order_status.returned))){
            throw new InvalidOperationException("this api accept just the cancel or returned" +
                    "orders ");
        }
        OrderDto dto = findById(orderid);

        for (Order_lineDto orderLine : dto.getOrderLines()) {
            order_lineServiceImpl.cancelOrderLines(orderLine);
        }

        dto.setOrder_status(status);
        customerOrderRepo.save(OrderDto.toEntity(dto));
        return dto;
    }


}

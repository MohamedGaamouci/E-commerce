package com.gmc_team.e_commerse_platform.Services.ServiceImpl;

import com.gmc_team.e_commerse_platform.Dto.*;
import com.gmc_team.e_commerse_platform.Repository.CustomerRepo;
import com.gmc_team.e_commerse_platform.Repository.Online_shopRepo;
import com.gmc_team.e_commerse_platform.Repository.Online_shop_reviewRepo;
import com.gmc_team.e_commerse_platform.Services.Online_shopService;
import com.gmc_team.e_commerse_platform.Validator.EmployeeValidator;
import com.gmc_team.e_commerse_platform.Validator.Online_shopValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import com.gmc_team.e_commerse_platform.models.Online_shop;
import com.gmc_team.e_commerse_platform.models.Specialities;
import com.gmc_team.e_commerse_platform.models.Store_status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.gmc_team.e_commerse_platform.exceptions.Errorcode.*;

@Service
@Transactional
public class Online_shopServiceImpl implements Online_shopService {
    private final Online_shopRepo online_shopRepo;
    private final SellerServiceImpl sellerServiceImpl;
    private final DescriptionServiceImpl descriptionServiceImpl;
    private final CustomerStore_helper findCustomerhelper;
    private final Online_shop_reviewRepo online_shop_reviewRepo;
    private final Customer_payment_mehtodServiceImpl customer_payment_mehtodServiceImpl;
    private final CustomerRepo customerRepo;

    @Autowired
    public Online_shopServiceImpl(Online_shopRepo online_shopRepo, SellerServiceImpl sellerServiceImpl, DescriptionServiceImpl descriptionServiceImpl, CustomerStore_helper findCustomerhelper, Online_shop_reviewRepo online_shop_reviewRepo, Customer_payment_mehtodServiceImpl customer_payment_mehtodServiceImpl, CustomerRepo customerRepo) {
        this.online_shopRepo = online_shopRepo;
        this.sellerServiceImpl = sellerServiceImpl;
        this.descriptionServiceImpl = descriptionServiceImpl;
        this.findCustomerhelper = findCustomerhelper;
        this.online_shop_reviewRepo = online_shop_reviewRepo;
        this.customer_payment_mehtodServiceImpl = customer_payment_mehtodServiceImpl;
        this.customerRepo = customerRepo;
    }

    @Override
    public Online_shopDto findById(Long Id) {
        return online_shopRepo.findById(Id)
                .map(val->Online_shopDto.fromEntity(val ,true))
                .orElseThrow(()->new EntityNotFoundException("No store with the following id ::"+Id ,
                        Errorcode.ONLINE_SHOP_NOT_FOUND_EXCEPTION));
    }

    @Override
    public Online_shopDto save(Online_shopDto dto) {
        List<String> errors = Online_shopValidator.Validate(dto);
        if(!errors.isEmpty()){
            throw new InvalidEntityException("The Online Shop Not Valid {}",
                    Errorcode.ONLINE_SHOP_NOT_VALID_EXCEPTION,errors);
        }
        SellersDto sellersDto = sellerServiceImpl.findById(dto.getStore_owner().getId());
        Online_shop online = online_shopRepo.findByStoreowner(SellersDto.toEntity(sellersDto));
        if(online != null && dto.getId()==null){
            throw new InvalidOperationException("This User (owner) already have an online store ");
        }
        dto.setStore_owner(sellersDto);
        if(dto.getEmployeesDtos()!= null){
        List<SellersDto> employees = dto.getEmployeesDtos().stream()
                .map(emp->sellerServiceImpl.findById(emp.getId()))
                .collect(Collectors.toList());
        dto.setEmployeesDtos(employees);}
        List<DescriptionsDto> descriptionsDtos = new ArrayList<>();
        dto.getStore_descriptionsDtos().forEach(des->{
            if(des.getId()!=null){
                descriptionsDtos.add(descriptionServiceImpl.findById(des.getId()));
            }else{
                descriptionsDtos.add(descriptionServiceImpl.save(des));
            }
        });
        dto.setStore_descriptionsDtos(descriptionsDtos);

        Online_shopDto shopDto= Online_shopDto.fromEntity(online_shopRepo.save(Online_shopDto.toEntity(dto)),true);
        sellersDto.setOnlineshop(shopDto.getId());

        List<CustomersDto> store_customer= new ArrayList<>();
        if (dto.getStorecustomers()!=null){
            dto.getStorecustomers().forEach(reg->{
                if(reg.getId() !=null){
                    store_customer.add(findCustomerhelper.findById(reg.getId()));
                }else {
                    throw new InvalidOperationException("the Customer Id Can not Be Null "
                            , CUSTOMER_NOT_VALID);
                }
            });
        }
        dto.setStorecustomers(store_customer);
        if(dto.getId()==null){
            dto.setStore_status(Store_status.under_review);
        }


        try {
            return Online_shopDto.fromEntity(online_shopRepo.save(Online_shopDto.toEntity(shopDto)),true);

        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public List<Online_shopDto> findByName(String Name) {
        return online_shopRepo.findByStorename(Name)
                .stream().map(val->Online_shopDto.fromEntity(val ,true))
                .collect(Collectors.toList());
    }



    @Override
    public Online_shopDto findByOwnerId(Long Id) {
        SellersDto dto = sellerServiceImpl.findById(Id);
        if(dto==null){
            throw new EntityNotFoundException("No owner with the following Id:"+Id ,
                    Errorcode.SELLER_NOT_FOUND);
        }
        Online_shop dto2 = online_shopRepo.findByStoreowner(SellersDto.toEntity(dto));
        if(dto2==null){
            throw new EntityNotFoundException("No store with the following owner Id:"+Id ,
                    Errorcode.ONLINE_SHOP_NOT_FOUND_EXCEPTION);
        }
        return Online_shopDto.fromEntity(dto2 ,true);
    }

    @Override
    public List<Online_shopDto> findAll() {
        return online_shopRepo.findAll()
                .stream().map(val->Online_shopDto.fromEntity(val ,true))
                .collect(Collectors.toList());
    }

    @Override
    public List<Online_shopDto> findByStore_status(Store_status status) {
        return online_shopRepo.findByStorestatus(status)
                .stream().map(val->Online_shopDto.fromEntity(val ,true))
                .collect(Collectors.toList());
    }

    @Override
    public List<Online_shopDto> findByRating(Float Haut ,Float base) {
        return online_shopRepo.findByRatingGreaterThanEqualAndRatingLessThanEqual(base ,Haut)
                .stream().map(val->Online_shopDto.fromEntity(val ,true))
                .collect(Collectors.toList());
    }

    @Override
    public List<Online_shopDto> findBySpeciality(Specialities Speciality) {
        return online_shopRepo.findBySpeciality(Speciality)
                .stream().map(val->Online_shopDto.fromEntity(val ,true))
                .collect(Collectors.toList());
    }

    @Override
    public List<Online_shopDto> findByOtherSpeciality(String Speciality) {
        return online_shopRepo.findByAnotherspecialtyIgnoreCase(Speciality)
                .stream().map(val->Online_shopDto.fromEntity(val ,true))
                .collect(Collectors.toList());
    }

    @Override
    public Online_shopDto AddNewEmployee(SellersDto dto ){
        List<String> errors = EmployeeValidator.Validate(dto);
        if(!errors.isEmpty()){
            throw new InvalidEntityException("Employee not Valid {}",
                    Errorcode.SELLER_NOT_VALID,errors);
        }
        Online_shopDto store = findById(dto.getOnlineshop());
        dto = sellerServiceImpl.save(dto);

        List<SellersDto> employees = new ArrayList<>(store.getEmployeesDtos());

        SellersDto finalDto = dto;
        employees = employees.stream().filter(emp-> !Objects.equals(emp.getId(), finalDto.getId()))
                        .collect(Collectors.toList());

        employees.add(dto);
        store.setEmployeesDtos(employees);
        return save(store);

    }

    @Override
    public Online_shopDto AddNewCustomer(Long CustomerId ,Long StoreId) {

        CustomersDto dto = findCustomerhelper.findById(CustomerId);
        dto.setRegisterstores(null);
        Online_shopDto shopDto = findById(StoreId);

        List<CustomersDto> customers = new ArrayList<>(shopDto.getStorecustomers());
        customers = customers.stream().filter(emp-> !Objects.equals(emp.getId(), dto.getId()))
                .collect(Collectors.toList());
        customers.add(dto);
        shopDto.setStorecustomers(customers);

        List<Online_shopDto> stores = new ArrayList<>(dto.getRegisterstores());
        stores = stores.stream().filter(emp-> !Objects.equals(emp.getId(), shopDto.getId()))
                .collect(Collectors.toList());
        stores.add(shopDto);
        dto.setRegisterstores(stores);

        findCustomerhelper.save(dto);



        return save(shopDto);
    }

    @Override
    public void disactivate(Long storeId) {
        Online_shopDto shopDto=findById(storeId);
        shopDto.setStore_status(Store_status.disactive);
        save(shopDto);
    }

    @Override
    public void activate(Long storeId) {
        Online_shopDto shopDto=findById(storeId);
        shopDto.setStore_status(Store_status.active);
        save(shopDto);
    }

    @Override
    public Store_status getstatus(Long storeId) {
        Online_shopDto shopDto=findById(storeId);
        return shopDto.getStore_status();
    }

    @Override
    public void delete_review(Long review,Long store) {
        Online_shop_reviewDto dto =online_shop_reviewRepo.findById(review)
                .map(Online_shop_reviewDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("No shop review with the following Id :"+review
                        , Errorcode.SHOP_REVIEW_NOT_FOUND_EXCEPTION));

        Online_shop shop=Online_shopDto.toEntity(findById(store));

            shop.setOnlineshopreviews(
                    shop.getOnlineshopreviews().stream()
                            .filter(r->!Objects.equals(dto.getId() ,r.getId()))
                            .collect(Collectors.toList())
            );
            try {
                online_shopRepo.save(shop);
            }catch(DataAccessException ex){
                throw new InvalidDataBaseOperationException(ex.getMessage() ,SQL_STATEMENT_FAILD_OPERATION);
            }catch (Exception e){
                throw new InvalidOperationException(e.getMessage());
            }
            deleteReview(review);

    }

    @Override
    public void delete_description(Long description ,Long store){
        DescriptionsDto dto = descriptionServiceImpl.findById(description);
        Online_shop shop=Online_shopDto.toEntity(findById(store));
            shop.setStoredescriptions(
                    shop.getStoredescriptions().stream()
                            .filter(d->!Objects.equals(dto.getId() ,d.getId()))
                            .collect(Collectors.toList())
            );
            try {
                online_shopRepo.save(shop);
                descriptionServiceImpl.delete(description);
            }catch(DataAccessException ex){
                throw new InvalidDataBaseOperationException(ex.getMessage() ,SQL_STATEMENT_FAILD_OPERATION);
            }catch (Exception e){
                throw new InvalidOperationException(e.getMessage());
            }

    }

    @Override
    public Online_shopDto addPaymentMethod(Long PaymentId,Long store) {
        Customer_payment_mehtodDto paymentMehtodDto = customer_payment_mehtodServiceImpl.findById(PaymentId);
        Online_shopDto shopDto=findById(store);
        List<Customer_payment_mehtodDto> list=new ArrayList<>(shopDto.getPaymentMehtods());
        list.add(paymentMehtodDto);
        shopDto.setPaymentMehtods(
                shopDto.getPaymentMehtods().stream()
                        .filter(p->!Objects.equals(p.getId() ,paymentMehtodDto.getId()))
                        .collect(Collectors.toList())
        );
        try {
            online_shopRepo.save(Online_shopDto.toEntity(shopDto));
        }catch(DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() ,SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }

        return shopDto;
    }

    @Override
    public void deletePaymentMethod(Long PaymentId,Long store) {
        Customer_payment_mehtodDto paymentMehtodDto = customer_payment_mehtodServiceImpl.findById(PaymentId);
        Online_shopDto shopDto=findById(store);
        shopDto.setPaymentMehtods(
                shopDto.getPaymentMehtods().stream()
                        .filter(p->!Objects.equals(p.getId() ,paymentMehtodDto.getId()))
                        .collect(Collectors.toList())
        );
        try {
            online_shopRepo.save(Online_shopDto.toEntity(shopDto));
        }catch(DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() ,SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
        customer_payment_mehtodServiceImpl.delete(PaymentId);
    }

    @Override
    public void deleteEmployee(Long employeeId,Long store) {
        Online_shop shopDto = Online_shopDto.toEntity(findById(store));
        SellersDto seller = sellerServiceImpl.findById(employeeId);
        shopDto.setEmployees(
                shopDto.getEmployees().stream()
                        .filter(e->!Objects.equals(e.getId(),seller.getId()))
                        .collect(Collectors.toList())
        );
        try {
            online_shopRepo.save(shopDto);
            sellerServiceImpl.delete(employeeId);
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() ,SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public void deletecustomer(Long customerId, Long store) {
        Online_shop shopDto = Online_shopDto.toEntity(findById(store));
        findCustomerById(customerId);
        shopDto.setStorecustomers(
                shopDto.getStorecustomers().stream()
                        .filter(e->!Objects.equals(e.getId(),customerId))
                        .collect(Collectors.toList())
        );
        try {
            online_shopRepo.save(shopDto);
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() ,SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    public CustomersDto findCustomerById(Long Id) {
        return customerRepo.findById(Id).map(val->CustomersDto.fromEntity(val ,true))
                .orElseThrow(()->new EntityNotFoundException("No Customer found with ID:"
                        +Id ,CUSTOMER_NOT_FOUND));
    }

    private void deleteReview(Long onlinshop_review) {
        try {
            online_shop_reviewRepo.deleteById(onlinshop_review);
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() ,Errorcode.SQL_STATEMENT_FAILD_OPERATION );
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }
}

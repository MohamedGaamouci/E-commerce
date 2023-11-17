package com.gmc_team.e_commerse_platform.Services.ServiceImpl;

import com.gmc_team.e_commerse_platform.Dto.AddressDto;
import com.gmc_team.e_commerse_platform.Dto.CustomersDto;
import com.gmc_team.e_commerse_platform.Dto.Online_shopDto;
import com.gmc_team.e_commerse_platform.Dto.ProductDto;
import com.gmc_team.e_commerse_platform.Repository.CustomerRepo;
import com.gmc_team.e_commerse_platform.Services.CustomerService;
import com.gmc_team.e_commerse_platform.Validator.CustomerValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import com.gmc_team.e_commerse_platform.models.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static com.gmc_team.e_commerse_platform.exceptions.Errorcode.*;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepo customerRepo;
    private final AddressServiceImpl addressServiceImpl;
    private final Online_shopServiceImpl online_shopServiceImpl;
    private final ProductServiceImpl productServiceImpl;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo, AddressServiceImpl addressServiceImpl, Online_shopServiceImpl online_shopServiceImpl, ProductServiceImpl productServiceImpl) {
        this.customerRepo = customerRepo;
        this.addressServiceImpl = addressServiceImpl;
        this.online_shopServiceImpl = online_shopServiceImpl;
        this.productServiceImpl = productServiceImpl;
    }

    @Override
    public CustomersDto findById(Long Id) {
         return customerRepo.findById(Id).map(val->CustomersDto.fromEntity(val ,true))
                .orElseThrow(()->new EntityNotFoundException("No Customer found with ID:"
                        +Id ,CUSTOMER_NOT_FOUND));
    }

    @Override
    public CustomersDto save(CustomersDto dto) {
        List<String> errors = CustomerValidator.Validate(dto);
        if(!errors.isEmpty()){
            throw new InvalidEntityException("the Customer Entity not Valid {}"
                    , CUSTOMER_NOT_VALID,errors);
        }
        if(customerRepo.findByUsername(dto.getUser_Name())!=null&&dto.getId()==null){
            throw new InvalidOperationException("the Customer Username is Already Exist {"+dto.getUser_Name()+"}"
            ,CUSTOMER_ALREADY_IN_USE);
        }
        if(customerRepo.findByEmail(dto.getEmail())!=null&&dto.getId()==null){
            throw new InvalidOperationException("the Customer Email is Already Exist {"+dto.getEmail()+"}"
                    ,CUSTOMER_ALREADY_IN_USE);
        }
        List<AddressDto> add = new ArrayList<>();
        dto.getAddress().forEach(address->{
            if(address.getId() != null){
                add.add(addressServiceImpl.findById(address.getId()));
            }else {
                add.add(addressServiceImpl.save(address));
            }
        });
        dto.setAddress(add);

        List<Online_shopDto> register_Stores= new ArrayList<>();
        if(dto.getRegisterstores() !=null){
            dto.getRegisterstores().forEach(reg->{
                if(reg.getId() !=null){
                    register_Stores.add(online_shopServiceImpl.findById(reg.getId()));
                }else{
                    throw new InvalidOperationException("the Store Id Can not Be Null "
                    , ONLINE_SHOP_NOT_VALID_EXCEPTION);
                }
            });
        }
        dto.setRegisterstores(register_Stores);

        if(dto.getFavoriteproduct()!=null){
            List<ProductDto> fav=new ArrayList<>();
            dto.getFavoriteproduct().forEach(p->{
                if(p.getId()!=null){
                    fav.add(productServiceImpl.findById(p.getId()));
                }else{
                    throw new EntityNotFoundException("the favorite product must contain just the Id ");
                }
            });
            dto.setFavoriteproduct(fav);
        }


        try {
            return CustomersDto.fromEntity(
                    customerRepo.save(CustomersDto.toEntity(dto))
                    ,true);

        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public CustomersDto findByUserName(String username) {
        return CustomersDto.fromEntity(customerRepo.findByUsername(username),true);
    }

    @Override
    public List<CustomersDto> findAll() {
        return customerRepo.findAll()
                .stream().map(val->CustomersDto.fromEntity(val ,true))
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomersDto> findByNameAndSecondName(String Name, String SecondName) {
        return customerRepo.findByNameAndSecondname(Name ,SecondName)
                .stream().map(val->CustomersDto.fromEntity(val ,true))
                .collect(Collectors.toList());
    }

    @Override
    public CustomersDto findByEmail(String Email) {
        return CustomersDto.fromEntity(customerRepo.findByEmail(Email),true);
    }

    @Override
    public List<CustomersDto> findByGender(String gender) {
        return customerRepo.findByGender(gender)
                .stream().map(val->CustomersDto.fromEntity(val ,true))
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomersDto> findByRole(List<Roles> rolesName) {

        return customerRepo.findAllByRolesIn(rolesName)
                .stream().filter(customers -> new HashSet<>(customers.getRoles()).containsAll(rolesName))
                .map(val->CustomersDto.fromEntity(val ,true))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> findAllFavorite(Long customerId) {
        CustomersDto dto ;
        dto = findById(customerId);
        return dto.getFavoriteproduct();
    }

    public void delete(Long Id){
        findById(Id);
        customerRepo.deleteById(Id);
    }
}

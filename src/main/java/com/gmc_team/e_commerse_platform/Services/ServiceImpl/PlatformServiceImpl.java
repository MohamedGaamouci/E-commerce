package com.gmc_team.e_commerse_platform.Services.ServiceImpl;

import com.gmc_team.e_commerse_platform.Dto.AdministratorsDto;
import com.gmc_team.e_commerse_platform.Dto.DescriptionsDto;
import com.gmc_team.e_commerse_platform.Dto.PlatformDto;
import com.gmc_team.e_commerse_platform.Repository.PlatformRepo;
import com.gmc_team.e_commerse_platform.Services.PlatformService;
import com.gmc_team.e_commerse_platform.Validator.PlatformValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PlatformServiceImpl implements PlatformService {
    private final PlatformRepo platformRepo;
    private final DescriptionServiceImpl descriptionServiceImpl;
    private final AdministratorServiceImpl administratorServiceImpl;

    public PlatformServiceImpl(PlatformRepo platformRepo, DescriptionServiceImpl descriptionServiceImpl, AdministratorServiceImpl administratorServiceImpl) {
        this.platformRepo = platformRepo;
        this.descriptionServiceImpl = descriptionServiceImpl;
        this.administratorServiceImpl = administratorServiceImpl;
    }

    @Override
    public PlatformDto save(PlatformDto dto) {
        List<PlatformDto> platformDto =findAll();
        if (!platformDto.isEmpty() && dto.getId()==null){
            throw new InvalidOperationException("There is Already saved Platform", List.of("The System accept just one Platform"));
        }
        AdministratorsDto owner= administratorServiceImpl.findById(dto.getOwner().getId());
        dto.setOwner(owner);

        List<String>errors = PlatformValidator.Validate(dto);
        if (!errors.isEmpty()){
            throw new InvalidEntityException("The Platform Entity Not Valid",
                    Errorcode.PLATFORM_NOT_VALID,errors);
        }
        List<DescriptionsDto> descriptionsDtos=new ArrayList<>();
        if (dto.getDescription()!=null){
            dto.getDescription().forEach(d->{
                if (d.getId()!=null){
                    descriptionsDtos.add(descriptionServiceImpl.findById(d.getId()));
                }else{
                    descriptionsDtos.add(descriptionServiceImpl.save(d));
                }
            });
            dto.setDescription(descriptionsDtos);
        }
        List<AdministratorsDto> adminlist=new ArrayList<>();
        if (dto.getAdministratorsList()!=null){
            dto.getAdministratorsList().forEach(a->{
                if (a.getId()!=null){
                    adminlist.add(administratorServiceImpl.findById(a.getId()));
                }else{
                    adminlist.add(administratorServiceImpl.save(a));
                }
            });
            dto.setAdministratorsList(adminlist);
        }
        try {
            return PlatformDto.fromEntity(platformRepo.save(PlatformDto.toEntity(dto)));

        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public PlatformDto findById(Long Id) {
        return platformRepo.findById(Id)
                .map(PlatformDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("No Platform with the Id :"+Id,
                        Errorcode.PLATFORM_NOT_FOUND ));
    }

    @Override
    public PlatformDto AddAdminToThePlatform(Long Id) {
        AdministratorsDto administratorsDto = administratorServiceImpl.findById(Id);
        PlatformDto dto = findAll().get(0);
        List<AdministratorsDto> list = new ArrayList<>(dto.getAdministratorsList());
        list.add(administratorsDto);
        list= list.stream().filter(v-> !Objects.equals(v.getId() ,administratorsDto.getId())
                        || !Objects.equals(v.getId(),dto.getOwner().getId()))
                .collect(Collectors.toList());
        dto.setAdministratorsList(list);
        return save(dto);
    }

    @Override
    public List<PlatformDto> findAll() {
        return platformRepo.findAll()
                .stream().map(PlatformDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAdmin(Long id) {
            administratorServiceImpl.delete(id);
    }
}

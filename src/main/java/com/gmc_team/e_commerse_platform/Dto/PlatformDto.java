package com.gmc_team.e_commerse_platform.Dto;

import com.gmc_team.e_commerse_platform.models.Administrators;
import com.gmc_team.e_commerse_platform.models.Descriptions;
import com.gmc_team.e_commerse_platform.models.Platform;
import lombok.Builder;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class PlatformDto {

    private Long Id;
    private AdministratorsDto owner;
    private String brand_name;
    private List<DescriptionsDto> Description;
    private List<AdministratorsDto> administratorsList;

    public static Platform toEntity(PlatformDto dto){
        if (dto == null)return null;
        else{
            Platform platform = new Platform();

            platform.setId(dto.getId());
            platform.setOwner(AdministratorsDto.toEntity(dto.getOwner()));
            platform.setBrandname(dto.getBrand_name());
            if(dto.getDescription() !=null){
                List<Descriptions> list = new ArrayList<>();
                dto.getDescription().forEach(d->list.add(DescriptionsDto.toEntity(d)));
                platform.setDescription(list);
            }
            if(dto.getAdministratorsList() !=null){
                List<Administrators> adminList = new ArrayList<>();
                dto.getAdministratorsList().forEach(a->adminList.add(AdministratorsDto.toEntity(a)));
                platform.setAdministratorsList(adminList);
            }
            return platform;
        }
    }

    public static PlatformDto fromEntity(Platform dto){
        if (dto == null)return null;
        else{
                List<DescriptionsDto> list = new ArrayList<>();
            if(dto.getDescription() !=null){
                dto.getDescription().forEach(d->list.add(DescriptionsDto.fromEntity(d)));
            }
                List<AdministratorsDto> adminList = new ArrayList<>();
            if(dto.getAdministratorsList() !=null){
                dto.getAdministratorsList().forEach(a->adminList.add(AdministratorsDto.fromEntity(a)));
            }
            return PlatformDto.builder()
                    .Id(dto.getId())
                    .brand_name(dto.getBrandname())
                    .owner(AdministratorsDto.fromEntity(dto.getOwner()))
                    .Description(list)
                    .administratorsList(adminList)
                    .build();
        }
    }
}

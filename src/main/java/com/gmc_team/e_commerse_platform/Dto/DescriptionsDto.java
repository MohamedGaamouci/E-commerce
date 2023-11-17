package com.gmc_team.e_commerse_platform.Dto;

import com.gmc_team.e_commerse_platform.models.Descriptions;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DescriptionsDto {
    private Long Id;
    private String title;
    private String description;
    private Long online_shop;
    public static Descriptions toEntity(DescriptionsDto dto){
        if(dto == null)return null;
        else {
            Descriptions descriptions =new Descriptions();
            descriptions.setId(dto.getId());
            descriptions.setTitle(dto.getTitle().trim());
            descriptions.setDescription(dto.getDescription().trim());
            descriptions.setOnlineshop(dto.getOnline_shop());

            return descriptions;
        }
    }
    public static DescriptionsDto fromEntity(Descriptions descriptions){
        if(descriptions == null )return null;
        else{
            return DescriptionsDto.builder()
                    .Id(descriptions.getId())
                    .title(descriptions.getTitle())
                    .description((descriptions.getDescription()))
                    .online_shop(descriptions.getOnlineshop())
                    .build();
        }
    }


}

package com.gmc_team.e_commerse_platform.Dto;

import com.gmc_team.e_commerse_platform.models.Images;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ImagesDto {
    private Long Id;
    private String title;
    private String URL;
    private Long online_shop;

    public static Images toEntity(ImagesDto dto){
        if(dto == null )return null;
        else {
            Images images = new Images();
            images.setId(dto.getId());
            images.setTitle(dto.getTitle().trim());
            images.setURL(dto.getURL().trim());
            images.setOnlineshop(dto.getOnline_shop());
            return images;
        }
    }
    public static ImagesDto fromEntity(Images images){
        if(images == null)return null;
        else{
            return ImagesDto.builder()
                    .Id(images.getId())
                    .title(images.getTitle())
                    .URL(images.getURL())
                    .online_shop(images.getOnlineshop())
                    .build();
        }
    }
}

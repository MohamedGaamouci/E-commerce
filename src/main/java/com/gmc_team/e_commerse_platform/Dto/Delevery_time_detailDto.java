package com.gmc_team.e_commerse_platform.Dto;

import com.gmc_team.e_commerse_platform.models.Delevery_time_detail;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Delevery_time_detailDto {
    private Long Id;
    private String title;
    private Long time ;
    private String timeDeley ;

    public static Delevery_time_detail toEntity(Delevery_time_detailDto dto){
        if(dto == null) return null;

        Delevery_time_detail timeDetail =new Delevery_time_detail();
            timeDetail.setTitle(dto.getTitle());
            timeDetail.setId(dto.getId());
            timeDetail.setTime(dto.getTime().toString());
        return timeDetail;
    }
    public static Delevery_time_detailDto fromEntity(Delevery_time_detail dto){
        if(dto == null) return null;
        return Delevery_time_detailDto.builder()
                .Id(dto.getId())
                .title(dto.getTitle())
                .timeDeley(dto.getTime())
                .build();
    }
}

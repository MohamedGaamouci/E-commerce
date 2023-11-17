package com.gmc_team.e_commerse_platform.Dto;

import com.gmc_team.e_commerse_platform.models.Category;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class CategoryDto {
    private Long Id;
    private String Name;
    private String Description;

    private CategoryDto parent_category;
    private List<CategoryDto> childcats;
    private Long onlineshop;

    public static Category toEntity(CategoryDto dto){
        if(dto == null) return null;
        else{
            Category category = new Category();
            category.setId(dto.getId());
            category.setName(dto.getName().trim());
            category.setDescription(dto.getDescription().trim());
            category.setOnlineshop(dto.getOnlineshop());
            if(!(dto.getParent_category() == null)){
                category.setParentcategory(CategoryDto.toEntity(dto.getParent_category()));
            }
            if(dto.getChildcats()!=null){
                if(!dto.getChildcats().isEmpty()){
                    category.setChildcats(dto.getChildcats().stream()
                            .map(CategoryDto::toEntity)
                            .collect(Collectors.toList()));
                }
            }
            return category;
        }
    }

    public static CategoryDto fromEntity(Category category) {
        if(category == null)return null;
            else{
                return CategoryDto.builder()
                        .Id(category.getId())
                        .Name(category.getName())
                        .Description(category.getDescription())
                        .onlineshop(category.getOnlineshop())
                        .parent_category(CategoryDto.fromEntity(category.getParentcategory()))
                        .build();
        }
    }

}

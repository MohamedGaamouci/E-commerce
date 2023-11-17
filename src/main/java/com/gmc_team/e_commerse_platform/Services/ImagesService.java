package com.gmc_team.e_commerse_platform.Services;

import com.gmc_team.e_commerse_platform.Dto.ImagesDto;

import java.util.List;

public interface ImagesService {
    List<ImagesDto> findByTitle(String title);
    ImagesDto save(ImagesDto dto);
    ImagesDto findById(Long id);
    List<ImagesDto> findByURL(String Url);
    void delete(Long imagesId);
}

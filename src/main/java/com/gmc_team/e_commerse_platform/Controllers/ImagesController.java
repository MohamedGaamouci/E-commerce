package com.gmc_team.e_commerse_platform.Controllers;

import com.gmc_team.e_commerse_platform.Controllers.Api.ImagesApi;
import com.gmc_team.e_commerse_platform.Dto.ImagesDto;
import com.gmc_team.e_commerse_platform.Services.ServiceImpl.ImagesServiceImpl;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ImagesController implements ImagesApi {
    private final ImagesServiceImpl imagesServiceImpl;

    public ImagesController(ImagesServiceImpl imagesServiceImpl) {
        this.imagesServiceImpl = imagesServiceImpl;
    }

    @Override
    public ImagesDto findById(Long id) {
        return imagesServiceImpl.findById(id);
    }

    @Override
    public ImagesDto save(ImagesDto dto) {
        return imagesServiceImpl.save(dto);
    }

    @Override
    public List<ImagesDto> findByTitle(String title) {
        return imagesServiceImpl.findByTitle(title);
    }

    @Override
    public List<ImagesDto> findByURL(String Url) {
        return imagesServiceImpl.findByURL(Url);
    }

    @Override
    public void delete(Long Images_Id) {
        imagesServiceImpl.delete(Images_Id);
    }
}

package com.gmc_team.e_commerse_platform.Services.ServiceImpl;

import com.gmc_team.e_commerse_platform.Dto.ImagesDto;
import com.gmc_team.e_commerse_platform.Repository.ImagesRepo;
import com.gmc_team.e_commerse_platform.Services.ImagesService;
import com.gmc_team.e_commerse_platform.Validator.ImagesValidator;
import com.gmc_team.e_commerse_platform.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ImagesServiceImpl implements ImagesService {

    private final ImagesRepo imagesRepo;

    @Autowired
    public ImagesServiceImpl(ImagesRepo imagesRepo) {
        this.imagesRepo = imagesRepo;
    }

    @Override
    public List<ImagesDto> findByTitle(String title) {
        return imagesRepo.findAllByTitle(title)
                .stream().map(ImagesDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ImagesDto save(ImagesDto dto) {
        List<String> errors = ImagesValidator.Validate(dto);
        if (!errors.isEmpty()){
            throw new InvalidEntityException("Image Not Valid {}",
                    Errorcode.IMAGE_NOT_VALID_EXCEPTION ,errors);
        }

        try {
            return ImagesDto.fromEntity(imagesRepo.save(ImagesDto.toEntity(dto)));

        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage() , Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }

    @Override
    public ImagesDto findById(Long id) {
        return imagesRepo.findById(id)
                .map(ImagesDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("No Images with following Id :"+id
                        , Errorcode.Image_NOT_FOUND_EXCEPTION));
    }

    @Override
    public List<ImagesDto> findByURL(String Url) {
        return imagesRepo.findAllByURL(Url)
                .stream().map(ImagesDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long imagesId) {
        try {
            imagesRepo.deleteById(imagesId);
        }catch (DataAccessException ex){
            throw new InvalidDataBaseOperationException(ex.getMessage()  ,Errorcode.SQL_STATEMENT_FAILD_OPERATION);
        }catch (Exception e){
            throw new InvalidOperationException(e.getMessage());
        }
    }
}

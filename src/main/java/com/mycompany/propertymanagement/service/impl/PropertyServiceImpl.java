package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.converter.PropertyConverter;
import com.mycompany.propertymanagement.dto.PropertyDTO;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.entity.UserEntity;
import com.mycompany.propertymanagement.exception.BusinessException;
import com.mycompany.propertymanagement.exception.ErrorModel;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.repository.UserRepository;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private PropertyConverter propertyConverter;

    @Autowired
    private UserRepository userRepository;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {

        Optional<UserEntity> optUe = userRepository.findById(propertyDTO.getUserId());
        if(optUe.isPresent()){
            PropertyEntity pe = propertyConverter.convertDTOtoEntity(propertyDTO);
            pe.setUserEntity(optUe.get());
            pe = propertyRepository.save(pe);
            propertyDTO = propertyConverter.convertEntityToDTO(pe);
            propertyDTO.setUserId(optUe.get().getId());
            return propertyDTO;
        }
        else {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel1 = new ErrorModel();
            errorModel1.setCode("USER_ID_NOT_EXIST");
            errorModel1.setMessage("User does not exist");
            errorModelList.add(errorModel1);

            ErrorModel errorModel2 = new ErrorModel();
            errorModel2.setCode("USER_ID_NOT_EXIST222");
            errorModel2.setMessage("User does not exist222");
            errorModelList.add(errorModel2);
            throw new BusinessException(errorModelList);
        }
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> listOfProps =(List<PropertyEntity>) propertyRepository.findAll();
        List<PropertyDTO> propList = new ArrayList<>();
        for ( PropertyEntity pe: listOfProps){
            PropertyDTO dto = propertyConverter.convertEntityToDTO(pe);
            propList.add(dto);
        }
        return propList;
    }

    @Override
    public List<PropertyDTO> getAllPropertiesForUser(Long userId) {
        List<PropertyEntity> listOfProps =(List<PropertyEntity>) propertyRepository.findAllByUserEntityId(userId);
        List<PropertyDTO> propList = new ArrayList<>();
        for (PropertyEntity pe: listOfProps){
            PropertyDTO dto = propertyConverter.convertEntityToDTO(pe);
            propList.add(dto);
        }
        return propList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {

        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        if(optEn.isPresent()){
            PropertyEntity pe = optEn.get();
            pe.setTitle(propertyDTO.getTitle());
            pe.setAddress(propertyDTO.getAddress());
            pe.setPrice(propertyDTO.getPrice());
            pe.setDescription(propertyDTO.getDescription());

            propertyDTO.setId(propertyId);

            propertyRepository.save(pe);
        }
        return propertyDTO;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        if(optEn.isPresent()){
            PropertyEntity pe = optEn.get();
            pe.setDescription(propertyDTO.getDescription());
            propertyDTO.setId(propertyId);
            propertyRepository.save(pe);
        }
        return propertyDTO;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optEn = propertyRepository.findById(propertyId);
        if(optEn.isPresent()){
            PropertyEntity pe = optEn.get();
            pe.setPrice(propertyDTO.getPrice());
            propertyDTO.setId(propertyId);
            propertyRepository.save(pe);
        }
        return propertyDTO;
    }

    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId );
    }
}













package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.dto.UserDTO;
import com.mycompany.propertymanagement.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

   public UserEntity convertDTOtoEntity(UserDTO userDTO){
       UserEntity userEntity = new UserEntity();
       userEntity.setPhone(userDTO.getPhone());
       userEntity.setOwnerName(userDTO.getOwnerName());
       userEntity.setOwnerEmail(userDTO.getOwnerEmail());
       userEntity.setPassword(userDTO.getPassword());

       return userEntity;
   }

    public UserDTO convertEntityToDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setPhone(userEntity.getPhone());
        userDTO.setOwnerName(userEntity.getOwnerName());
        userDTO.setOwnerEmail(userEntity.getOwnerEmail());

        return userDTO;
    }
}









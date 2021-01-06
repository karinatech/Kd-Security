package com.cybertek.mapper;

import com.cybertek.dto.RoleDTO;
import com.cybertek.dto.UserDTO;
import com.cybertek.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UseerMapper {
    private ModelMapper modelMapper;

    public UseerMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public User convertToEntity(UserDTO dto){
        return modelMapper.map(dto,User.class);
    }
    public UserDTO convertToDTO(User user){
        return modelMapper.map(user, UserDTO.class);

    }
}

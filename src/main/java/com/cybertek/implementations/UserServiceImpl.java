package com.cybertek.implementations;

import com.cybertek.dto.UserDTO;
import com.cybertek.entity.User;
import com.cybertek.mapper.UseerMapper;
import com.cybertek.repo.UserRepo;
import com.cybertek.service.UserServicee;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServicee {

    UserRepo userRepo;
    UseerMapper useerMapper;

    public UserServiceImpl(UserRepo userRepo, UseerMapper useerMapper) {
        this.userRepo = userRepo;
        this.useerMapper = useerMapper;
    }

    @Override
    public List<UserDTO> listAllUsers() {
        List <User>list = userRepo.findAll(Sort.by("firstName"));
        //convert to DTO
        return list.stream().map(obj ->{return useerMapper.convertToDTO(obj);}).collect(Collectors.toList());
    }

    @Override
    public UserDTO findByUserName(String userNam) {
        return null;
    }

    @Override
    public void save(UserDTO dto) {
User user = useerMapper.convertToEntity(dto);
userRepo.save(user);
    }

    @Override
    public UserDTO update(UserDTO dto) {
        return null;
    }

    @Override
    public void delete(String userNam) {

    }
}
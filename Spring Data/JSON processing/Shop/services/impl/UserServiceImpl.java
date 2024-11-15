package com.example.demo.services.impl;

import com.example.demo.dtos.UserWithOneSoldProductDTO;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private Gson gson;
    private ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    @Override
    public List<String> findUsersWithSoldProduct() {
        List<String> list = this.userRepository.findUsersWithSoldProduct()
                .stream()
                .map(dt0 -> this.modelMapper.map(dt0, UserWithOneSoldProductDTO.class))
                .map(dto -> this.gson.toJson(dto))
                .toList();

        return list;
    }
}

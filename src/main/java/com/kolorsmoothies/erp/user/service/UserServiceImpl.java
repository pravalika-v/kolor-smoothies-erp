package com.kolorsmoothies.erp.user.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kolorsmoothies.erp.exception.ResourceNotFoundException;
import com.kolorsmoothies.erp.user.dto.UserRequest;
import com.kolorsmoothies.erp.user.dto.UserResponse;
import com.kolorsmoothies.erp.user.entity.User;
import com.kolorsmoothies.erp.user.mapper.UserMapper;
import com.kolorsmoothies.erp.user.repository.UserRepository;
import com.kolorsmoothies.erp.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    
    @Override
    public UserResponse createUser(UserRequest request) {

        if(userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists.");
        }

        if(request.getPhone() != null &&
                userRepository.existsByPhone(request.getPhone())) {
            throw new IllegalArgumentException("Phone number already exists.");
        }

        User user = UserMapper.toEntity(request);

        User savedUser = userRepository.save(user);

        return UserMapper.toResponse(savedUser);
    }
    
    @Override
    public UserResponse getUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found."));

        return UserMapper.toResponse(user);
    }
    
    @Override
    public List<UserResponse> getAllUsers() {

        return userRepository.findAll()

                .stream()

                .map(UserMapper::toResponse)

                .collect(Collectors.toList());

    }
    
    @Override
    public UserResponse updateUser(Long id, UserRequest request) {

        User user = userRepository.findById(id)

                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found."));

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPhone(request.getPhone());
        user.setRole(request.getRole());

        User updated = userRepository.save(user);

        return UserMapper.toResponse(updated);

    }
    
    @Override
    public void deleteUser(Long id) {

        User user = userRepository.findById(id)

                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found."));

        userRepository.delete(user);

    }
    
    

}
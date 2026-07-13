package com.kolorsmoothies.erp.user.service;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kolorsmoothies.erp.enums.UserStatus;
import com.kolorsmoothies.erp.exception.BadRequestException;
import com.kolorsmoothies.erp.exception.ResourceNotFoundException;
import com.kolorsmoothies.erp.user.dto.ChangePasswordRequest;
import com.kolorsmoothies.erp.user.dto.ResetPasswordRequest;
import com.kolorsmoothies.erp.user.dto.UpdateUserRequest;
import com.kolorsmoothies.erp.user.dto.UserRequest;
import com.kolorsmoothies.erp.user.dto.UserResponse;
import com.kolorsmoothies.erp.user.entity.User;
import com.kolorsmoothies.erp.user.mapper.UserMapper;
import com.kolorsmoothies.erp.user.repository.UserRepository;
import com.kolorsmoothies.erp.user.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse createUser(UserRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new BadRequestException("Email already exists.");
        }

        User user = userMapper.toEntity(request);

        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setStatus(UserStatus.ACTIVE);

        return userMapper.toResponse(userRepository.save(user));
    }

    @Override
    public UserResponse getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return userMapper.toResponse(user);
    }

    @Override
    public UserResponse getCurrentUser() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return userMapper.toResponse(user);
    }

    @Override
    public UserResponse updateUser(Long id, UpdateUserRequest request) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        userMapper.updateEntity(user, request);

        return userMapper.toResponse(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setStatus(UserStatus.INACTIVE);

        userRepository.save(user);
    }

    @Override
    public Page<UserResponse> getAllUsers(int page, int size) {

        return userRepository
                .findAll(PageRequest.of(page, size))
                .map(userMapper::toResponse);
    }

    @Override
    public Page<UserResponse> searchUsers(
            String keyword,
            int page,
            int size) {

        return userRepository
                .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
                        keyword,
                        keyword,
                        keyword,
                        PageRequest.of(page, size))
                .map(userMapper::toResponse);
    }

    @Override
    public void changePassword(ChangePasswordRequest request) {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (!passwordEncoder.matches(
                request.getCurrentPassword(),
                user.getPassword())) {

            throw new BadRequestException("Current password is incorrect.");
        }

        user.setPassword(
                passwordEncoder.encode(request.getNewPassword()));

        userRepository.save(user);
    }

    @Override
    public void resetPassword(Long id,
                              ResetPasswordRequest request) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setPassword(
                passwordEncoder.encode(request.getNewPassword()));

        userRepository.save(user);
    }
    
    @Override
    public void activateUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setStatus(UserStatus.ACTIVE);

        userRepository.save(user);
    }

    @Override
    public void deactivateUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setStatus(UserStatus.INACTIVE);

        userRepository.save(user);
    }

    @Override
    public void lockUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setStatus(UserStatus.LOCKED);

        userRepository.save(user);
    }

    @Override
    public void unlockUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        user.setStatus(UserStatus.ACTIVE);

        userRepository.save(user);
    }
}
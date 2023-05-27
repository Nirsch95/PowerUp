package com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.UserResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IUserHandler;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.IUserRequestMapper;
import com.pragma.powerup.usermicroservice.adapters.driving.http.mapper.IUserResponseMapper;
import com.pragma.powerup.usermicroservice.configuration.Constants;
import com.pragma.powerup.usermicroservice.domain.api.IUserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserHandlerImpl implements IUserHandler {

    private final IUserServicePort userServicePort;
    private final IUserRequestMapper userRequestMapper;
    private final IUserResponseMapper userResponseMapper;

    @Override
    public void saveOwner(UserRequestDto userRequestDto) {
        userRequestDto.setIdRole(Constants.OWNER_ROLE_ID);
        userServicePort.saveUser(userRequestMapper.toUser(userRequestDto));
    }

    @Override
    public void saveEmployee(UserRequestDto userRequestDto) {
        userRequestDto.setIdRole(Constants.EMPLOYEE_ROLE_ID);
        userServicePort.saveUser(userRequestMapper.toUser(userRequestDto));
    }

    @Override
    public void saveClient(UserRequestDto userRequestDto) {
        userRequestDto.setIdRole(Constants.CLIENT_ROLE_ID);
        userServicePort.saveUser(userRequestMapper.toUser(userRequestDto));
    }

    @Override
    public UserResponseDto getUser(Long id) {
        return userResponseMapper.toResponse(userServicePort.getUser(id));
    }
}

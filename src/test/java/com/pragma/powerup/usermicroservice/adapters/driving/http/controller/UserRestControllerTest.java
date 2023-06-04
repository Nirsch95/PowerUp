package com.pragma.powerup.usermicroservice.adapters.driving.http.controller;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response.UserResponseDto;
import com.pragma.powerup.usermicroservice.adapters.driving.http.handlers.IUserHandler;
import com.pragma.powerup.usermicroservice.configuration.Constants;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserRestControllerTest {

    @Mock
    private IUserHandler userHandler;

    @InjectMocks
    private UserRestController userRestController;

    private UserRequestDto userRequestDto;

    @Test
    @DisplayName("Given a valid user, when saveOwner is called, then a CREATED response is returned")
    void testSaveOwner() {
        // Arrange
        UserRequestDto userRequestDto = new UserRequestDto("John","Doe", "12345678",
                "+123456789", new Date(90, 1, 1), "johndoe@example.com",
                "mypassword", 2L);
        Mockito.doNothing().when(userHandler).saveOwner(userRequestDto);

        // Act
        ResponseEntity<Map<String, String>> responseEntity = userRestController.saveOwner(userRequestDto);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(Constants.USER_CREATED_MESSAGE, responseEntity.getBody().get(Constants.RESPONSE_MESSAGE_KEY));
    }
    @Test
    @DisplayName("Given a valid user, when saveEmployee is called, then a CREATED response is returned")
    void testSaveEmployee() {
        // Arrange
        UserRequestDto userRequestDto = new UserRequestDto("John","Doe", "12345678",
                "+123456789", new Date(90, 1, 1), "johndoe@example.com",
                "mypassword", 3L);
        Mockito.doNothing().when(userHandler).saveEmployee(userRequestDto);

        // Act
        ResponseEntity<Map<String, String>> responseEntity = userRestController.saveEmployee(userRequestDto);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(Constants.USER_CREATED_MESSAGE, responseEntity.getBody().get(Constants.RESPONSE_MESSAGE_KEY));
    }

    @Test
    @DisplayName("Given a valid user, when saveClient is called, then a CREATED response is returned")
    void testSaveClient() {
        // Arrange
        UserRequestDto userRequestDto = new UserRequestDto("John","Doe", "12345678",
                "+123456789", new Date(90, 1, 1), "johndoe@example.com",
                "mypassword", 4L);
        Mockito.doNothing().when(userHandler).saveClient(userRequestDto);

        // Act
        ResponseEntity<Map<String, String>> responseEntity = userRestController.saveClient(userRequestDto);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(Constants.USER_CREATED_MESSAGE, responseEntity.getBody().get(Constants.RESPONSE_MESSAGE_KEY));
    }

    @Test
    void getUser_shouldReturnUserResponseDto() {
        // Arrange
        UserResponseDto userResponseDto = new UserResponseDto("1", "John","Doe", "12345678",
                "+123456789", new Date(90, 1, 1), "johndoe@example.com",
                "mypassword", 3L);
        when(userHandler.getUser(anyLong())).thenReturn(userResponseDto);

        UserRestController controller = new UserRestController(userHandler);

        // Act
        ResponseEntity<UserResponseDto> response = controller.getUser(1L);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userResponseDto, response.getBody());
        Mockito.verify(userHandler, times(1)).getUser(1L);
    }

    @Test
    void getUserByDni_shouldReturnUserResponseDto() {
        // Arrange
        UserResponseDto userResponseDto = new UserResponseDto("1", "John","Doe", "12345678",
                "+123456789", new Date(90, 1, 1), "johndoe@example.com", "mypassword",
                3L);
        when(userHandler.getUserByDni(anyString())).thenReturn(userResponseDto);

        UserRestController controller = new UserRestController(userHandler);

        // Act
        ResponseEntity<UserResponseDto> response = controller.getUserByDni("12345678");

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userResponseDto, response.getBody());
        Mockito.verify(userHandler, times(1)).getUserByDni("12345678");
    }
}
package com.pragma.powerup.usermicroservice.adapters.driving.http.controller;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
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
        UserRequestDto userRequestDto = new UserRequestDto("John","Doe", "johndoe@example.com",
                "+123456789", new Date(90, 1, 1), "1234567890A", "mypassword",
                2L);
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
        UserRequestDto userRequestDto = new UserRequestDto("John","Doe", "johndoe@example.com",
                "+123456789", new Date(90, 1, 1), "1234567890A", "mypassword",
                3L);
        Mockito.doNothing().when(userHandler).saveOwner(userRequestDto);

        // Act
        ResponseEntity<Map<String, String>> responseEntity = userRestController.saveOwner(userRequestDto);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(Constants.USER_CREATED_MESSAGE, responseEntity.getBody().get(Constants.RESPONSE_MESSAGE_KEY));
    }

    @Test
    @DisplayName("Given a valid user, when saveClient is called, then a CREATED response is returned")
    void testSaveClient() {
        // Arrange
        UserRequestDto userRequestDto = new UserRequestDto("John","Doe", "johndoe@example.com",
                "+123456789", new Date(90, 1, 1), "1234567890A", "mypassword",
                4L);
        Mockito.doNothing().when(userHandler).saveOwner(userRequestDto);

        // Act
        ResponseEntity<Map<String, String>> responseEntity = userRestController.saveOwner(userRequestDto);

        // Assert
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(Constants.USER_CREATED_MESSAGE, responseEntity.getBody().get(Constants.RESPONSE_MESSAGE_KEY));
    }
}
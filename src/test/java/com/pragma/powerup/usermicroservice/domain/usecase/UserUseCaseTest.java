package com.pragma.powerup.usermicroservice.domain.usecase;

import com.pragma.powerup.usermicroservice.configuration.Constants;
import com.pragma.powerup.usermicroservice.domain.exceptions.RoleCanNotBeYoungerException;
import com.pragma.powerup.usermicroservice.domain.model.Role;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserUseCaseTest {
    @Mock
    private IUserPersistencePort userPersistencePort;
    private UserUseCase userUseCase;
    private Integer minimumAge;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        userUseCase = new UserUseCase(userPersistencePort);
        minimumAge = 18;
        userUseCase.minimumAge = minimumAge;
    }

    @Test
    void saveUserOwner_validOwnerUser_callsPersistencePort() {
        // Arrange
        User user = new User(1L, "John", "Doe","John@gmail.com","288383",
                new Date(90, 1, 1),"9239292","299293",
                new Role(Constants.OWNER_ROLE_ID, "ROLE_OWNER","ROLE_OWNER"));

        // Act
        userUseCase.saveUser(user);

        // Assert
        Mockito.verify(userPersistencePort).saveUser(user);
    }

    @Test
    void validateAge_validOwnerAge_callsPersistencePort() {
        // Arrange
        User user = new User(1L, "John", "Doe","John@gmail.com","288383",
                new Date(100, 1, 1),"9239292","299293",
                new Role(Constants.OWNER_ROLE_ID, "ROLE_OWNER","ROLE_OWNER"));

        // Act
        userUseCase.validateAge(user);

        // Assert
        Mockito.verify(userPersistencePort).saveUser(user);
    }

    @Test
    void validateAge_invalidOwnerAge_throwsOwnerMustBeOfLegalAge() {
        // Arrange
        User user = new User(1L, "John", "Doe","John@gmail.com","288383",
                new Date(120, 1, 1),"9239292","299293",
                new Role(Constants.OWNER_ROLE_ID, "ROLE_ADMIN","ROLE_ADMIN"));

        // Act & Assert
        assertThrows(RoleCanNotBeYoungerException.class, () -> userUseCase.validateAge(user));
    }

    @Test
    void getUser_WhenValidId_ShouldReturnUser() {
        // Arrange
        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        when(userPersistencePort.getOwner(userId)).thenReturn(user);

        // Act
        User result = userUseCase.getUser(userId);

        // Assert
        assertEquals(user, result);
    }

    @Test
    void getUserByDni_WhenValidDni_ShouldReturnUser() {
        // Arrange
        String dni = "12345678";
        User user = new User();
        user.setDniNumber(dni);
        when(userPersistencePort.getUserByDni(dni)).thenReturn(user);

        // Act
        User result = userUseCase.getUserByDni(dni);

        // Assert
        assertEquals(user, result);
    }
}
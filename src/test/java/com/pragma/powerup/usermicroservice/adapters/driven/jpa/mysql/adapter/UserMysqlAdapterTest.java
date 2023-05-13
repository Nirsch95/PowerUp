package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.MailAlreadyExistsException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.exceptions.UserAlreadyExistsException;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.mappers.IUserEntityMapper;
import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories.IUserRepository;
import com.pragma.powerup.usermicroservice.domain.model.Role;
import com.pragma.powerup.usermicroservice.domain.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.Optional;

import static org.mockito.Mockito.*;

class UserMysqlAdapterTest {

    @Mock
    private IUserRepository userRepository;

    @Mock
    private IUserEntityMapper userEntityMapper;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Spy
    @InjectMocks
    private UserMysqlAdapter userMysqlAdapter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Given a user when saveUser then save the user in the repository")
    void saveUserTest() {
        // Arrange
        User user = new User(1L,"John", "Doe", "12345678A",
                "123456789", new Date(90,1,1), "john.doe@example.com",
                "password123", new Role(1L, "ADMIN","ADMIN"));
        UserEntity userEntity = new UserEntity(1L,"John","Doe","12345678A","123456789"
                ,new Date(90,1,1),"john.doe@example.com","password123",
                new RoleEntity(1L, "ADMIN", "ADMIN"));
        when(userRepository.findByDniNumber(user.getDniNumber())).thenReturn(Optional.empty());
        when(userRepository.existsByMail(user.getMail())).thenReturn(false);
        when(userEntityMapper.toEntity(user)).thenReturn(userEntity);

        // Act
        userMysqlAdapter.saveUser(user);

        // Assert
        verify(userRepository, times(1)).save(userEntity);
    }

    @Test
    @DisplayName("Given an existing user dni number when saveUser then throw UserAlreadyExistsException")
    void saveUserWithExistingDniNumberTest() {
        // Arrange
        User user = new User(1L,"John", "Doe", "12345678A",
                "123456789", new Date(90,1,1), "john.doe@example.com",
                "password123", new Role(1L, "ADMIN","ADMIN"));
        when(userRepository.findByDniNumber(user.getDniNumber())).thenReturn(Optional.of(new UserEntity()));

        // Act & Assert
        Assertions.assertThrows(UserAlreadyExistsException.class, () -> userMysqlAdapter.saveUser(user));
    }

    @Test
    @DisplayName("Given an existing user email when saveUser then throw MailAlreadyExistsException")
    void saveUserWithExistingEmailTest() {
        // Arrange
        User user = new User(1L,"John", "Doe", "12345678A",
                "123456789", new Date(90,1,1), "john.doe@example.com",
                "password123", new Role(1L, "ADMIN","ADMIN"));
        when(userRepository.findByDniNumber(user.getDniNumber())).thenReturn(Optional.empty());
        when(userRepository.existsByMail(user.getMail())).thenReturn(true);

        // Act & Assert
        Assertions.assertThrows(MailAlreadyExistsException.class, () -> userMysqlAdapter.saveUser(user));
    }
}
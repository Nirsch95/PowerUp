package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.UserRequestDto;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserEntityTest {
    @Test
    void testGetters() {
        //Arrange
        UserEntity userEntity = new UserEntity(1L,"John","Doe","12345678A","123456789",new Date(90,1,1)
                ,"john.doe@example.com","password123",new RoleEntity(1L, "ADMIN", "ADMIN"));

        // Act & Assert
        assertEquals(1L, userEntity.getId());
        assertEquals("John", userEntity.getName());
        assertEquals("Doe", userEntity.getSurname());
        assertEquals("john.doe@example.com", userEntity.getMail());
        assertEquals("123456789", userEntity.getPhone());
        assertEquals("12345678A", userEntity.getDniNumber());
        assertEquals("password123", userEntity.getPassword());
        assertEquals(new Date(90,1,1), userEntity.getBirthdate());
        assertEquals(1L, userEntity.getRoleEntity().getId());
        assertEquals("ADMIN", userEntity.getRoleEntity().getName());
        assertEquals("ADMIN", userEntity.getRoleEntity().getDescription());
    }

    @Test
    void testSetters() {
        //Arrange
        UserEntity userEntity = new UserEntity();

        //Act
        userEntity.setId(1L);
        userEntity.setName("John");
        userEntity.setSurname("Doe");
        userEntity.setMail("john.doe@example.com");
        userEntity.setPhone("123456789");
        userEntity.setDniNumber("12345678A");
        userEntity.setPassword("password123");
        userEntity.setBirthdate(new Date(90,1,1));
        userEntity.setRoleEntity(new RoleEntity(1L, "ADMIN", "ADMIN"));

        //Assert
        assertEquals(1L, userEntity.getId());
        assertEquals("John", userEntity.getName());
        assertEquals("Doe", userEntity.getSurname());
        assertEquals("john.doe@example.com", userEntity.getMail());
        assertEquals("123456789", userEntity.getPhone());
        assertEquals("12345678A", userEntity.getDniNumber());
        assertEquals("password123", userEntity.getPassword());
        assertEquals(new Date(90,1,1), userEntity.getBirthdate());
        assertEquals(1L, userEntity.getRoleEntity().getId());
        assertEquals("ADMIN", userEntity.getRoleEntity().getName());
        assertEquals("ADMIN", userEntity.getRoleEntity().getDescription());

    }
}
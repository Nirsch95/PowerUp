package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserResponseDtoTest {
    @Test
    void testGetters() {
        UserResponseDto userResponseDto = new UserResponseDto("John", "Doe", "12345678A",
                "123456789", new Date(90,1,1), "john.doe@example.com",
                "password123", 1L);

        assertEquals("John", userResponseDto.getName());
        assertEquals("Doe", userResponseDto.getSurname());
        assertEquals("john.doe@example.com", userResponseDto.getMail());
        assertEquals("123456789", userResponseDto.getPhone());
        assertEquals("12345678A", userResponseDto.getDniNumber());
        assertEquals("password123", userResponseDto.getPassword());
        assertEquals(new Date(90,1,1), userResponseDto.getBirthdate());
        assertEquals(1L, userResponseDto.getIdRole());
    }
}
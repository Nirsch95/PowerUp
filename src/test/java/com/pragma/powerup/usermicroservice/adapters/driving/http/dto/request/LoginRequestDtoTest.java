package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class LoginRequestDtoTest {
    @Test
    void testGetters() {
        LoginRequestDto loginRequestDto = new LoginRequestDto("mail@mail.com", "1234");

        assertEquals("mail@mail.com", loginRequestDto.getMail());
        assertEquals("1234", loginRequestDto.getPassword());
    }
}
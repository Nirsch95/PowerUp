package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.response;

import com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request.LoginRequestDto;
import com.pragma.powerup.usermicroservice.domain.model.Role;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageResponseDtoTest {
    @Test
    void testGetters() {
        MessageResponseDto messageResponseDto = new MessageResponseDto("message");
        assertEquals("message", messageResponseDto.getMensaje());
    }

    @Test
    void testSetters() {
        MessageResponseDto messageResponseDto = new MessageResponseDto("");
        messageResponseDto.setMensaje("message");

        assertEquals("message", messageResponseDto.getMensaje());
    }
}
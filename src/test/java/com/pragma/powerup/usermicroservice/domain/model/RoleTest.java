package com.pragma.powerup.usermicroservice.domain.model;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class RoleTest {
    @Test
    void testGetters() {
        Role role = new Role(1L,"ADMIN", "ADMIN");

        assertEquals(1L, role.getId());
        assertEquals("ADMIN", role.getName());
        assertEquals("ADMIN", role.getDescription());
    }

    @Test
    void testSetters() {
        Role role = new Role();
        role.setId(1L);
        role.setName("ADMIN");
        role.setDescription("ADMIN");

        assertEquals(1L, role.getId());
        assertEquals("ADMIN", role.getName());
        assertEquals("ADMIN", role.getDescription());
    }
}
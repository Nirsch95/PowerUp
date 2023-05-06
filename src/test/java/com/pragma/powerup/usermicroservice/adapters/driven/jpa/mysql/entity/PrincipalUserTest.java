package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PrincipalUserTest {

    @InjectMocks
    private PrincipalUser principalUser;

    @Test
    void build_shouldReturnPrincipalUser() {
        // Arrange
        UserEntity user = new UserEntity(1L,"John","Doe","12345678A","123456789",new Date(90,1,1)
                ,"john.doe@example.com","password123",new RoleEntity(1L, "ADMIN", "ADMIN"));
        RoleEntity role = new RoleEntity(1L, "ADMIN", "ADMIN");
        List<RoleEntity> roles = Arrays.asList(role);

        // Act
        PrincipalUser principalUser = PrincipalUser.build(user, roles);

        // Assert
        assertEquals(user.getName(), principalUser.getNombre());
        assertEquals(user.getMail(), principalUser.getEmail());
        assertEquals(user.getDniNumber(), principalUser.getUsername());

        Collection<? extends GrantedAuthority> authorities = principalUser.getAuthorities();
        assertEquals(1, authorities.size());
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
        assertEquals(authority, authorities.iterator().next());

        assertEquals(user.getPassword(), principalUser.getPassword());
        assertEquals(true, principalUser.isEnabled());
        assertEquals(true, principalUser.isCredentialsNonExpired());
        assertEquals(true, principalUser.isAccountNonLocked());
        assertEquals(true, principalUser.isAccountNonExpired());
    }
}
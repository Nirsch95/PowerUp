package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.repositories;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findAllById(Long idUser);
    Optional<UserEntity> findByMail(String mail);
    Optional<UserEntity> findByDniNumber(String dniNumber);
    boolean existsByMail(String mail);
}

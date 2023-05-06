package com.pragma.powerup.usermicroservice.domain.usecase;


import com.pragma.powerup.usermicroservice.configuration.Constants;
import com.pragma.powerup.usermicroservice.domain.api.IUserServicePort;
import com.pragma.powerup.usermicroservice.domain.exceptions.RoleCanNotBeYoungerException;
import com.pragma.powerup.usermicroservice.domain.exceptions.RoleNotAllowedForCreationOwnerException;
import com.pragma.powerup.usermicroservice.domain.model.User;
import com.pragma.powerup.usermicroservice.domain.spi.IUserPersistencePort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

public class UserUseCase implements IUserServicePort {
    private final IUserPersistencePort userPersistencePort;
    @Value("${my.variables.minimumAge}")
    Integer minimumAge;
    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void saveUser(User user) {
        if (user.getRole().getId() != Constants.OWNER_ROLE_ID) {
            throw new RoleNotAllowedForCreationOwnerException();
        }
        validateAge(user);
    }

    public void validateAge(User user){
        LocalDate localDateNow = LocalDate.now();
        LocalDate birthdateConverted = user.getBirthdate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusDays(1);
        Integer age = Period.between(birthdateConverted, localDateNow).getYears();
        if (age < minimumAge) {
            throw new RoleCanNotBeYoungerException();
        }
        userPersistencePort.saveUser(user);
    }
}

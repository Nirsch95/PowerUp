package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pragma.powerup.usermicroservice.configuration.Constants;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@Getter
public class UserRequestDto {
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    private String name;
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    private String surname;
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    @Pattern(regexp = "\\d*", message = Constants.INVALID_FORMAT_MESSAGE)
    @Max(value = 20, message = Constants.INVALID_VALUE_DNI_NUMBER)
    private String dniNumber;
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    @Pattern(regexp = "^\\+?[0-9]{1,12}$", message = Constants.INVALID_FORMAT_PHONE_MESSAGE)
    private String phone;
    @NotNull
    @Past
    private Date birthdate;
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    @Email(message = Constants.INVALID_FORMAT_EMAIL_MESSAGE)
    private String mail;
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    private String password;
    @NotNull
    @Min(value = 1, message = Constants.INVALID_VALUE_ROL)
    @Max(value = 4, message = Constants.INVALID_VALUE_ROL)
    private Long idRole;
}

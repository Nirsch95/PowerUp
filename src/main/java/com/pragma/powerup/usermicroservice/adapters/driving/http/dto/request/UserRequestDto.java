package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pragma.powerup.usermicroservice.configuration.Constants;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRequestDto {
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    private String name;
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    private String surname;
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    @Pattern(regexp = "\\d*", message = Constants.INVALID_FORMAT_MESSAGE)
    @Digits(message = Constants.INVALID_VALUE_DNI_NUMBER, integer = 20, fraction = 0)
    private String dniNumber;
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    @Pattern(regexp = "^\\+?[0-9]{12}$", message = Constants.INVALID_FORMAT_PHONE_MESSAGE)
    private String phone;
    @NotNull
    @Past
    private Date birthdate;
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = Constants.INVALID_FORMAT_EMAIL_MESSAGE)
    private String mail;
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    private String password;
    @JsonIgnore
    private Long idRole;
}

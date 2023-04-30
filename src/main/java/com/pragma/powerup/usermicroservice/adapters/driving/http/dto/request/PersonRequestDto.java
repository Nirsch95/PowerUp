package com.pragma.powerup.usermicroservice.adapters.driving.http.dto.request;

import com.pragma.powerup.usermicroservice.configuration.Constants;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PersonRequestDto {
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    private String name;
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    private String surname;
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    @Email(message = Constants.INVALID_FORMAT_EMAIL_MESSAGE)
    private String mail;
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    @Pattern(regexp = "^\\+?[0-9]{1,12}$", message = Constants.INVALID_FORMAT_PHONE_MESSAGE)
    private String phone;
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    private String address;
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    private String idDniType;
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    @Pattern(regexp = "\\d*", message = Constants.INVALID_FORMAT_MESSAGE)
    private String dniNumber;
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    private String idPersonType;
    @NotEmpty(message = Constants.EMPTY_FIELD_MESSAGE)
    private String password;
}

package com.jan.magicmarket.transfer;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jan.magicmarket.config.constants.Gender;
import com.jan.magicmarket.config.constants.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDetail {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final Gender gender;
    private final String emailAddress;
    private final String IBAN;
    private final Role role;
    private final Boolean active;
}

package com.mycompany.propertymanagement.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AuthenticationException extends RuntimeException{

    private List<ErrorModel> errors;

    public AuthenticationException(List<ErrorModel> errors){this.errors = errors;}
}

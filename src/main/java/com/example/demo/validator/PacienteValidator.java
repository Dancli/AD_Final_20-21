package com.example.demo.validator;

import com.example.demo.model.PacienteModel;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PacienteValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return PacienteModel.class.isAssignableFrom(clazz);}


    @Override
    public void validate(Object target, Errors errors) {

    }
}

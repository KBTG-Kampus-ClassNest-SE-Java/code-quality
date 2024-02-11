package com.werockstar.requestvalidationtesting;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestTest {

    private static Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    @DisplayName("age should be positive")
    void ageShouldBePositive() {
        String dummyName = "WeRockStar";
        Request request = new Request(dummyName, 23);

        var violations = validator.validate(request);

        assertThat(violations).isEmpty();
    }

    @Test
    @DisplayName("name should be non-empty")
    void nameShouldNotBeEmpty() {
        int dummyAge = 23;
        Request request = new Request("WeRockStar", dummyAge);

        var violations = validator.validate(request);

        assertThat(violations).isEmpty();
    }

    @Test
    @DisplayName("both name and age invalid should return 2 violations")
    void nameAndAgeInvalid() {
        Request request = new Request("", -1);

        var violations = validator.validate(request);

        assertThat(violations).hasSize(2);
        Iterator<ConstraintViolation<Request>> iterator = violations.iterator();
        assertThat(iterator.next().getMessage()).isEqualTo("Age should be positive");
        assertThat(iterator.next().getMessage()).isEqualTo("The name must be defined.");
    }
}

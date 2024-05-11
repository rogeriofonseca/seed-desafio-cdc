package br.com.virtualbooks.tabernabooks.shared;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = ExistsIdValidator.class)
@Target({FIELD})
@Retention(RUNTIME)
public @interface ExistsId {
    String message() default ("ID Não registrado");
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    Class<?> domainClass();

    String fieldName();

}

package br.com.virtualbooks.tabernabooks.shared;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueValueValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueValue {
    String message() default ("Erro de duplicidade");
//    String message() default ("{br.com.virtualbooks.tabernabooks.uniquevalue}");
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    Class<?> domainClass();

    String fieldName();
}

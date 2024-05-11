package br.com.virtualbooks.tabernabooks.shared;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.Assert;

import java.util.List;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Object> {
    private String domainAttribute;
    private Class<?> klass;
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(ExistsId params) {
        ConstraintValidator.super.initialize(params);
        domainAttribute = params.fieldName();
        klass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        if(value == null) {
            return true;
        }

        Query query = manager.createQuery("select 1 from "+klass.getName()+" where "+domainAttribute+"=:value");
        query.setParameter("value", value);

        List<?> list = query.getResultList();

        Assert.state(list.isEmpty(), "Registro "+klass.getName()+" não cadastrado.");

        return !list.isEmpty();
    }
}

package br.com.virtualbooks.tabernabooks.shared;

import br.com.virtualbooks.tabernabooks.shared.exceptions.TabernaException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

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
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) throws TabernaException {
        if(value == null) {
            return true;
        }

        Query query = manager.createQuery("select 1 from "+klass.getSimpleName()+" where "+domainAttribute+"=:value");
        query.setParameter("value", value);

        List<?> list = query.getResultList();

        if (list.isEmpty()) {
            String userMessage = "Registro " + klass.getSimpleName() + " não cadastrado";
            String technicalMessage = "Registro " + value + " " + klass.getName() + " não cadastrado.";
            throw new TabernaException("-1", userMessage, technicalMessage);
        }

        return true;
    }
}

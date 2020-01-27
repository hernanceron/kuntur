package com.everis.kuntur.core.validation.integrity;

import com.everis.kuntur.core.model.web.KunturHttpModel;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class KunturGenericHttpModelValidator<T> {

    private KunturHttpModel<T> httpModel;

    /**
     * Constructor for KunturGenericHttpModelValidator class
     * @param httpModel This represents the model to validate with this
     */
    public KunturGenericHttpModelValidator(KunturHttpModel httpModel) {
        this.httpModel = httpModel;
    }

    private Set<ConstraintViolation<T>> recollectViolations(T model) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> result = validator.validate(model);
        this.httpModel.setValid(result.isEmpty());
        return result;
    }
}

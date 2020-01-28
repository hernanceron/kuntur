package com.pacifico.kuntur.core.model.web;

import com.pacifico.kuntur.core.exception.KunturHttpModelValidationException;

public abstract class KunturHttpModel<T> {

    private Boolean valid = false;

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Boolean isValid() {
        return this.valid;
    }

    public abstract Boolean validate(T model) throws KunturHttpModelValidationException;

    public abstract String buildLogRepresentation(T model);

    public abstract String buildViolationsRepresentation(T model);
}

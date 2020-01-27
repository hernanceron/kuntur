package com.everis.kuntur.core.format;

import javax.validation.ConstraintViolation;
import java.util.Set;

public interface KunturViolationFormatter <T> {

    String formatViolations(Set<ConstraintViolation<T>> model);
}

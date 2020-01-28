package com.pacifico.kuntur.core.validation.business;

import java.util.Optional;
import java.util.function.Predicate;

public class KunturBusinessValidation<T> {

    /**
     * Predicate to test against a <T> type
     */
    private Predicate<T> predicate;

    /**
     * Attribute to store the validity of an object of T type after applying a predicate
     */
    private Optional<Boolean> valid;

    /**
     * Attribute to store the reason of failure of a given object of T type
     */
    private Optional<String> failReason;

    /**
     * Constructor for Validation class
     * @param predicate Predicate of base type T for predicate attribute
     * @param failReason Optional String for failReason attribute
     */
    public KunturBusinessValidation(Predicate<T> predicate, Optional<String> failReason) {
        this.predicate = predicate;
        this.failReason = failReason;
        this.valid = Optional.empty();
    }

    /**
     * This method verify the validity of an object of type T given a predicate T -> Boolean
     * @param target Object to apply the validation
     * @return Validation object with the predicate tested
     */
    public KunturBusinessValidation<T> test(T target) {
        this.valid = Optional.of(predicate.test(target));
        return this;
    }

    /**
     * Override of the toString() method for Validation class
     * @return String representation of the Validation class
     */
    public String toString() {
        Optional<Boolean> auxValid = this.valid;
        Optional<String> auxFailReason = this.failReason;

        String output = "valid: %s, failReason: %s%n";

        if(!auxValid.isPresent()) {
            return String.format(output, "In order to get the valid value, you have to run the test method first",
                    auxFailReason.get());
        }

        return String.format(output, auxValid.get(), auxFailReason);
    }

    public Predicate<T> getPredicate() {
        return predicate;
    }

    public void setPredicate(Predicate<T> predicate) {
        this.predicate = predicate;
    }

    public Optional<Boolean> isValid() {
        return valid;
    }

    public void setValid(Optional<Boolean> valid) {
        this.valid = valid;
    }

    public Optional<String> getFailReason() {
        return failReason;
    }

    public void setFailReason(Optional<String> failReason) {
        this.failReason = failReason;
    }
}

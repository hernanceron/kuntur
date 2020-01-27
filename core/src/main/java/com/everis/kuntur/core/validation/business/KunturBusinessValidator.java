package com.everis.kuntur.core.validation.business;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KunturBusinessValidator<T> {

    private List<KunturBusinessValidation<T>> validationList;

    private Optional<Boolean> isValidTarget;

    /**
     * Constructor for Validator class
     * @param validationList List of Validations
     */
    public KunturBusinessValidator(List<KunturBusinessValidation<T>> validationList) {
        this.validationList = validationList;
        this.isValidTarget = Optional.empty();
    }

    /**
     * Private method for a the detailed validation process
     * @param target Object of type T to be evaluated in the process
     * @return A list of Validation that uses as base object the T type provided in the class
     */
    private List<KunturBusinessValidation<T>> detailedValidationProcess(T target) {
        Stream<KunturBusinessValidation<T>> partialResult = validationList.stream().map(x -> x.test(target));
        return partialResult.collect(Collectors.toList());
    }

    /**
     * This method is the central of the Validator class. This method run the test method over the list of validations
     * and returns the value of the conjunction of all the validations
     * @param target Object of type T to be evaluated
     * @return Boolean value that represents the successful or failing status of the list of validations
     */
    public Boolean validate(T target) {
        if(this.isValidTarget.isPresent()) {
            return this.isValidTarget.get();
        } else {
            this.validationList = detailedValidationProcess(target);
        }

        return validationList.stream().allMatch(x -> x.isValid().get());
    }
}

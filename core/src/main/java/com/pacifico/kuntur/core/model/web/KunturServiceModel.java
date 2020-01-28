package com.pacifico.kuntur.core.model.web;

import com.pacifico.kuntur.core.validation.business.KunturBusinessValidation;

import java.util.List;

/**
 * Class that expose the contract for the service's classes that belongs to Kuntur project
 * @param <S> Request to support the service
 * @param <T> Response to obtain after the the service consumption
 */
public interface KunturServiceModel <S, T> {

    /**
     * Transformation required to prepare the request for the service call
     * @param request Request obtained from the controller layer
     * @return
     */
    S prepareRequest(S request);

    /**
     * This method run the required validations on the request
     * @param validationList List of validations to be applied on the request object
     * @return
     */
    Boolean applyPreValidation(List<KunturBusinessValidation<S>> validationList);

    /**
     * Method useful to validate the response obtained after the service call
     * @param validationList
     * @return
     */
    Boolean applyPostValidation(List<KunturBusinessValidation<T>> validationList);
}

package com.pacifico.kuntur.core.adapter;

import java.util.function.Function;

/**
 * Class to support the transformation over the entitied received
 * @param <S> Represents the first level of the identity to be transformed
 * @param <T> Represents the second level of the identity to be transformed
 * @param <U> Represents the thirst level of the identity to be transformed
 */
public class GenericAdapter <S, T, U> {

    private Function<S, T> firstDegreeTransformation;
    private Function<T, U> secondDegreeTransformation;

    /**
     * Constructor for GenericAdapter class
     * @param firstDegreeTransformation function to be applied in the first step og the transformation flow
     * @param secondDegreeTransformation function to be applied in the second step og the transformation flow
     */
    public GenericAdapter(Function<S, T> firstDegreeTransformation, Function<T, U> secondDegreeTransformation) {
        this.firstDegreeTransformation = firstDegreeTransformation;
        this.secondDegreeTransformation = secondDegreeTransformation;
    }

    /**
     * This method apply the both function in the logic order expected for the general flow of a service
     * @param input Input is a generic type S to be used as an initial type of the transformation flow
     * @return Generic type U that represents the ending phase of the transformation flow
     */
    public U apply(S input) {
        return this.secondDegreeTransformation.compose(this.firstDegreeTransformation).apply(input);
    }
}
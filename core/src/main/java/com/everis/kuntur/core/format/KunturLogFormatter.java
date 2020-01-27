package com.everis.kuntur.core.format;

/**
 * This is used to format information to be logged into our log component
 * @param <T> Type to be formatted
 */
public abstract class KunturLogFormatter<T> {

    /**
     * This is the default method that format the target logModel
     * @param logModel Model to be formatted
     * @return
     */
    public String defaultLogFormat(T logModel) {
        return null;
    }

    /**
     * Method to extend our default method. Remember that we need to think about the correct representation in our logs,
     * so this method is pretty important to implement. Depending on the stack used to log our information in different
     * ways
     * @param logModel Model to be formatted
     * @return
     */
    abstract String customizedLogFormat(T logModel);
}

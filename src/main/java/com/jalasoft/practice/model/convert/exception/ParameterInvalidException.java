/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 *
 */

package com.jalasoft.practice.model.convert.exception;

/**
 * @version 1.1
 * @autor Magdalena
 */
public class ParameterInvalidException extends Exception {

    private static final String GENERAL_MESSAGE = "Invalid Parameter.";
    private static final String EXTENSION_MESSAGE = "Invalid Extensions =%s, Please tried with =%s";
    public ParameterInvalidException() {
        super(GENERAL_MESSAGE);
    }

    public ParameterInvalidException(String currentMessage) {
        super(currentMessage);
    }

    public ParameterInvalidException(Throwable ex) {
        super(GENERAL_MESSAGE, ex);
    }

    public ParameterInvalidException(String extension, String exSupported) {
        super(String.format(EXTENSION_MESSAGE, extension, exSupported));
    }
}

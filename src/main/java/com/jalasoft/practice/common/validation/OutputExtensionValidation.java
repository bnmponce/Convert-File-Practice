/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 *
 */

package com.jalasoft.practice.common.validation;

import com.jalasoft.practice.common.constant.ErrorMessageConstant;
import com.jalasoft.practice.common.exception.InvalidDataException;

import java.util.Arrays;
import java.util.List;

/**
 * @version 1.1
 * @autor Magdalena
 */
public class OutputExtensionValidation implements IValidatorStrategy {
    private String extension;

    public OutputExtensionValidation(String extension){
        this.extension = extension;
    }

    @Override
    public void validate() throws InvalidDataException {
        if(!this.extension.equals("pdf")) {
            throw new InvalidDataException (ErrorMessageConstant.INVALID_EXTENSION_OF_OUTPUT_FILE);
        }

    }
}
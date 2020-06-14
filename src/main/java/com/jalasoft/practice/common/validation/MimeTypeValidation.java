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
public class MimeTypeValidation implements IValidatorStrategy {
    private String mimeType;
    private final static List<String> MIME_TYPE_LIST = Arrays.asList(
            "application/msword",
            "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
            "application/vnd.ms-word.document.macroEnabled.12",
            "text/plain"
    );
    public MimeTypeValidation(String mimeType){
        this.mimeType = mimeType;
    }

    @Override
    public void validate() throws InvalidDataException {
        if(!MIME_TYPE_LIST.contains(this.mimeType)) {
            throw new InvalidDataException (ErrorMessageConstant.MIME_TYPE_ERROR_MESSAGE);
        }

    }
}

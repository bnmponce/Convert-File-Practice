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

import java.io.File;

/**
 * @version 1.1
 * @autor Magdalena
 */
public class FileValidation implements IValidatorStrategy{
    private File file;

    public FileValidation(File file) {
        this.file=file;
    }

    @Override
    public void validate() throws InvalidDataException {
        if(this.file == null || !this.file.isFile()|| this.file.isHidden()){
            throw new InvalidDataException(ErrorMessageConstant.FILE_ERROR_MESSAGE);
        }

    }
}
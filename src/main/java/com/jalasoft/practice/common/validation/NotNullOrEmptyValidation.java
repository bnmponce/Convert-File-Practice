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

/**
 * @version 1.1
 * @autor Magdalena
 */
public class NotNullOrEmptyValidation implements IValidatorStrategy{
    private String field;
    private String value;

    public NotNullOrEmptyValidation(String field, String value){
        this.field = field;
        this.value = value;
    }
    @Override
    public void validate() throws InvalidDataException{
        if(this.value==null || this.value.trim().isEmpty()){
            throw new InvalidDataException(
                    String.format(ErrorMessageConstant.NOT_NULL_OR_EMPTY_MESSAGE, this.field));
        }

    }

}

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
public class ConvertException extends Exception {

    private static  final String MESSAGE = "Error convert file to pdf";

    public ConvertException(String currentMessage, Throwable ex) {
        super(currentMessage, ex);
    }

    public ConvertException(Throwable ex) {
        super(MESSAGE, ex);
    }

    public ConvertException(String currentMessage){ super(currentMessage);}
}

/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 *
 */

package com.jalasoft.practice.controller.request;

import com.jalasoft.practice.common.exception.InvalidDataException;
import org.springframework.web.multipart.MultipartFile;

/**
 * @version 1.1
 * @autor Magdalena
 */
public abstract class RequestParameter {
    protected MultipartFile file;

    public RequestParameter(MultipartFile file){
        this.file = file;
    }

    public MultipartFile getFile() {
        return file;
    }

    public abstract void validate() throws InvalidDataException;
}

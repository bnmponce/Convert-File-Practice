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
import com.jalasoft.practice.common.validation.IValidatorStrategy;
import com.jalasoft.practice.common.validation.MimeTypeValidation;
import com.jalasoft.practice.common.validation.MultipartValidation;
import com.jalasoft.practice.common.validation.NotNullOrEmptyValidation;
import com.jalasoft.practice.common.validation.ValidationContext;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

/**
 * @version 1.1
 * @autor Magdalena
 */
public class RequestConvertParameter extends RequestParameter {

    public RequestConvertParameter(MultipartFile file){
        super(file);
    }

    public void validate() throws InvalidDataException {
        List<IValidatorStrategy> strategyList = Arrays.asList(
                new NotNullOrEmptyValidation("file", this.file.getOriginalFilename()),
                new MultipartValidation(this.file),
                new MimeTypeValidation(this.file.getContentType())
        );
        ValidationContext context = new ValidationContext(strategyList);
        context.validate();
    }

}

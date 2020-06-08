/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 *
 */

package com.jalasoft.convert.model.convert;

import com.documents4j.api.DocumentType;
import com.documents4j.api.IConverter;
import com.documents4j.job.LocalConverter;
import com.jalasoft.convert.model.convert.exception.ConvertException;
import com.jalasoft.convert.model.convert.exception.ParameterInvalidException;
import com.jalasoft.convert.model.convert.parameter.ConvertParam;
import com.jalasoft.convert.model.result.Result;


/**
 * @version 1.1
 * @autor Magdalena
 */
public class ConvertFile {

    public Result convertFile(ConvertParam param) throws ParameterInvalidException, ConvertException {
        IConverter converter = LocalConverter.builder().build();
        param.validateParam();

        try {
            converter.convert(param.getInputStream()).as(DocumentType.DOCX).
                    to(param.getOutputStream()).as(DocumentType.PDF).execute();
            param.getOutputStream().close();
            return new Result("Success");
        } catch (Exception e) {
            throw new ConvertException(e);
        }
    }
}

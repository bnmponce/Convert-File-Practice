/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 *
 */

package com.jalasoft.practice.model.convert;

import com.documents4j.api.DocumentType;
import com.documents4j.api.IConverter;
import com.documents4j.job.LocalConverter;
import com.jalasoft.practice.model.convert.exception.ConvertException;
import com.jalasoft.practice.model.convert.exception.ParameterInvalidException;
import com.jalasoft.practice.model.convert.parameter.ConvertParam;
import com.jalasoft.practice.model.result.Result;


/**
 * @version 1.1
 * @autor Magdalena
 */
public class ConvertFile implements IConvert {

    @Override
    public Result convert(ConvertParam param) throws ParameterInvalidException, ConvertException {
        param.validateParam();

        try {
            IConverter converter = LocalConverter.builder().build();
            converter.convert(param.getInputStream()).as(DocumentType.DOCX).
                    to(param.getOutputStream()).as(DocumentType.PDF).execute();
            param.getOutputStream().close();
            return new Result("File converted successfully");
        } catch (Exception e) {
            throw new ConvertException(e);
        }
    }
}

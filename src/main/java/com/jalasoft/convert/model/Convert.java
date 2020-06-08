/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 *
 */

package com.jalasoft.convert.model;

import com.documents4j.api.DocumentType;
import com.documents4j.api.IConverter;
import com.documents4j.job.LocalConverter;
import com.jalasoft.convert.model.exception.ConvertException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @version 1.1
 * @autor Magdalena
 */
public class Convert {

    public void convertFile(InputStream docxInputStream, OutputStream outputStream) throws ConvertException {
        IConverter converter = LocalConverter.builder().build();

        try {
            converter.convert(docxInputStream).as(DocumentType.DOCX).to(outputStream).as(DocumentType.PDF).execute();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

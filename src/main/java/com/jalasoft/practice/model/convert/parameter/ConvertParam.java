/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 *
 */

package com.jalasoft.practice.model.convert.parameter;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @version 1.1
 * @autor Magdalena
 */
public class ConvertParam extends Parameter {
    private InputStream inputStream ;
    private OutputStream outputStream;

    public ConvertParam(File file, InputStream inputStream , OutputStream outputStream) {
        super(file);
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

}

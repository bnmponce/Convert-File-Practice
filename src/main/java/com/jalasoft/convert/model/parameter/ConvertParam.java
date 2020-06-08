/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 *
 */

package com.jalasoft.convert.model.parameter;

import com.jalasoft.convert.model.exception.ParameterInvalidException;

import java.io.File;

/**
 * @version 1.1
 * @autor Magdalena
 */
public class ConvertParam extends Parameter {
    private String extension;
    private String testData;

    public ConvertParam(File file, String extension, String testData) {
        super(file);
        this.extension = extension;
        this.testData = testData;
    }

    public String getTestData() {
        return testData;
    }

    public void setTestData(String testData) {
        this.testData = testData;
    }

    public String getExtension() {
        return extension;
    }

    public void setLang(String extension) {
        this.extension = extension;
    }

    @Override
    public void validateParam() throws Exception {
        super.validateParam();
        if (extension.trim().isEmpty()) {
            throw new ParameterInvalidException();
        }
        if(!"docx".equals(extension)) {
            throw new ParameterInvalidException(extension, ".pdf");
        }
    }
}

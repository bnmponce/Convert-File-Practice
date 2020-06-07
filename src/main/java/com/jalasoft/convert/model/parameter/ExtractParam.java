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

import java.io.File;

/**
 * @version 1.1
 * @autor Magdalena
 */
public class ExtractParam extends Parameter {
    private String lang;
    private String testData;

    public ExtractParam(File file, String lang, String testData) {
        super(file);
        this.lang = lang;
        this.testData = testData;
    }

    public String getTestData() {
        return testData;
    }

    public void setTestData(String testData) {
        this.testData = testData;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public void validateParam() throws Exception {
        super.validateParam();
        if (lang.trim().isEmpty()) {
            throw new Exception("lan is empty");
        }
    }
}

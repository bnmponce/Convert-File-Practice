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
public class Parameter {
    File inputFile;

    public Parameter(File inputFile) {
        this.inputFile = inputFile;
    }

    public File getInputFile() {
        return inputFile;
    }

    public void validateParam() throws Exception {
        if (inputFile.isHidden()) {
            throw new Exception("Error is hidden");
        }
        if (!inputFile.isFile()) {
            throw new Exception("Error is not File");
        }
    }
}

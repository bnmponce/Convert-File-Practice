/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 *
 */

package com.jalasoft.convert.controller.utils;

import org.apache.commons.io.FilenameUtils;

import java.io.File;

/**
 * @version 1.1
 * @autor Magdalena
 */
public class FileExtension {
    public String getFileExtension(File file) {
        return FilenameUtils.getExtension(file.getAbsolutePath());
    }
}

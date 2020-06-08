/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 *
 */

package com.jalasoft.convert.controller.service;

import com.jalasoft.convert.controller.component.Properties;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @version 1.1
 * @autor Magdalena
 */
@Service
public class FileService {

    @Autowired
    private Properties properties;

    public File store(MultipartFile inputFile) throws Exception {
        String outputFileName = FilenameUtils.removeExtension(
                inputFile.getOriginalFilename()) + ".pdf";
        String uploadFolder = properties.getUploadFolder();
        Files.createDirectories(Paths.get(uploadFolder));
        File outputFile = new File(uploadFolder + outputFileName);
        return outputFile;
    }
}

/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 *
 */

package com.jalasoft.practice.controller.service;

import com.jalasoft.practice.common.exception.InvalidDataException;
import com.jalasoft.practice.controller.component.Properties;
import com.jalasoft.practice.controller.constant.ErrorConstant;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @version 1.1
 * @autor Magdalena
 */
@Service
public class StoreOutputFileService implements IStoreFile {

    @Autowired
    private Properties properties;

    @Override
    public File store(MultipartFile inputFile) throws InvalidDataException {

        String outputFileName = this.getFilePath(FilenameUtils.removeExtension(
                inputFile.getOriginalFilename()) + ".pdf");
        File outputFile = new File(outputFileName);
        return outputFile;

    }

    @Override
    public String getFilePath(String fileName) throws InvalidDataException {
        try {
            String folder = properties.getUploadFolder();
            Files.createDirectories(Paths.get(folder));
            return folder + fileName;
        } catch (IOException ex) {
            throw new InvalidDataException(ErrorConstant.FILE_ERROR, ex);
        }
    }

    public String getDownloadLink(File file) {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/v1/download/")
                .path(file.getName())
                .toUriString();
    }
}

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
import com.jalasoft.practice.controller.utils.CastMultipartToFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @version 1.1
 * @autor Magdalena
 */
@Service
public class StoreInputFileService implements IStoreFile {
    CastMultipartToFile convertToFile = new CastMultipartToFile();
    @Autowired
    private Properties properties;

    @Override
    public File store(MultipartFile file) throws InvalidDataException {
        try {
            Path path = this.getFilePath(file.getOriginalFilename());

            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            return new File(path.toString());
        } catch (IOException ex) {
            throw new InvalidDataException(ErrorConstant.FILE_ERROR, ex);
        }
    }

    @Override
    public Path getFilePath(String fileName) throws InvalidDataException {
        try {
            String folder = properties.getInputFolder();
            Files.createDirectories(Paths.get(folder));
            return Paths.get(folder + fileName);
        } catch (IOException ex) {
            throw new InvalidDataException(ErrorConstant.FILE_ERROR, ex);
        }
    }
}

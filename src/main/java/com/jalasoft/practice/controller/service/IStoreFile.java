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

import com.jalasoft.practice.controller.exception.FileException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


public interface IStoreFile<T> {
    File store(MultipartFile inputFile) throws FileException;
    T getFilePath(String fileName) throws FileException;
}

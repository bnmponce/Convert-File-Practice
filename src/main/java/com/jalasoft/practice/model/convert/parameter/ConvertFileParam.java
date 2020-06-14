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

import com.jalasoft.practice.common.exception.InvalidDataException;
import com.jalasoft.practice.common.validation.FileValidation;
import com.jalasoft.practice.common.validation.IValidatorStrategy;
import com.jalasoft.practice.common.validation.InputFileExtensionValidation;
import com.jalasoft.practice.common.validation.NotNullOrEmptyValidation;
import com.jalasoft.practice.common.validation.OutputExtensionValidation;
import com.jalasoft.practice.common.validation.ValidationContext;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.1
 * @autor Magdalena
 */
public class ConvertFileParam {
    File inputFile;
    File outputFile;

    public ConvertFileParam(File inputFile, File outputFile){
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    public File getInputFile(){
        return this.inputFile;
    }

    public File getOutputFile() {
        return outputFile;
    }

    public void validateParam() throws InvalidDataException {
        List<IValidatorStrategy> strategyList = Arrays.asList(
                new NotNullOrEmptyValidation("file", this.inputFile.getName()),
                new FileValidation(this.inputFile),
                new InputFileExtensionValidation(this.getFileExtension(inputFile)),
                new OutputExtensionValidation(this.getFileExtension(outputFile))
        );
        ValidationContext context = new ValidationContext(strategyList);
        context.validate();
    }
       /* if (!inputFile.exists()) {
            throw new ParameterInvalidException("File is not exist");
        }
        if (inputFile.isHidden()) {
            throw new ParameterInvalidException();
        }
        if (!inputFile.isFile()) {
            throw new ParameterInvalidException();
        }

        if(this.getFileExtension(inputFile).equals("xlsx")) {
            throw new ParameterInvalidException(this.getFileExtension(inputFile), ".docx");
        }
        if(this.getFileExtension(inputFile).equals("exe")) {
            throw new ParameterInvalidException(this.getFileExtension(inputFile), ".docx");
        }

        if (!this.getFileExtension(outputFile).equals("pdf")) {
            throw new ParameterInvalidException("Output File was created with wrong extension "
                    + this.getFileExtension(outputFile));
        }

    }*/

   /* public String getInputFileExtension() {
        return this.getFileExtension(inputFile);
    }*/
    private String getFileExtension(File file) {
        return FilenameUtils.getExtension(file.getAbsolutePath());
    }
}


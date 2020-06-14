/*
 *  Copyright (c) 2020 Jalasoft.
 *
 *  This software is the confidential and proprietary information of Jalasoft.
 *  ("Confidential Information"). You shall not disclose such Confidential
 *  Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 *
 */

package com.jalasoft.practice.model.convert;

import com.jalasoft.practice.common.exception.InvalidDataException;
import com.jalasoft.practice.model.convert.exception.ConvertException;
import com.jalasoft.practice.model.convert.parameter.ConvertFileParam;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class ConvertFileTest {

    private final static String PATH = "src/test/resources/convertFiles/";

    @Test
    public void convertWordFile() throws InvalidDataException, ConvertException {
        File input = new File(PATH + "El-gigante.docx");
        File output = new File(PATH + "El-gigante.pdf");
        ConvertFileParam param = new ConvertFileParam(input, output);
        ConvertFile convertFile = new ConvertFile();
        assertEquals("File converted successfully", convertFile.convert(param).getResult());
    }

    @Test(expected = InvalidDataException.class)
    public void convertExcelFile() throws InvalidDataException, ConvertException {
        File input = new File(PATH + "test.xlsx");
        File output = new File(PATH + "test.pdf");
        ConvertFileParam param = new ConvertFileParam(input, output);
        ConvertFile convertFile = new ConvertFile();
        convertFile.convert(param);
    }

    @Test(expected = InvalidDataException.class)
    public void convertNotExistingFile() throws InvalidDataException, ConvertException {
        File input = new File(PATH + "test1.doc1");
        File output = new File(PATH + "test.pdf");
        ConvertFileParam param = new ConvertFileParam(input, output);
        ConvertFile convertFile = new ConvertFile();
        convertFile.convert(param);
    }

    @Test (expected = InvalidDataException.class)
    public void convertInvalidFile() throws InvalidDataException, ConvertException {
        File input = new File(PATH + "Screenpresso.exe");
        File output = new File(PATH + "test.pdf");
        ConvertFileParam param = new ConvertFileParam(input, output);
        ConvertFile convertFile = new ConvertFile();
        convertFile.convert(param);
    }

    @Test(expected = InvalidDataException.class)
    public void convertFileInvalidParam() throws InvalidDataException, ConvertException {
        ConvertFile convertFile = new ConvertFile();
        convertFile.convert(null);
    }

}
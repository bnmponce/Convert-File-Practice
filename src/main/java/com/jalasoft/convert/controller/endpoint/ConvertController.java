package com.jalasoft.convert.controller.endpoint;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import com.documents4j.api.DocumentType;
import com.documents4j.api.IConverter;
import com.documents4j.job.LocalConverter;

import org.apache.commons.io.FilenameUtils;

@RestController
@RequestMapping("/convert")
public class ConvertController {
    private static String uploadFolder = "D://dev-fundamentals-II//uploadFiles//";
    //FileOutputStream fileOutputStream = new FileOutputStream(source);

    @PostMapping
    public String sayHello(@RequestParam(value="name") String name,
                           @RequestParam(value="lastName") String lname,
                           @RequestParam("file") MultipartFile inputFile) {
        if(inputFile.isEmpty()) {
            return "Please select a FIle and try again";
        }
        try {

            InputStream docxInputStream = new FileInputStream(convertMultiPartToFile(inputFile));
            String outputFileName = FilenameUtils.removeExtension(inputFile.getOriginalFilename()) + ".pdf";
            File outputFile = new File (uploadFolder + outputFileName);
            OutputStream outputStream = new FileOutputStream(outputFile);
            IConverter converter = LocalConverter.builder().build();
            converter.convert(docxInputStream).as(DocumentType.DOCX).to(outputStream).as(DocumentType.PDF).execute();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Hello " + name + " " + lname + "file converted successfully to PDF";
    }
    private File convertMultiPartToFile(MultipartFile file ) throws IOException
    {
        File convFile = new File( file.getOriginalFilename() );
        FileOutputStream fos = new FileOutputStream( convFile );
        fos.write( file.getBytes() );
        fos.close();
        return convFile;
    }
}

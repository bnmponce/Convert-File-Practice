package com.jalasoft.convert.controller.endpoint;

import com.jalasoft.convert.model.Convert;
import com.jalasoft.convert.model.cast.CastMultipartToFile;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.io.File;


@RestController
@RequestMapping("/v1")
public class ConvertController {

    @PostMapping("/convert")
    public String convertFile(@RequestParam(value="lang") String lang,
                           @RequestParam("file") MultipartFile inputFile) {

        Convert convert = new Convert();
        String uploadFolder = "filesContainer/";
        CastMultipartToFile convertToFile = new CastMultipartToFile();
        String outputFileName = FilenameUtils.removeExtension(inputFile.getOriginalFilename()) + ".pdf";

        try {
            Files.createDirectories(Paths.get(uploadFolder));
            File file = convertToFile.convertMultiPartToFile(inputFile);
            File outputFile = new File (uploadFolder + outputFileName);
            InputStream docxInputStream = new FileInputStream(file);
            OutputStream outputStream = new FileOutputStream(outputFile);

            convert.convertFile(docxInputStream, outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Hello! Your " + lang + " file was converted successfully to PDF";
    }

}

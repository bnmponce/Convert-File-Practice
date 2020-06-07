package com.jalasoft.convert.controller.endpoint;

import com.jalasoft.convert.controller.component.Properties;
import com.jalasoft.convert.controller.response.Response;
import com.jalasoft.convert.model.Convert;
import com.jalasoft.convert.model.cast.CastMultipartToFile;
import com.jalasoft.convert.model.parameter.ExtractParam;

import com.jalasoft.convert.model.parameter.ExtractParam;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private Properties properties;

    @PostMapping("/convert")
    public Response convertFile(@RequestParam(value="lang") String lang,
                                @RequestParam("file") MultipartFile inputFile) {


        Convert convert = new Convert();
        CastMultipartToFile convertToFile = new CastMultipartToFile();
        String outputFileName = FilenameUtils.removeExtension(inputFile.getOriginalFilename()) + ".pdf";
        String fileInput;


        try {
            String uploadFolder = properties.getUploadFolder();
            Files.createDirectories(Paths.get(uploadFolder));
            fileInput = uploadFolder + inputFile.getOriginalFilename();
            File file = convertToFile.convertMultiPartToFile(inputFile);

            ExtractParam param = new ExtractParam(file, lang,"test data");
            param.validateParam();
            
            File outputFile = new File (uploadFolder + outputFileName);
            InputStream docxInputStream = new FileInputStream(file);
            OutputStream outputStream = new FileOutputStream(outputFile);
            convert.convertFile(docxInputStream, outputStream);

            String response = lang + " file was converted successfully to PDF";
            return new Response(response, "", "200");

        } catch (Exception e) {
            return new Response("", e.getMessage(), "400");
        }

    }

}

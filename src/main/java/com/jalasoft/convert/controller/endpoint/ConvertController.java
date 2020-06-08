package com.jalasoft.convert.controller.endpoint;

import com.jalasoft.convert.controller.response.Response;
import com.jalasoft.convert.controller.service.FileService;
import com.jalasoft.convert.controller.utils.CastMultipartToFile;
import com.jalasoft.convert.model.convert.ConvertFile;
import com.jalasoft.convert.model.convert.parameter.ConvertParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

@RestController
@RequestMapping("/v1")
public class ConvertController {

    @Autowired
    FileService fileService;

    @PostMapping("/convert")
    public ResponseEntity convertFile(@RequestParam(value = "extension") String extension,
                                      @RequestParam("file") MultipartFile inputFile) {


        ConvertFile convertFile = new ConvertFile();
        CastMultipartToFile convertToFile = new CastMultipartToFile();
        String fileInput;

        try {
            File file = convertToFile.convertMultiPartToFile(inputFile);
            ConvertParam param = new ConvertParam(file, new FileInputStream(file),
                    new FileOutputStream(fileService.store(inputFile)));
            param.validateParam();
            convertFile.convertFile(param);

            return ResponseEntity.ok().body(
                    new Response(extension + " file was converted successfully to PDF",
                            "", "200"));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(
                    new Response("", e.getMessage(), "400"));
        }

    }

}

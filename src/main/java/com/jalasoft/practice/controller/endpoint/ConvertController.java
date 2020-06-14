package com.jalasoft.practice.controller.endpoint;

import com.jalasoft.practice.common.exception.InvalidDataException;
import com.jalasoft.practice.controller.component.Properties;
import com.jalasoft.practice.controller.request.RequestConvertParameter;
import com.jalasoft.practice.controller.response.ErrorResponse;
import com.jalasoft.practice.controller.response.OkResponse;
import com.jalasoft.practice.controller.service.StoreInputFileService;
import com.jalasoft.practice.controller.service.StoreOutputFileService;
import com.jalasoft.practice.model.convert.ConvertFile;
import com.jalasoft.practice.model.convert.exception.ConvertException;
import com.jalasoft.practice.model.convert.parameter.ConvertFileParam;
import com.jalasoft.practice.model.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

@RestController
@RequestMapping("/api/v1")
public class ConvertController {
    @Autowired
    private Properties properties;

    @Autowired
    private StoreOutputFileService outputFileService;

    @Autowired
    private StoreInputFileService inputFileService;

    @PostMapping("/convert")
    public ResponseEntity convertFile(@RequestParam("file") MultipartFile inputFile) {
        ConvertFile convertFile = new ConvertFile();
        RequestConvertParameter parameter = new RequestConvertParameter(inputFile);

        try {
            parameter.validate();
            File file = inputFileService.store(parameter.getFile());
            File outputFile = outputFileService.store(parameter.getFile());
            ConvertFileParam param = new ConvertFileParam(file, outputFile);
            Result result = convertFile.convert(param);
            String fileDownLoadUri = outputFileService.getDownloadLink(outputFile);
            return ResponseEntity.ok().body(
                    new OkResponse<Integer>(fileDownLoadUri, HttpServletResponse.SC_OK));
        } catch (InvalidDataException ex) {
            return  ResponseEntity.badRequest().body(
                    new ErrorResponse<Integer>(ex.getMessage(), HttpServletResponse.SC_BAD_REQUEST)
            );
        } catch (ConvertException ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<Integer>(ex.getMessage(), HttpServletResponse.SC_BAD_REQUEST));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<Integer>(ex.getMessage(), HttpServletResponse.SC_BAD_REQUEST));
        }
    }
}

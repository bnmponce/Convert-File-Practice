package com.jalasoft.practice.controller.endpoint;

import com.jalasoft.practice.controller.exception.FileException;
import com.jalasoft.practice.controller.response.ErrorResponse;
import com.jalasoft.practice.controller.response.OkResponse;
import com.jalasoft.practice.controller.service.StoreInputFileService;
import com.jalasoft.practice.controller.service.StoreOutputFileService;
import com.jalasoft.practice.model.convert.ConvertFile;
import com.jalasoft.practice.model.convert.exception.ConvertException;
import com.jalasoft.practice.model.convert.exception.ParameterInvalidException;
import com.jalasoft.practice.model.convert.parameter.ConvertParam;
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
import java.io.FileInputStream;
import java.io.FileOutputStream;

@RestController
@RequestMapping("/v1")
public class ConvertController {

    @Autowired
    StoreOutputFileService outputFileService;

    @Autowired
    StoreInputFileService inputFileService;

    @PostMapping("/convert")
    public ResponseEntity convertFile(@RequestParam("file") MultipartFile inputFile) {
        ConvertFile convertFile = new ConvertFile();
        //CastMultipartToFile convertToFile = new CastMultipartToFile();
        String fileInput;

        try {
            File file = inputFileService.store(inputFile);
            ConvertParam param = new ConvertParam(file, new FileInputStream(file),
                    new FileOutputStream(outputFileService.store(inputFile)));
            param.validateParam();
            Result result = convertFile.convert(param);
            return ResponseEntity.ok().body(
                    new OkResponse<Integer>(result.getPathResult(), HttpServletResponse.SC_OK));
        } catch (FileException ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<Integer>(ex.getMessage(), HttpServletResponse.SC_BAD_REQUEST));
        } catch (ParameterInvalidException ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<Integer>(ex.getMessage(), HttpServletResponse.SC_BAD_REQUEST));
        } catch (ConvertException ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<Integer>(ex.getMessage(), HttpServletResponse.SC_BAD_REQUEST));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<Integer>(ex.getMessage(), HttpServletResponse.SC_BAD_REQUEST));
        }
    }
}

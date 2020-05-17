package com.jalasoft.convert.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;

import  java.io.IOException;


@RestController
@RequestMapping("/uploadFile")
public class HelloController {

    private static String uploadFolder = "D://dev-fundamentals-II//uploadFiles//";
    @PostMapping
    public String sayHello(@RequestParam(value="name") String name,
                           @RequestParam(value="lastName") String lname,
                           @RequestParam("file") MultipartFile inputFile) {
        if(inputFile.isEmpty()) {
            return "Please select a FIle and try again";
        }
        try {


            byte[] bytes = inputFile.getBytes();

            Path path = Paths.get(uploadFolder + inputFile.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Hello " + name + " " + lname + "file upload sucessfully";
    }
}

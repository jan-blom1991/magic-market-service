package com.jan.magicmarket.controllers;

import com.jan.magicmarket.domain.ProvisionalFile;
import com.jan.magicmarket.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    FileService fileService;

    @PostMapping("")
    public ProvisionalFile addProvisionalFile(@RequestParam("file") MultipartFile multipartFile, @RequestParam("fileGroupCode") Long fileGroupCode) throws IOException {
        return fileService.addProvisionalFile(multipartFile, fileGroupCode);
    }
}

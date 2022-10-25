package com.jan.magicmarket.controllers;

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
    public Long addProvisionalFile(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        return fileService.addProvisionalFile(multipartFile);
    }

    @GetMapping("/group")
    public Long getNewProvisionalFileGroup() {
        return fileService.getNewProvisionalFileGroup();
    }
}

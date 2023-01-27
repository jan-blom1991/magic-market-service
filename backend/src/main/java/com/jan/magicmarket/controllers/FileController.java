package com.jan.magicmarket.controllers;

import com.jan.magicmarket.config.rest.ResponseObject;
import com.jan.magicmarket.services.FileService;
import com.jan.magicmarket.transfer.FileDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/files")
public class FileController extends BaseController {

    @Autowired
    FileService fileService;

    @PostMapping("")
    public ResponseEntity<?> addProvisionalFile(@RequestParam("file") MultipartFile multipartFile,
                                                @RequestParam("fileGroupCode") Long fileGroupCode,
                                                HttpServletRequest request) throws IOException {

        ResponseObject<FileDetail> responseObject = fileService.addProvisionalFile(multipartFile, fileGroupCode);
        return generateResponse(responseObject, request);
    }
}

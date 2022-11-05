package com.jan.magicmarket.controllers;

import com.jan.magicmarket.config.rest.ResponseUtil;
import com.jan.magicmarket.services.FileService;
import com.jan.magicmarket.transfer.FileDetail;
import com.jan.magicmarket.transfer.TransferObject;
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
public class FileController {

    @Autowired
    FileService fileService;

    @PostMapping("")
    public ResponseEntity<?> addProvisionalFile(@RequestParam("file") MultipartFile multipartFile,
                                                @RequestParam("fileGroupCode") Long fileGroupCode,
                                                HttpServletRequest request) throws IOException {

        TransferObject<FileDetail> transferObject = fileService.addProvisionalFile(multipartFile, fileGroupCode);
        return ResponseUtil.buildSuccessResponse(transferObject, request);
    }
}

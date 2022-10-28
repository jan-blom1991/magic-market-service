package com.jan.magicmarket.services;

import com.jan.magicmarket.domain.ProvisionalFile;
import com.jan.magicmarket.repositories.ProductFileRepository;
import com.jan.magicmarket.repositories.ProvisionalFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Transactional
public class FileService {

    @Autowired
    ProductFileRepository productFileRepository;

    @Autowired
    ProvisionalFileRepository provisionalFileRepository;

    public ProvisionalFile addProvisionalFile(MultipartFile multipartFile, Long fileGroupCode) throws IOException {
        ProvisionalFile provisionalFile = new ProvisionalFile();
        provisionalFile.setFileName(multipartFile.getName());
        provisionalFile.setContentType(multipartFile.getContentType());
        provisionalFile.setSize(multipartFile.getSize());
        provisionalFile.setBytes(multipartFile.getBytes());

        if (fileGroupCode == null) {
            provisionalFile = provisionalFileRepository.save(provisionalFile);
            provisionalFile.setFileGroupCode(provisionalFile.getId());
        } else {
            provisionalFile.setFileGroupCode(fileGroupCode);
        }

        return provisionalFileRepository.save(provisionalFile);
    }
}

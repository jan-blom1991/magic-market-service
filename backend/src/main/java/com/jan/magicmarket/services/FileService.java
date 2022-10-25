package com.jan.magicmarket.services;

import com.jan.magicmarket.domain.ProvisionalFile;
import com.jan.magicmarket.repositories.FileRepository;
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
    FileRepository fileRepository;

    @Autowired
    ProvisionalFileRepository provisionalFileRepository;

    public Long addProvisionalFile(MultipartFile multipartFile) throws IOException {
        ProvisionalFile provisionalFile = new ProvisionalFile();
        provisionalFile.setFileName(multipartFile.getName());
        provisionalFile.setContentType(multipartFile.getContentType());
        provisionalFile.setSize(multipartFile.getSize());
        provisionalFile.setBytes(multipartFile.getBytes());

        return provisionalFileRepository.save(provisionalFile).getId();
    }

    public Long getNewProvisionalFileGroup() {
        return provisionalFileRepository.getMaxFileGroup() + 1;
    }
}

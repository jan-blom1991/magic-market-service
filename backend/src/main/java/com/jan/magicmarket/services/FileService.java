package com.jan.magicmarket.services;

import com.jan.magicmarket.model.ProvisionalFile;
import com.jan.magicmarket.repositories.ProductFileRepository;
import com.jan.magicmarket.repositories.ProvisionalFileRepository;
import com.jan.magicmarket.transfer.FileDetail;
import com.jan.magicmarket.transfer.TransferObject;
import com.jan.magicmarket.util.TransferObjectBuilder;
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

    public TransferObject<FileDetail> addProvisionalFile(MultipartFile multipartFile, Long fileGroupCode) throws IOException {
        ProvisionalFile provisionalFile = new ProvisionalFile();
        provisionalFile.setFileName(multipartFile.getOriginalFilename());
        provisionalFile.setContentType(multipartFile.getContentType());
        provisionalFile.setSize(multipartFile.getSize());
        provisionalFile.setBytes(multipartFile.getBytes());

        if (fileGroupCode == null) {
            provisionalFile = provisionalFileRepository.save(provisionalFile);
            provisionalFile.setFileGroupCode(provisionalFile.getId());
            provisionalFile.setOrder(ProvisionalFile.DEFAULT_ORDER);
        } else {
            provisionalFile.setFileGroupCode(fileGroupCode);
            provisionalFile.setOrder(provisionalFileRepository.findMaxOrderByFileGroupCode(fileGroupCode) + 1);
        }

        provisionalFile = provisionalFileRepository.save(provisionalFile);
        TransferObjectBuilder builder = new TransferObjectBuilder();
        return builder.generateFileDetail(provisionalFile);
    }
}

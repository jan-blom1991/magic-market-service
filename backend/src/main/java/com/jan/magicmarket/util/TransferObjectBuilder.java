package com.jan.magicmarket.util;

import com.jan.magicmarket.model.File;
import com.jan.magicmarket.model.Product;
import com.jan.magicmarket.model.ProvisionalFile;
import com.jan.magicmarket.model.User;
import com.jan.magicmarket.transfer.*;
import org.springframework.data.domain.Page;

import java.util.ArrayList;

public class TransferObjectBuilder {

    public TransferObject<ProductDetail> generateProductDetail(Product product) {

        TransferObject<ProductDetail> transferObject = new TransferObject<>();
        transferObject.changeToken = product.getTsChanged();
        transferObject.item = new ProductDetail(
                product.getId(),
                product.getName(),
                product.getCategory(),
                product.getDescription(),
                product.getStock(),
                product.getPrice(),
                product.getFiles()
        );

        return transferObject;
    }

    public TransferObject<ProductOverview> generateProductOverview(Page<Product> page) {

        int index = page.getPageable().getPageNumber() * page.getPageable().getPageSize() + 1;

        TransferObject<ProductOverview> transferObject = new TransferObject<>();
        transferObject.items = new ArrayList<>();
        transferObject.total = page.getTotalElements();

        for (Product product : page.getContent()) {
            File file = product.getFiles().stream().findFirst().orElse(null);
            transferObject.items.add(new ProductOverview(
                index++,
                product.getId(),
                product.getName(),
                product.getCategory(),
                product.getStock(),
                product.getPrice(),
                file
            ));
        }

        return transferObject;
    }

    public TransferObject<FileDetail> generateFileDetail(ProvisionalFile provisionalFile) {

        TransferObject<FileDetail> transferObject = new TransferObject<>();
        transferObject.changeToken = provisionalFile.getTsChanged();
        transferObject.item = new FileDetail(
                provisionalFile.getId(),
                provisionalFile.getFileName(),
                provisionalFile.getContentType(),
                provisionalFile.getSize(),
                provisionalFile.getBytes(),
                provisionalFile.getOrder(),
                provisionalFile.getFileGroupCode()
        );

        return transferObject;
    }

    public TransferObject<UserDetail> generateUserDetail(User user) {

        TransferObject<UserDetail> transferObject = new TransferObject<>();
        transferObject.changeToken = user.getTsChanged();
        transferObject.item = new UserDetail(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getGender(),
                user.getEmailAddress(),
                user.getIBAN(),
                user.getRole(),
                user.getActive()
        );

        return transferObject;
    }
}

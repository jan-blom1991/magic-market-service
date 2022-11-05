package com.jan.magicmarket.util;

import com.jan.magicmarket.model.File;
import com.jan.magicmarket.model.Product;
import com.jan.magicmarket.model.ProvisionalFile;
import com.jan.magicmarket.transfer.FileDetail;
import com.jan.magicmarket.transfer.ProductDetail;
import com.jan.magicmarket.transfer.ProductOverview;
import com.jan.magicmarket.transfer.TransferObject;
import org.springframework.data.domain.Page;

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
}

package com.jan.magicmarket.services;

import com.jan.magicmarket.domain.Product;
import com.jan.magicmarket.domain.ProductFile;
import com.jan.magicmarket.domain.ProvisionalFile;
import com.jan.magicmarket.repositories.ProductFileRepository;
import com.jan.magicmarket.repositories.ProductRepository;
import com.jan.magicmarket.repositories.ProvisionalFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductFileRepository productFileRepository;

    @Autowired
    ProvisionalFileRepository provisionalFileRepository;

    public Iterable<Product> getProducts() {
        return productRepository.findAll();
    }

    public void addProduct(Product product) {
        productRepository.save(product);

        if (product.getFileGroupCode() != null) {
            List<ProvisionalFile> provisionalFiles = provisionalFileRepository.findByFileGroupCode(product.getFileGroupCode());

            for (ProvisionalFile provisionalFile : provisionalFiles) {
                ProductFile productFile = new ProductFile();
                productFile.setId(provisionalFile.getId());
                productFile.setProduct(product);

                productFileRepository.save(productFile);
                provisionalFileRepository.deleteById(provisionalFile.getId());
            }
        }
    }

    public void removeProduct(Long id) {
        productRepository.deleteById(id);
    }
}

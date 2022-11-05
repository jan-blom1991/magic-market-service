package com.jan.magicmarket.services;

import com.jan.magicmarket.model.File;
import com.jan.magicmarket.model.Product;
import com.jan.magicmarket.model.ProductFile;
import com.jan.magicmarket.model.ProvisionalFile;
import com.jan.magicmarket.repositories.ProductFileRepository;
import com.jan.magicmarket.repositories.ProductRepository;
import com.jan.magicmarket.repositories.ProvisionalFileRepository;
import com.jan.magicmarket.transfer.ProductDetail;
import com.jan.magicmarket.transfer.ProductOverview;
import com.jan.magicmarket.transfer.TransferObject;
import com.jan.magicmarket.util.EntityNotFoundException;
import com.jan.magicmarket.util.ExceptionReference;
import com.jan.magicmarket.util.PageRequestUtil;
import com.jan.magicmarket.util.TransferObjectBuilder;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ProductService {

    @Resource
    ProductRepository productRepository;

    @Resource
    ProductFileRepository productFileRepository;

    @Resource
    ProvisionalFileRepository provisionalFileRepository;

    ExceptionReference<Product> reference = new ExceptionReference<>(Product.class);

    /**
     * Retrieves the specified {@link Product} for a detailed representation.
     * @param productId the identifier of the entity
     * @return a transfer object containing the {@link ProductDetail} data.
     */
    public TransferObject<ProductDetail> getProduct(@NonNull Long productId) throws Exception {
        Product product = productRepository.findById(productId).orElseThrow(Exception::new);
        Iterable<ProductFile> collection = productFileRepository.findAllByProductIdOrderByOrder(product.getId());
        collection.forEach(product.getFiles()::add);

        TransferObjectBuilder builder = new TransferObjectBuilder();
        return builder.generateProductDetail(product);
    }

    /**
     * Retrieves a specified number of {@link Product} entries to be represented in an overview.
     * @param sort the entity field to sort by
     * @param order the sorting direction
     * @param page the page number
     * @param size the number of rows in a page
     * @return a transfer object containing a list of {@link ProductOverview} data.
     */
    public TransferObject<ProductOverview> getProducts(@NonNull String sort,
                                                       @Nullable String order,
                                                       @Nullable Integer page,
                                                       @Nullable Integer size) {

        PageRequest request = PageRequestUtil.createRequest(sort, order, page, size);
        Page<Product> productPage = productRepository.findAll(request);

        for (Product product : productPage.getContent()) {
            Optional<ProductFile> optional = productFileRepository
                    .findByProductIdAndOrder(product.getId(), File.DEFAULT_ORDER);

            optional.ifPresent(file -> product.getFiles().add(file));
        }

        TransferObjectBuilder builder = new TransferObjectBuilder();
        return builder.generateProductOverview(productPage);
    }

    public TransferObject<ProductDetail> createProduct(@NonNull Product product) throws Exception {
        Long productId = productRepository.save(product).getId();

        if (product.getFileGroupCode() != null) {
            List<ProvisionalFile> provisionalFiles = provisionalFileRepository.findByFileGroupCode(product.getFileGroupCode());

            for (ProvisionalFile provisionalFile : provisionalFiles) {
                ProductFile productFile = new ProductFile();
                productFile.setId(provisionalFile.getId());
                productFile.setProduct(product);
                BeanUtils.copyProperties(provisionalFile, productFile);

                provisionalFileRepository.deleteById(provisionalFile.getId());
                productFileRepository.save(productFile);
            }
        }

        return getProduct(productId);
    }

    public TransferObject<ProductDetail> updateProduct(@NonNull Product product,
                                                       @NonNull LocalDateTime changeToken) throws Exception {

        reference.setId(product.getId());

        product = productRepository.findById(product.getId()).orElseThrow(() -> new EntityNotFoundException(reference));


        TransferObjectBuilder builder = new TransferObjectBuilder();
        return builder.generateProductDetail(productRepository.save(product));
    }

    public void removeProduct(@NonNull Long productId) {
        productRepository.deleteById(productId);
    }
}

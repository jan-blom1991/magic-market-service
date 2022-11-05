package com.jan.magicmarket.controllers;

import com.jan.magicmarket.config.rest.ResponseUtil;
import com.jan.magicmarket.model.Product;
import com.jan.magicmarket.services.ProductService;
import com.jan.magicmarket.transfer.ProductDetail;
import com.jan.magicmarket.transfer.ProductOverview;
import com.jan.magicmarket.transfer.TransferObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<?> getProduct(@PathVariable Long productId,
                                        HttpServletRequest request) throws Exception {

        TransferObject<ProductDetail> transferObject  = productService.getProduct(productId);
        return ResponseUtil.buildSuccessResponse(transferObject, request);
    }

    @GetMapping()
    public ResponseEntity<?> searchProducts(@RequestParam String sort,
                                            @RequestParam String order,
                                            @RequestParam Integer page,
                                            @RequestParam Integer size,
                                            HttpServletRequest request) {

        TransferObject<ProductOverview> transferObject = productService.getProducts(sort, order, page, size);
        return ResponseUtil.buildSuccessResponse(transferObject, request);
    }

    @PostMapping()
    public ResponseEntity<?> createProduct(@RequestBody Product product,
                                           HttpServletRequest request) throws Exception {

        TransferObject<ProductDetail> transferObject = productService.createProduct(product);
        return ResponseUtil.buildSuccessResponse(transferObject, request);
    }

    @PutMapping()
    public ResponseEntity<?> updateProduct(@RequestBody Product product,
                                           HttpServletRequest request) throws Exception {

        TransferObject<ProductDetail> transferObject = productService.createProduct(product);
        return ResponseUtil.buildSuccessResponse(transferObject, request);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId,
                                           HttpServletRequest request) {

        productService.removeProduct(productId);
        return ResponseUtil.buildSuccessResponse(null, request);
    }
}

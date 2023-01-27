package com.jan.magicmarket.controllers;

import com.jan.magicmarket.config.rest.ResponseObject;
import com.jan.magicmarket.model.Product;
import com.jan.magicmarket.services.ProductService;
import com.jan.magicmarket.transfer.ProductDetail;
import com.jan.magicmarket.transfer.ProductOverview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/products")
public class ProductController extends BaseController {

    @Autowired
    ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<?> getProduct(@PathVariable Long productId,
                                        HttpServletRequest request) {

        ResponseObject<ProductDetail> responseObject = productService.getProduct(productId);
        return generateResponse(responseObject, request);
    }

    @GetMapping()
    public ResponseEntity<?> searchProducts(@RequestParam String sort,
                                            @RequestParam String order,
                                            @RequestParam Integer page,
                                            @RequestParam Integer size,
                                            HttpServletRequest request) {

        ResponseObject<ProductOverview> responseObject = productService.getProducts(sort, order, page, size);
        return generateResponse(responseObject, request);
    }

    @PostMapping()
    public ResponseEntity<?> createProduct(@RequestBody Product product,
                                           HttpServletRequest request) {

        ResponseObject<ProductDetail> responseObject  = productService.createProduct(product);
        return generateResponse(responseObject, request);
    }

    @PutMapping()
    public ResponseEntity<?> updateProduct(@RequestBody Product product,
                                           HttpServletRequest request) {

        ResponseObject<ProductDetail> responseObject = productService.createProduct(product);
        return generateResponse(responseObject, request);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId,
                                           HttpServletRequest request) {

        productService.removeProduct(productId);
        return null;
    }
}

package com.jan.magicmarket.controllers;

import com.jan.magicmarket.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    ProductService productService;

//    @PostMapping("")
//    public void addImageToProduct(@RequestParam long productId, @RequestBody MultipartFile[] files) throws IOException {
////        productService.addImagesToProduct(productId, files);
//    }

}

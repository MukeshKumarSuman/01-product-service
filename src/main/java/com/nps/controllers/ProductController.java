package com.nps.controllers;

import com.nps.exception.ProductNotFoundException;
import com.nps.models.Product;
import com.nps.services.FreemarkerRenderingService;
import com.nps.services.ProductService;
import freemarker.template.TemplateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final FreemarkerRenderingService freemarkerRenderingService;

    public ProductController(ProductService productService, FreemarkerRenderingService freemarkerRenderingService) {
        this.productService = productService;
        this.freemarkerRenderingService = freemarkerRenderingService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.replaceProduct(id, product);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/pdf")
    public ResponseEntity<byte[]> getPdf() throws TemplateException, IOException {
        return new ResponseEntity<>(freemarkerRenderingService.generatePdf(), HttpStatus.OK);
    }
}

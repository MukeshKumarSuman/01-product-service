package com.nps.services;

import com.nps.exception.ProductNotFoundException;
import com.nps.models.Product;
import com.nps.repository.CategoryRepository;
import com.nps.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
//        Product p = productRepository.myQuery(id);
        if(optionalProduct.isEmpty()) {
            throw new ProductNotFoundException(id, "No product with given id");
        }
        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        if (product.getCategory().getId() == null) {
            this.categoryRepository.save(product.getCategory());
        }
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct() {

    }
}

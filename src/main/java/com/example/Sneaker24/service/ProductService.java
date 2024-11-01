package com.example.Sneaker24.service;

import com.example.Sneaker24.entity.Product;
import com.example.Sneaker24.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

    public Product updateProduct(Long id, Product updatedProduct){
        Optional<Product> existingProduct = productRepository.findById(id);
        if(existingProduct.isPresent()){
            Product product = existingProduct.get();
            product.setBrand(updatedProduct.getBrand());
            product.setModel(updatedProduct.getModel());
            product.setPrice(updatedProduct.getSize());
            product.setSize(updatedProduct.getSize());
            product.setQuantity(updatedProduct.getQuantity());
            return productRepository.save(product);
        }else{
            throw new RuntimeException("Product not Found");
        }
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
}

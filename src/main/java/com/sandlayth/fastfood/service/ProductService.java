package com.sandlayth.fastfood.service;

import com.sandlayth.fastfood.entity.Product;
import com.sandlayth.fastfood.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getProducts() { return productRepository.findAll();}
    public Product getProductById(Long id) { return productRepository.findById(id).orElse(null); }

    public Product saveProduct(Product product) { return productRepository.save(product);}
    public List<Product> saveProducts(List<Product> products) { return productRepository.saveAll(products);}

    public void deleteProduct(Product product) { productRepository.delete(product);}

    public Product updateProduct(Product product) {
        Product p = productRepository.findById(product.getId()).orElse(product);

        return productRepository.save(p);
    }

}

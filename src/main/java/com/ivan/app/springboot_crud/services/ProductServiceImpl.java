package com.ivan.app.springboot_crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ivan.app.springboot_crud.entities.Product;
import com.ivan.app.springboot_crud.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    
    @Override
    @Transactional
    public Product save(Product product) {
        return repository.save(product);
    }
        
    @Transactional
    @Override
    public Optional<Product> update(Long id, Product product) {
        Optional<Product> productDb = repository.findById(id);
        if (productDb.isPresent())
        {
            Product prod = productDb.orElseThrow();
            prod.setSku(product.getSku() != null ? product.getSku() : product.getSku());
            prod.setName(product.getName() != null ? product.getName() : prod.getName());
            prod.setDescription(product.getDescription() != null ? product.getDescription() : prod.getDescription());
            prod.setPrice(product.getPrice() != null ? product.getPrice() : prod.getPrice());
            return Optional.of(repository.save(prod));
        }
        return productDb;
    }

    @Override
    @Transactional
    public Optional<Product> delete(Long id) {
        Optional<Product> productDb = repository.findById(id);
        productDb.ifPresent(prod -> {
            repository.delete(prod);
        });

        return productDb;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsBySku(String sku){
        return repository.existsBySku(sku);
    }


}

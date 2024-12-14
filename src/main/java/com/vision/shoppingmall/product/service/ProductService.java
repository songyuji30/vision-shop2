package com.vision.shoppingmall.product.service;

import com.vision.shoppingmall.product.model.entity.Product;
import com.vision.shoppingmall.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void removeCategory(List<Product> products) {
        //1. 카테고리 id를 null로 변경
        products.forEach(product -> {
            product.setCategory(null);
            productRepository.save(product);
        });
    }

}

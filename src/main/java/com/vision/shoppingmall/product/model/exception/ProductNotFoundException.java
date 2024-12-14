package com.vision.shoppingmall.product.model.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() {
        super("해당 제품을 찾을 수 없습니다.");
    }
}

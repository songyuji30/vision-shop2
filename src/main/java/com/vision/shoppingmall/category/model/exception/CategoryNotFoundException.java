package com.vision.shoppingmall.category.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException() {
        super("해당 카테고리를 찾을 수 없습니다.");
    }
}

package com.vision.shoppingmall.category.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateCategoryRequest {

    @NotBlank(message = "카테고리 이름은 비어 있을 수 없습니다.")
    private String categoryName;

}

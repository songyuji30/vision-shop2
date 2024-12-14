package com.vision.shoppingmall.product.model.request;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateProductRequest {
    @NotNull(message= "상품 Id값은 필수 항목입니다.")
    private Long id;

    @NotBlank(message = "상품명은 필수 입력 항목입니다.")
    @Size(max = 50, message = "상품명은 최대 50자까지 입력 가능합니다.")
    private String productName;

    private Long categoryId; // 카테고리 ID는 null 가능

    @NotBlank(message = "출판사 이름은 필수 입력 항목입니다.")
    @Size(max = 50, message = "출판사 이름은 최대 50자까지 입력 가능합니다.")
    private String publisherName;

    @NotBlank(message = "저자 이름은 필수 입력 항목입니다.")
    @Size(max = 50, message = "저자 이름은 최대 50자까지 입력 가능합니다.")
    private String authorName;

    @Size(max = 50, message = "번역자 이름은 최대 50자까지 입력 가능합니다.")
    private String translatorName;

    @NotBlank(message = "소개글은 필수 입력 항목입니다.")
    private String description;

    @Positive(message = "매입 가격은 0보다 큰 값을 입력해야 합니다.")
    private int purchasePrice;

    @Positive(message = "단가(원가)는 0보다 큰 값을 입력해야 합니다.")
    private int unitPrice;

    @PositiveOrZero(message = "할인가격은 0 이상이어야 합니다.")
    private int discountPrice;

    @Positive(message = "판매 가격은 0보다 큰 값을 입력해야 합니다.")
    private int sellingPrice;

    @NotBlank(message = "썸네일 이미지는 필수 입력 항목입니다.")
    private String thumbnailImageData;

    @NotBlank(message = "상세 이미지는 필수 입력 항목입니다.")
    private String detailImageData;
}

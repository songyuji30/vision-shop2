package com.vision.shoppingmall.product.model.response;

import com.vision.shoppingmall.product.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductResponse {
    private Long id;
    private String productName;
    private Long categoryId;

    private String publisherName;
    private String authorName;
    private String translatorName;
    private String description;

    private int purchasePrice;
    private int unitPrice;
    private int discountPrice;
    private int sellingPrice;
    private String thumbnailImageData;
    private String detailImageData;

    public static ProductResponse from(Product product) {
        return new ProductResponse(
            product.getId(),
            product.getProductName(),
            product.getCategory() != null ? product.getCategory().getId(): null,
            product.getPublisherName(),
            product.getAuthorName(),
            product.getTranslatorName(),
            product.getDescription(),
            product.getPurchasePrice(),
            product.getUnitPrice(),
            product.getDiscountPrice(),
            product.getSellingPrice(),
            product.getThumbnailImageData(),
            product.getProductImageData()
        );
    }
}

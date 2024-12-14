package com.vision.shoppingmall.product.model.response;

import com.vision.shoppingmall.product.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductListResponse {
    private Long id;
    private String productName;
    private String publisherName;
    private String authorName;
    private String translatorName;

    private int purchasePrice;
    private int unitPrice;
    private int discountPrice;
    private int sellingPrice;

    public static ProductListResponse from(Product product) {
        return new ProductListResponse(
                product.getId(),
                product.getProductName(),
                product.getPublisherName(),
                product.getAuthorName(),
                product.getTranslatorName(),
                product.getPurchasePrice(),
                product.getUnitPrice(),
                product.getDiscountPrice(),
                product.getSellingPrice()
        );
    }
}

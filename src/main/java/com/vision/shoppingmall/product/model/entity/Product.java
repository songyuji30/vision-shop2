package com.vision.shoppingmall.product.model.entity;

import com.vision.shoppingmall.category.model.entity.Category;
import com.vision.shoppingmall.product.model.request.CreateProductRequest;
import com.vision.shoppingmall.product.model.request.UpdateProductRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@Entity(name = "products")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "product_name", nullable = false, length = 50)
    private String productName;

    @Column(name = "publisher_name", nullable = false, length = 50)
    private String publisherName;

    @Column(name = "author_name", nullable = false, length = 50)
    private String authorName;

    @Column(name = "translator_name", length = 50)
    private String translatorName;

    @Column(name = "purchase_price", nullable = false)
    private int purchasePrice;

    @Column(name = "unit_price", nullable = false)
    private int unitPrice;

    @Column(name = "discount_price")
    private int discountPrice;

    @Column(name = "selling_price", nullable = false)
    private int sellingPrice;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "thumbnail_image_data", nullable = false, columnDefinition = "LONGTEXT")
    private String thumbnailImageData;

    @Column(name = "product_image_data", nullable = false, columnDefinition = "LONGTEXT")
    private String productImageData;

    @Enumerated(EnumType.STRING)
    @Column(name = "product_status", nullable = false, length = 10)
    private ProductStatus productStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = true,
    foreignKey = @ForeignKey(name = "fk_product_category"))
    private Category category;

    public static Product create(CreateProductRequest request, Category category) {
        return Product.builder()
                .productName(request.getProductName())
                .publisherName(request.getPublisherName())
                .authorName(request.getAuthorName())
                .translatorName(request.getTranslatorName())
                .purchasePrice(request.getPurchasePrice())
                .unitPrice(request.getUnitPrice())
                .discountPrice(request.getDiscountPrice())
                .sellingPrice(request.getSellingPrice())
                .description(request.getDescription())
                .thumbnailImageData(request.getThumbnailImageData())
                .productImageData(request.getDetailImageData())
                .productStatus(ProductStatus.ACTIVE)
                .category(category)
                .build();
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void update(UpdateProductRequest request, Category category) {
        this.productName = request.getProductName();
        this.publisherName = request.getPublisherName();
        this.authorName = request.getAuthorName();
        this.translatorName = request.getTranslatorName();
        this.description = request.getDescription();
        this.purchasePrice = request.getPurchasePrice();
        this.unitPrice = request.getUnitPrice();
        this.sellingPrice = request.getSellingPrice();
        this.discountPrice = request.getDiscountPrice();
        this.thumbnailImageData = request.getThumbnailImageData();
        this.productImageData = request.getDetailImageData();
        this.category = category;
    }

    public void delete() {
        this.productStatus = ProductStatus.INACTIVE;
    }
}

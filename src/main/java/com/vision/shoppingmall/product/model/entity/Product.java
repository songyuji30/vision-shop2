package com.vision.shoppingmall.product.model.entity;

import com.vision.shoppingmall.category.model.entity.Category;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity(name = "products")
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

    public void setCategory(Category category) {
        this.category = category;
    }
}

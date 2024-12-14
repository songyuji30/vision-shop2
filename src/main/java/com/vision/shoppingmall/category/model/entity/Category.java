package com.vision.shoppingmall.category.model.entity;

import com.vision.shoppingmall.category.model.request.CreateCategoryRequest;
import com.vision.shoppingmall.product.model.entity.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Builder
@Entity(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Product> products;

    public static Category create(CreateCategoryRequest request) {
        return Category.builder()
                .categoryName(request.getCategoryName())
                .build();
    }

    public void update(String categoryName) {
        this.setCategoryName(categoryName);
    }
}








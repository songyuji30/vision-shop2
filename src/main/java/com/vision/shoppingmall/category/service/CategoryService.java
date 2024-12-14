package com.vision.shoppingmall.category.service;

import com.vision.shoppingmall.category.model.entity.Category;
import com.vision.shoppingmall.category.model.exception.CategoryHasProductsException;
import com.vision.shoppingmall.category.model.exception.CategoryNameDuplicationException;
import com.vision.shoppingmall.category.model.exception.CategoryNotFoundException;
import com.vision.shoppingmall.category.model.request.CategoryResponse;
import com.vision.shoppingmall.category.model.request.CategoryUpdateRequest;
import com.vision.shoppingmall.category.model.request.CreateCategoryRequest;
import com.vision.shoppingmall.category.model.response.CategoryCreateResponse;
import com.vision.shoppingmall.category.model.response.CategoryListResponse;
import com.vision.shoppingmall.category.repository.CategoryRepository;
import com.vision.shoppingmall.product.model.entity.Product;
import com.vision.shoppingmall.product.model.entity.ProductStatus;
import com.vision.shoppingmall.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductService productService;

    public CategoryCreateResponse create(CreateCategoryRequest request) {
        //1. 카테고리 이름 중복 검사
        if (categoryRepository.existsByCategoryName(request.getCategoryName()))
            throw new CategoryNameDuplicationException();

        //2. 카테고리 생성
        Category category = Category.create(request);
        Category createdCategory = categoryRepository.save(category);
        return new CategoryCreateResponse(
                createdCategory.getId(),
                createdCategory.getCategoryName());
    }

    public Page<CategoryListResponse> getCategories(int page) {
        PageRequest request = PageRequest.of(page, 10);
        Page<Category> categoryList
                = categoryRepository.findAll(request);

        return categoryList
            .map(category ->
                new CategoryListResponse(
                    category.getId(),
                    category.getCategoryName(),
                    category.getProducts().stream()
                        .filter(product ->
                            product.getProductStatus() == ProductStatus.ACTIVE)
                            .count()
                    )
            );

    }

    public List<CategoryResponse> getAllCategories() {
        List<Category> categories
                = categoryRepository.findAll();

        return categories.stream()
            .map(category ->
                 new CategoryResponse(
                         category.getId(),
                         category.getCategoryName()
                 )
            ).toList();
    }


    public CategoryResponse fingCategory(Long id) {
        Category category
                = categoryRepository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);

        return new CategoryResponse(
                category.getId(),
                category.getCategoryName()
        );
    }

    public void update(Long id, CategoryUpdateRequest request) {
        //1. 해당 카테고리가 존재하는지 검증
        Category category
                = categoryRepository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);
        //2. 해당 카테고리명 중복 검사
        if (categoryRepository.existsByCategoryNameAndIdNot(
                request.getCategoryName(), id)
        )
            throw new CategoryNameDuplicationException();

        //3. 카테고리 이름 수정
        category.update(request.getCategoryName());
        categoryRepository.save(category);
    }

    @Transactional
    public void deleteCategory(Long id) {
        //1. 카테고리가 존재하는지 확인
        Category category
                = categoryRepository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);

        boolean hasActiveProducts = category.getProducts().stream()
            .anyMatch(product ->
                product.getProductStatus() == ProductStatus.ACTIVE);
        if(hasActiveProducts)
            throw new CategoryHasProductsException();

        List<Product> inActiveProducts
          = category.getProducts().stream()
            .filter(product ->
                product.getProductStatus() == ProductStatus.INACTIVE)
                    .toList();

        productService.removeCategory(inActiveProducts);

        //2. 카테고리 삭제
        categoryRepository.delete(category);
    }


}






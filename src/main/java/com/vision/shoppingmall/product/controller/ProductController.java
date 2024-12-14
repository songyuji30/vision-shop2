package com.vision.shoppingmall.product.controller;

import com.vision.shoppingmall.product.model.request.CreateProductRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {


    @GetMapping("")
    public String getProductList() {
        return "product/list";
    }

    @GetMapping("/new-product")
    public String getProductForm(Model model) {
        model.addAttribute("product", new CreateProductRequest());
        return "product/product-form";
    }

}

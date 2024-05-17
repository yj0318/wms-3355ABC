package com.abc3355.abc_wms_system.Product;

import com.abc3355.abc_wms_system.Product.model.service.ProductService;

public class PTest {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        int i = productService.selectAll();

        System.out.println(i);
    }
}
